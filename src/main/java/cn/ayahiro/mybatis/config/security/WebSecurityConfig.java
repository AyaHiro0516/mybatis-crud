package cn.ayahiro.mybatis.config.security;

import cn.ayahiro.mybatis.service.impl.UserDetailsServiceImpl;
import cn.ayahiro.mybatis.utils.MD5Util;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @Author ayahiro
 * @Description:
 * @Create: 2019/9/26
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static String[] WHITE_LIST = {"/user/register", "/student/index"};

    @Resource(name = "userDetailsServiceImpl")
    private UserDetailsServiceImpl userDetailsService;

    @Resource(name = "authenticationSuccessHandler")
    private AuthenticationSuccessHandler successHandler;

    @Resource(name = "authenticationFailHandler")
    private AuthenticationFailHandler failHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new PasswordEncoder() {

            @Override
            public String encode(CharSequence rawPassword) {
                return MD5Util.encode((String) rawPassword);
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encodedPassword.equals(MD5Util.encode((String) rawPassword));
            }
        }); //user Details Service验证
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http
                .authorizeRequests();

        registry.and()
                .formLogin() //表单登录方式
                .permitAll()
                .successHandler(successHandler) //设置自定义成功处理类
                .failureHandler(failHandler) //设置自定义失败处理类
                .and()
                .logout()
                .permitAll()
                .and()
                .authorizeRequests() //验证策略
                .antMatchers(WHITE_LIST).permitAll() //白名单放行
                .anyRequest().authenticated() //其他请求都需要认证
                .and()
                .csrf().disable(); //关闭跨站检测
                //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); //前后端分离采用JWT 不需要session
    }
}

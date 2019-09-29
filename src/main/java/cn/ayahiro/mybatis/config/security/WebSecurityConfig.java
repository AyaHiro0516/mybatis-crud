package cn.ayahiro.mybatis.config.security;

import cn.ayahiro.mybatis.config.jwt.JWTAuthenticationFilter;
import cn.ayahiro.mybatis.config.jwt.JWTAuthorizationFilter;
import cn.ayahiro.mybatis.service.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

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

//    @Resource(name = "authenticationSuccessHandler")
//    private AuthenticationSuccessHandler successHandler;
//
//    @Resource(name = "authenticationFailHandler")
//    private AuthenticationFailHandler failHandler;

    @Bean("bCryptPasswordEncoder")
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(WHITE_LIST).permitAll() //白名单放行
                .anyRequest().authenticated() //其他请求都需要认证
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                // 不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http
//                .authorizeRequests();
//        registry.and()
//                .formLogin() //表单登录方式
//                .permitAll()
//                .successHandler(successHandler) //设置自定义成功处理类
//                .failureHandler(failHandler) //设置自定义失败处理类
//                .and()
//                .logout()
//                .permitAll()
//                .and()
//                .authorizeRequests() //验证策略
//                .antMatchers(WHITE_LIST).permitAll() //白名单放行
//                .anyRequest().authenticated() //其他请求都需要认证
//                .and()
//                .csrf().disable(); //关闭跨站检测
    }

    @Bean("corsConfigurationSource")
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }
}

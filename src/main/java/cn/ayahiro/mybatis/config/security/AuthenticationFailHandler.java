package cn.ayahiro.mybatis.config.security;

import cn.ayahiro.mybatis.entity.Result;
import cn.ayahiro.mybatis.utils.ResponseUtil;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author ayahiro
 * @Description:
 * @Create: 2019/9/26
 */
@Component("authenticationFailHandler")
public class AuthenticationFailHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {

        if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
            ResponseUtil.out(response, new Result(false, "用户名或密码错误"));
        } else if (e instanceof DisabledException) {
            ResponseUtil.out(response, new Result(false, "账户被禁用，请联系管理员"));
        } else {
            ResponseUtil.out(response, new Result(false, "登录失败，其他内部错误"));
        }
    }
}

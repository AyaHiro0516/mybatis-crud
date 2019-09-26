package cn.ayahiro.mybatis.config.security;

import cn.ayahiro.mybatis.entity.Result;
import cn.ayahiro.mybatis.utils.ResponseUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author ayahiro
 * @Description:
 * @Create: 2019/9/26
 */
@Component("authenticationSuccessHandler")
public class AuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String username = ((UserDetails) authentication.getPrincipal()).getUsername();
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) ((UserDetails) authentication.getPrincipal()).getAuthorities();
        System.out.println("用户：{" + username + "}登录成功, 角色：{" + authorities.get(0) + "}");
        ResponseUtil.out(response, new Result(true, "登录成功"));
    }
}

package cn.ayahiro.mybatis.service.impl;

import cn.ayahiro.mybatis.entity.SecurityUserDetails;
import cn.ayahiro.mybatis.entity.User;
import cn.ayahiro.mybatis.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author ayahiro
 * @Description:
 * @Create: 2019/9/26
 */
@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService{

    @Resource(name = "userServiceImpl")
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userService.findByUsername(username);
        return new SecurityUserDetails(user);
    }
}

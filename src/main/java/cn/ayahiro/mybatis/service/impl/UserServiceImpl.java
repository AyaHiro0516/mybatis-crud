package cn.ayahiro.mybatis.service.impl;

import cn.ayahiro.mybatis.entity.User;
import cn.ayahiro.mybatis.mapper.UserMapper;
import cn.ayahiro.mybatis.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author ayahiro
 * @Description:
 * @Create: 2019/9/26
 */
@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        userMapper.register(user);
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}

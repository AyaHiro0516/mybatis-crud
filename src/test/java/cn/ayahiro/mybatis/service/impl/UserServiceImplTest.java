package cn.ayahiro.mybatis.service.impl;

import cn.ayahiro.mybatis.entity.User;
import cn.ayahiro.mybatis.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    @Test
    public void register() throws Exception {
        userMapper.register(new User("bxy", "123", "admin", "all"));
    }

    @Test
    public void findByUsername() throws Exception {
        System.out.println(userMapper.findByUsername("bxy").toString());
    }

}
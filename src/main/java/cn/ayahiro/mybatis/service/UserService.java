package cn.ayahiro.mybatis.service;

import cn.ayahiro.mybatis.entity.User;

public interface UserService {
    void register(User user);

    User findByUsername(String username);
}

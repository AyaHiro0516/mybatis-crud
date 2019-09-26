package cn.ayahiro.mybatis.mapper;

import cn.ayahiro.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("userMapper")
public interface UserMapper {
    void register(User user);

    User findByUsername(String username);
}

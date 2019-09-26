package cn.ayahiro.mybatis.controller;

import cn.ayahiro.mybatis.entity.Result;
import cn.ayahiro.mybatis.entity.User;
import cn.ayahiro.mybatis.service.UserService;
import cn.ayahiro.mybatis.utils.MD5Util;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author ayahiro
 * @Description:
 * @Create: 2019/9/26
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource(name = "userServiceImpl")
    private UserService userService;

    @RequestMapping(path = {"/register"}, method = RequestMethod.POST)
    public Result register(@RequestBody User user) {
        try {
            user.setPassword(MD5Util.encode(user.getPassword()));
            userService.register(user);
            return new Result(true, "创建成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "发生未知错误");
        }
    }

    @RequestMapping(path = {"/findByUsername"}, method = RequestMethod.GET)
    public User findByUsername(@RequestParam(value = "username", required = false) String username) {
        return userService.findByUsername(username);
    }
}

package com.test.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.test.demo.entity.User;
import com.test.demo.service.UserService;
import com.test.demo.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        User userData = userService.getOne(new QueryWrapper<>(user));
        if (userData != null) {
            if (userData.getUsername().equals(user.getUsername()) && userData.getPassword().equals(user.getPassword())) {
                //添加token
                user.setToken(JwtUtil.createToken(user.getUsername(), user.getPassword()));
                return user;
            }
        }
        return null;
    }

    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.list();
    }

}

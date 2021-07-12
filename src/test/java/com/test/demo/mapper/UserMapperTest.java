package com.test.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.test.demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        System.out.println("----------------test---------------");
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testUser(){
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("1234");
        User user1 = userMapper.selectOne(new QueryWrapper<>(user));
        System.out.println("user1 = " + user1);
    }
}

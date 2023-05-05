package com.back;

import com.back.mapper.UserMapper;
import com.back.pojo.User;
import com.back.service.UserService;
import com.back.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BackApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getAllUserTest(){
        List<User> userList = userService.getAllUser();
        System.out.println(userList);
    }

    @Test
    public void addUserTest(){
        User user = new User();
        user.setUserId(12);
        user.setUserName("zzw");
        user.setPassword("123");
        int isSuccessAdd = userMapper.insertUser(user);
        System.out.println(isSuccessAdd);
    }

}

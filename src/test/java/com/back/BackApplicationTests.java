package com.back;

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

    @Test
    public void getAllUserTest(){
        List<User> userList = userService.getAllUser();
        System.out.println(userList);
    }

}

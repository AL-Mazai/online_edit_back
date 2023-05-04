package com.back.controller;

import com.back.pojo.User;
import com.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getAll")
    @ResponseBody
    public List<User> ListUser() {
        return userService.getAllUser();
    }

    public int getUser(Integer id){
        return 0;
    }
}

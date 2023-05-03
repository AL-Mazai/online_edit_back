package com.back.service.impl;

import com.back.mapper.UserMapper;
import com.back.pojo.User;
import com.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUser(){
        List<User> userList = userMapper.getAllUser();
        return userList;
    }

}

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

    public List<User> getAllUser() {
        List<User> userList = userMapper.getAllUser();
        return userList;
    }

    @Override
    public User login(String email, String password) {
        //通过用户名找到对应的用户
        User user = userMapper.selectUserByEmail(email);
        //比对
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public boolean register(User user) {
        if(userMapper.selectUserById(user.getUserId()) == null){
            int isRegisterSuccess = userMapper.insertUser(user);
            if(isRegisterSuccess > 0){
                return true;
            }
        }
        return false;
    }

}

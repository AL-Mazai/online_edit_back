package com.back.service.impl;

import com.back.mapper.UserMapper;
import com.back.pojo.Document;
import com.back.pojo.User;
import com.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUser() {
        List<User> userList = userMapper.selectAllUser();
        return userList;
    }

    @Override
    public User login(String email, String password) {
        //通过邮箱找到对应的用户
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

    @Override
    public boolean changePassword(String email,String oldPassword,String newPassword){
        User user = userMapper.selectUserByEmail(email);
        if(user.getPassword().equals(oldPassword)){
            int isChangeSuccess = userMapper.updatePassword(email,newPassword);
            if (isChangeSuccess > 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean changeUserInfo(User user) {
        int isChangeSuccess = userMapper.updateUserInfo(user);
        if(isChangeSuccess > 0){
            return true;
        }
        return false;
    }

    @Override
    public User getUserInfo(Integer userId) {
        User user = userMapper.selectUserById(userId);
        if(user != null){
            return user;
        }
        return null;
    }

    @Override
    public List<Document> getAllDocCreateByUser(Integer userId) {
        List<Document> documentList = userMapper.selectAllDocCreateByUser(userId);
        return documentList;
    }
}

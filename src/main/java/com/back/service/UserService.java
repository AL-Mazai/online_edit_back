package com.back.service;


import com.back.pojo.User;
import java.util.List;

public interface UserService {
    /**
     * 查找所有用户(测试方法)
     * @return
     */
    public List<User> getAllUser();

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    User login(String username, String password);
}

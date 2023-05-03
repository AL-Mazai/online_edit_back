package com.back.service;


import com.back.pojo.User;
import java.util.List;

public interface UserService {
    /**
     * 查找所有用户(测试方法)
     * @return
     */
    public List<User> getAllUser();
}

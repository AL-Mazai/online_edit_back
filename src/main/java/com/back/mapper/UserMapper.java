package com.back.mapper;


import com.back.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper{
    public List<User> getAllUser();


    /**
     *登录方法：先通过前端传过来的用户名找到用户，然后进行密码的比对
     * @param username
     * @return
     */
    User getUserByUsername(String username);
}

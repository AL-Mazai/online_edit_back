package com.back.mapper;


import com.back.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper{
    /**
     * 查找所有用户
     * @return
     */
    public List<User> getAllUser();

    /**
     * 通过id查找用户
     * @param userId
     * @return
     */
    User selectUserById(Integer userId);

    /**
     *登录：先通过前端传过来的邮箱找到用户，然后进行密码的比对
     * @param email
     * @return
     */
    User selectUserByEmail(String email);

    /**
     * 注册（添加用户）：前端填好注册的表单信息后将其封装成一个JavaScript对象，然后通过Ajax请求将其发送到后端。后端将接收到的JSON格式的数据解析成Java对象，最后根据具体业务逻辑将这些数据保存到数据库中
     * @param user
     * @return
     */
    int insertUser(User user);
}

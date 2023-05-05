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
     * @param email
     * @param password
     * @return 是否登陆成功
     */
    User login(String email, String password);

    /**
     *
     * @param user
     * @return 是否注册成功
     */
    boolean register(User user);

    /**
     *
     * @param email
     * @param oldPassword
     * @param newPassword
     * @return 是否修改成功
     */
    boolean changePassword(String email,String oldPassword,String newPassword);
}

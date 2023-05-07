package com.back.service;


import com.back.pojo.Document;
import com.back.pojo.User;
import java.util.List;

public interface UserService {
    /**
     * 查找所有用户(测试方法)
     * @return
     */
    List<User> getAllUser();

    /**
     * 用户登录
     * @param email
     * @param password
     * @return 是否登陆成功
     */
    User login(String email, String password);

    /**
     * 用户注册
     * @param user
     * @return 是否注册成功
     */
    boolean register(User user);

    /**
     * 修改密码
     * @param email
     * @param oldPassword
     * @param newPassword
     * @return 是否修改成功
     */
    boolean changePassword(String email,String oldPassword,String newPassword);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    boolean changeUserInfo(User user);

    /**
     * 根据id查看用户信息
     * @param userId
     * @return
     */
    User getUserInfo(Integer userId);

    /**
     * 查询当前用户所有创建的所有文档
     * @param userId
     * @return
     */
    List<Document> getAllDocCreateByUser(Integer userId);

    /**
     * 查询当前用户参与的所有文档（不包括创建的文档）
     * @param userId
     * @return
     */
    List<Document> getAllDocParticipate(Integer userId);
}

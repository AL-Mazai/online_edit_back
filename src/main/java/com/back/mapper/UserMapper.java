package com.back.mapper;


import com.back.pojo.Document;
import com.back.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  UserMapper{
    /**
     * 查找所有用户
     * @return
     */
    List<User> selectAllUser();

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

    /**
     * 根据前端传过来的用户对象，修改用户的信息
     * 赵负责（已完成）
     * @param user
     * @return
     */
    int updateUserInfo(User user);

    /**
     * 前端传过来的新密码，后端更改密码
     * 聂负责（已完成）
     * @param password
     * @return
     */
    int updatePassword(@Param("email") String email, @Param("password") String password);

    /**
     * 根据用户id查看当前用户创建的所有文档（不包括用户参与的文档）
     * 赵负责
     * @param userId
     * @return
     */
    List<Document> selectAllDocCreateByUser(Integer userId);

    /**
     * 前端用户查看目前参与的所有文档（不包括用户自己创建的文档）(前端可添加按钮方便用户决定是否退出，编辑查看等)
     * 聂负责
     * @param userId
     * @return
     */
    List<Document> selectAllDocParticipate(Integer userId);

}

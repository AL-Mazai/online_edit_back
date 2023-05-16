package com.back.mapper;


import com.back.pojo.Document;
import com.back.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    /**
     * 查找所有用户
     *
     * @return
     */
    List<User> selectAllUser();

    /**
     * 通过id查找用户
     *
     * @param userId
     * @return
     */
    User selectUserById(Integer userId);

    /**
     * 登录：先通过前端传过来的邮箱找到用户，然后进行密码的比对
     * @param email
     * @return
     */
    User selectUserByEmail(String email);

    /**
     * 注册（添加用户）
     *
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 修改用户的信息
     * 赵负责（已完成）
     *
     * @param user
     * @return
     */
    int updateUserInfo(User user);

    /**
     * 更改用户密码
     * 聂负责（已完成）
     *
     * @param password
     * @return
     */
    int updatePassword(@Param("email") String email, @Param("password") String password);

    /**
     * 查看当前用户创建的所有文档
     * 赵负责（已完成）
     *
     * @param userId
     * @return
     */
    List<Document> selectAllDocCreateByUser(Integer userId);

    /**
     * 用户查看目前参与的所有文档
     * 聂负责（已完成）
     *
     * @param userId
     * @return
     */
    List<Document> selectAllDocParticipate(Integer userId);

    /**
     * 查询用户创建的文档总数
     * @param userId
     * @return
     */
    int selectFileCountCreateByUser(@Param("userId") Integer userId);
    /**
     * 分页展示用户创建的所有文档
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Document> selectAllDocCreateByUserByPage(@Param("userId") Integer userId,
                                                  @Param("pageNum") int pageNum,
                                                  @Param("pageSize") int pageSize);

}

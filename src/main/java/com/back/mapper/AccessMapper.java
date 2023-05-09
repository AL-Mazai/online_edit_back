package com.back.mapper;

import com.back.pojo.Access;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessMapper {
    /**
     * 前端用户查看参与的文档，然后选择要退出的文档，传给后端参数是参与者Id和该文档id
     * 赵负责
     *
     * @param userId
     * @param docId
     * @return
     */
    int quitDoc(@Param("userId") Integer userId, @Param("docId") Integer docId);

    /**
     * 前端用户查看创建的文档，并查看某个文档的参与者，然后可以邀请其他成员，传给后端的参数是该次邀请的id、参与者Id、该文档id、授予该参与者的权限,然后封装成一个权限对象传给后端
     * 赵负责（已完成）
     *
     * @param access
     * @return
     */
    int insertUserOfDoc(Access access);

    /**
     * 前端用户查看创建的文档，并查看某个文档的所有参与者，然后选择要踢除的参与者，传给后端的参数是参与者Id和该文档id
     * 聂负责（已完成）
     *
     * @param userId
     * @param docId
     * @return
     */
    int deleteUserOfDoc(@Param("userId") Integer userId, @Param("docId") Integer docId);
}

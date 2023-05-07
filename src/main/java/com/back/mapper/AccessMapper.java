package com.back.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface AccessMapper {
    /**
     * 前端用户查看参与的文档，然后选择要退出的文档，传给后端参数是参与者Id和该文档id
     * 赵负责
     * @param userId
     * @param docId
     * @return
     */
    int quitDoc(Integer userId, Integer docId);

    /**
     * 前端用户查看创建的文档，并查看某个文档的参与者，然后可以邀请其他成员，传给后端的参数是参与者Id和该文档id
     * 赵负责
     * @param userId
     * @param docId
     * @return
     */
    int addUserOfDoc(Integer userId, Integer docId);

    /**
     * 前端用户查看创建的文档，并查看某个文档的所有参与者，然后选择要踢除的参与者，传给后端的参数是参与者Id和该文档id
     * 聂负责
     * @param userId
     * @param docId
     * @return
     */
    int deleteUserOfDoc(Integer userId, Integer docId);
}

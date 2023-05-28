package com.back.mapper;

import com.back.pojo.Access;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessMapper {
    /**
     * 用户查看参与的文档，然后选择要退出的文档
     * 赵负责（已完成）
     *
     * @param userId
     * @param docId
     * @return
     */
    int quitDoc(@Param("userId") Integer userId, @Param("docId") Integer docId);

    /**
     * 邀请成员
     * 赵负责（已完成）
     * @param access
     * @return
     */
    int insertUserOfDoc(Access access);

    /**
     * 踢除参与者
     * 聂负责（已完成）
     *
     * @param userId
     * @param docId
     * @return
     */
    int deleteUserOfDoc(@Param("userId") Integer userId, @Param("docId") Integer docId);

    /**
     * 删除一条记录
     * @param docId
     * @return
     */
    int deleteAccessRecord(Integer docId);
}

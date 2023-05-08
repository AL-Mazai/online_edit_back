package com.back.service;

import com.back.pojo.Access;

public interface AccessService {
    /**
     * 邀请成员进行文档编辑
     * @param access
     * @return
     */
    boolean inviteUserOfDoc(Access access);
    /**
     * 剔除文档参与者
     *
     * @param userId
     * @param docId
     * @return
     */
    boolean deleteUserOfDoc(Integer userId, Integer docId);
}

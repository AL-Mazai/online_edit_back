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
     * 退出参与的文档（用户角度）
     * @param userId
     * @param docId
     * @return
     */
    boolean quitDoc(Integer userId, Integer docId);
    /**
     * 剔除文档参与者（创建者角度）
     *
     * @param userId
     * @param docId
     * @return
     */
    boolean deleteUserOfDoc(Integer userId, Integer docId);

    /**
     * 删除一条记录
     * @param docId
     * @return
     */
    boolean deleteAccessRecord(Integer docId);
}

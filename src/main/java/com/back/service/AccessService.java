package com.back.service;

public interface AccessService {
    /**
     * 剔除文档参与者
     *
     * @param userId
     * @param docId
     * @return
     */
    boolean deleteUserOfDoc(Integer userId, Integer docId);
}

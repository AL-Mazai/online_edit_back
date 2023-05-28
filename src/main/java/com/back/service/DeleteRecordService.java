package com.back.service;


import com.back.pojo.DeleteRecord;
import com.back.pojo.Document;

import java.util.List;

public interface DeleteRecordService {

    /**
     * 新增删除记录
     * @param deleteRecord
     * @return
     */
    boolean addDeleteRecord(DeleteRecord deleteRecord);

    /**
     * 删除一条记录
     * @param docId
     * @return
     */
    boolean deleteRecord(Integer docId);

    /**
     * 查询用户删除的文档总数
     * @param userId
     * @return
     */
    int selectFileCountDeleteByUser(Integer userId);

    /**
     * 查询用户删除的所有文档
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Document> selectAllDocDeleteByUserByPage(int userId, int pageNum, int pageSize);
}

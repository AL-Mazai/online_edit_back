package com.back.mapper;


import com.back.pojo.DeleteRecord;
import com.back.pojo.Document;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeleteRecordMapper {
    /**
     * 新增删除记录
     * @param deleteRecord
     * @return
     */
    int insertRecord(DeleteRecord deleteRecord);

    /**
     * 删除一条记录
     * @param docId
     * @return
     */
    int deleteRecord(Integer docId);


    /**
     * 查询用户删除的文档总数
     * @param userId
     * @return
     */
    int selectFileCountDeleteByUser(@Param("userId") Integer userId);

    /**
     * 分页展示用户删除的所有文档
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Document> selectAllDocDeleteByUserByPage(@Param("userId") Integer userId,
                                                  @Param("pageNum") int pageNum,
                                                  @Param("pageSize") int pageSize);
}

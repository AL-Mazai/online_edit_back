package com.back.service.impl;


import com.back.mapper.DeleteRecordMapper;
import com.back.pojo.DeleteRecord;
import com.back.pojo.Document;
import com.back.service.DeleteRecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.DatabaseMetaData;
import java.util.List;


@Service
public class DeleteRecordServiceImpl implements DeleteRecordService{

    @Autowired
    DeleteRecordMapper deleteRecordMapper;

    @Override
    public boolean addDeleteRecord(DeleteRecord deleteRecord) {
        int isSuccess = deleteRecordMapper.insertRecord(deleteRecord);
        if(isSuccess > 0){
            return true;
        }
        return false;
    }
    @Override
    public boolean deleteRecord(Integer docId) {
        int isSuccess = deleteRecordMapper.deleteRecord(docId);
        if(isSuccess > 0){
            return true;
        }
        return false;
    }



    @Override
    public int selectFileCountDeleteByUser(Integer userId) {
        return deleteRecordMapper.selectFileCountDeleteByUser(userId);
    }

    @Override
    public List<Document> selectAllDocDeleteByUserByPage(int userId, int pageNum, int pageSize) {
        return deleteRecordMapper.selectAllDocDeleteByUserByPage(userId, pageNum, pageSize);
    }
}

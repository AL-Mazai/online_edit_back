package com.back.service.impl;

import com.back.mapper.DocumentMapper;
import com.back.pojo.Document;
import com.back.pojo.User;
import com.back.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentMapper documentMapper;

    @Override
    public boolean addDocument(Document document) {
        if (documentMapper.insertDoc(document) > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<User> selectAllUserOfDoc(int docId) {
        List<User> list = documentMapper.selectAllUserOfDoc(docId);
        return list;
    }

    @Override
    public List<Document> selectAllDocument() {
        List<Document> list = documentMapper.selectAllDoc();
        return list;
    }

    @Override
    public boolean deleteDoc(int docId) {
        if (documentMapper.deleteDoc(docId) > 0) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean deleteDocPermanent(int docId) {
        if (documentMapper.deleteDocPermanent(docId) > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Document> getAllDocByName(String fileName, Integer userId) {
        return documentMapper.selectAllDocByName(fileName, userId);
    }

    @Override
    public boolean changeDocStatus(Integer docId, Boolean status) {
        if(documentMapper.updateStatus(docId, status) > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean recoverFromBin(Integer docId) {
        if(documentMapper.recoverFromBin(docId) > 0){
            return true;
        }
        return false;
    }

    @Override
    public int selectFileCount(String fileName, String type, int accessLevel, int userId) {
        return documentMapper.selectFileCount(fileName,type, accessLevel,userId);
    }

    @Override
    public List<Document> selectFileByPage(int pageNum, int pageSize, String fileName, String type, int accessLevel, int userId) {
        return documentMapper.selectFileByPage(pageNum, pageSize, fileName, type, accessLevel, userId);
    }
}

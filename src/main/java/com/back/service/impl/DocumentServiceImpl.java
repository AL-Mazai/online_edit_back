package com.back.service.impl;

import com.back.mapper.DocumentMapper;
import com.back.pojo.Document;
import com.back.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentMapper documentMapper;
    @Override
    public boolean insertDocument(Document document) {
        if(documentMapper.insertDoc(document)>0){
            return true;
        }else  return false;
    }
}

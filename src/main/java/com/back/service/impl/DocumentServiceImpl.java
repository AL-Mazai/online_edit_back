package com.back.service.impl;

import com.back.mapper.DocumentMapper;
import com.back.pojo.Document;
import com.back.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentMapper documentMapper;
    @Override
    public boolean addDocument(Document document) {
        if(documentMapper.insertDoc(document)>0){
            return true;
        }else  return false;
    }

    @Override
    public List<Document> getAllDocByName(String name) {
        return documentMapper.selectAllDocByName(name);
    }
}

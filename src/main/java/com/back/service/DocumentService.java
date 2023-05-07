package com.back.service;

import com.back.pojo.Document;

import java.util.List;

public interface DocumentService {
    boolean addDocument(Document document);

    /**
     * 根据文档名称关键字查找文档
     * @param name
     * @return
     */
    List<Document> getAllDocByName(String name);
}

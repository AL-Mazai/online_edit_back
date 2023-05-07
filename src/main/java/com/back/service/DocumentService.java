package com.back.service;

import com.back.pojo.Document;

import java.util.List;

public interface DocumentService {
    boolean addDocument(Document document);

    List<Document> getAllDocByName(String name);
}

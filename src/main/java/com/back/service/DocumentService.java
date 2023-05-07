package com.back.service;

import com.back.pojo.Document;
import com.back.pojo.User;

import java.util.List;

public interface DocumentService {
    boolean addDocument(Document document);

    List<User> selectAllUserByDoc(int docId);
    boolean deleteDoc(int docId);

    List<Document> selectAllDocument();

}

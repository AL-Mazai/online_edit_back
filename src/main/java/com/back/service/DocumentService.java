package com.back.service;

import com.back.pojo.Document;
import com.back.pojo.User;

import java.util.List;

public interface DocumentService {
    /**
     * 新增文档
     * @param document
     * @return
     */
    boolean addDocument(Document document);

    /**
     * 查询某个文档的所有参与者
     * @param docId
     * @return
     */
    List<User> selectAllUserOfDoc(int docId);

    /**
     * 删除文档（只能创建者删除）
     * @param docId
     * @return
     */
    boolean deleteDoc(int docId);

    /**
     * 查看参与者参与的所有文档
     * @return
     */
    List<Document> selectAllDocument();

    /**
     * 根据文档名称关键字查找文档
     * @param name
     * @return
     */
    List<Document> getAllDocByName(String name);
}

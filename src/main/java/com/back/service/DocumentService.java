package com.back.service;

import com.back.pojo.Document;
import com.back.pojo.User;

import javax.print.Doc;
import java.nio.file.Files;
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
     * 永久删除文档
     * @param docId
     * @return
     */
    boolean deleteDocPermanent(int docId);

    /**
     * 查看所有文档
     * @return
     */
    List<Document> selectAllDocument();

    /**
     * 根据文档名称关键字查找文档
     * @param name
     * @return
     */
    List<Document> getAllDocByName(String name);

    /**
     * 更改文档状态
     * @param docId
     * @param status
     * @return
     */
    boolean changeDocStatus(Integer docId, Boolean status);

    /**
     * 恢复文档
     * @param docId
     * @return
     */
    boolean recoverFromBin(Integer docId);

    /**
     * 文档总数
     * @param fileName
     * @param type
     * @return
     */
    int selectFileCount(String fileName, String type);

    /**
     * 分页展示和查询
     * @param pageNum
     * @param pageSize
     * @param fileName
     * @param type
     * @return
     */
    List<Document> selectFileByPage(int pageNum, int pageSize, String fileName, String type);
}

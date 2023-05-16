package com.back.mapper;

import com.back.pojo.Document;
import com.back.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.nio.file.Files;
import java.util.List;

@Repository
public interface DocumentMapper {

    /**
     * 新建文档
     * 何负责（已完成）
     * @param doc
     * @return
     */
    int insertDoc(Document doc);

    /**
     * 查看某个文档的所有参与者
     * 何负责(已完成)
     * @param docId
     * @return
     */
    List<User> selectAllUserOfDoc(Integer docId);

    /**
     * 查看所有文档展示在前端主页（按时间降序排序）
     * 何负责(已完成)
     * @return
     */
    List<Document> selectAllDoc();

    /**
     * 删除文档，只有创建者才能删除
     * 何负责（已完成）
     * @param docId
     * @return
     */
    int deleteDoc(Integer docId);

    /**
     * 前端主页搜索框输入关键字查询符合的所有文档
     * 聂负责（已完成）
     * @param name
     * @return
     */
    List<Document> selectAllDocByName(String name);


    /**
     * 查找总文档数
     * @param fileName
     * @param type
     * @return
     */
    int selectFileCount(@Param("fileName") String fileName,
                        @Param("type") String type);

    /**
     * 分页展示和查询所有文档
     * @param pageNum
     * @param pageSize
     * @param fileName
     * @param type
     * @return
     */
    List<Document> selectFileByPage(
            @Param("pageNum")int pageNum,
            @Param("pageSize")int pageSize,
            @Param("fileName")String fileName,
            @Param("type")String type);

    /**
     * 更新文档状态
     * @param status
     * @param docId
     * @return
     */
    int updateStatus(@Param("docId") Integer docId,
                     @Param("status") boolean status);
}

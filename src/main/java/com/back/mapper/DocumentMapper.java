package com.back.mapper;

import com.back.pojo.Document;
import com.back.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentMapper {

    /**
     * 新建文档：前端传过来文档对象，后端接收后插入数据库
     * 何负责（已完成）
     * @param doc
     * @return
     */
    int insertDoc( Document doc);

    /**
     * 前端用户查看创建的文档，并查看其中一个文档的所有参与者，传给后端的参数为userId和docId
     * 何负责
     * @param userId
     * @param docId
     * @return
     */
    List<User> selectAllUser(Integer userId, Integer docId);

    /**
     * 查看所有文档展示在前端主页（按时间降序排序）
     * 何负责
     * @return
     */
    List<Document> selectAllDoc();

    /**
     * 删除文档，只有创建者才能删除，并且删除后，对应的权限表中以该文档作为外键的元组应当全部删除（级联删除）
     * 何负责
     * @param docId
     * @return
     */
    int deleteDoc(Integer docId);

    /**
     * 前端主页搜索框输入关键字查询所有文档名称中包含关键字的文档
     * 聂负责（已完成）
     * @param name
     * @return
     */
    List<Document> selectAllDocByName(String name);
}

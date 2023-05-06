package com.back.mapper;

import com.back.pojo.Document;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentMapper {

    /**
     * 新建文档：前端传过来文档对象，后端接收后插入数据库
     * 何负责
     * @param doc
     * @return
     */
    int insertDoc(Document doc);

}

package com.back.mapper;

import com.back.pojo.Document;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentMapper {

    /**
     * 新建文档：前端传过来文档对象，后端接收后插入数据库
     * 何负责
     * @param doc
     * @return
     */
    int insertDoc( Document doc);

}

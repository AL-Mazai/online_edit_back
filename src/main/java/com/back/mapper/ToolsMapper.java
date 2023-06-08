package com.back.mapper;


import com.back.pojo.Tools;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToolsMapper {
    /**
     * 增加工具
     * @param tools
     */
    int addTool(Tools tools);

    /**
     * 获取所有工具
     * @return
     */
    List<Tools> getAllTool();

}





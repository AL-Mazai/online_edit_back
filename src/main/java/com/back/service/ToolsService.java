package com.back.service;


import com.back.pojo.Tools;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ToolsService{

    /**
     * 增加工具
     * @param tools
     * @return
     */
    boolean addTool(Tools tools);

    /**
     * 获取所有工具
     * @return
     */
    List<Tools> getAllTool();
}

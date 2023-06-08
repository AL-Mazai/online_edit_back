package com.back.service.impl;

import com.back.mapper.ToolsMapper;
import com.back.pojo.Tools;
import com.back.service.ToolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ToolsServiceImpl implements ToolsService{

    @Autowired
    ToolsMapper toolsMapper;

    @Override
    public boolean addTool(Tools tools) {
        if(toolsMapper.addTool(tools) > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<Tools> getAllTool() {
        return toolsMapper.getAllTool();
    }
}





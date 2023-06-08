package com.back.controller;

import com.back.pojo.Tools;
import com.back.service.ToolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tools")
public class ToolsController {

    @Autowired
    ToolsService toolsService;

    @PostMapping("/addTool")
    @ResponseBody
    public ResponseEntity<Object> addTool(@RequestBody Tools tools){
        boolean isSeccess = toolsService.addTool(tools);
        if(isSeccess){
            return new ResponseEntity<>("添加成功", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("添加失败", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllTool")
    @ResponseBody
    public List<Tools> getAllTool(){
        return toolsService.getAllTool();
    }
}

package com.back.controller;

import com.back.pojo.Document;
import com.back.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doc")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @PostMapping("/insertDocument")
    @ResponseBody
    public ResponseEntity<Object> insertDocument(@RequestBody Document document){
        Boolean isSuccess=documentService.insertDocument(document);
        if(isSuccess==true){
            return new ResponseEntity<>("插入成功", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("插入失败，请重试",HttpStatus.BAD_REQUEST);
        }
    }

}

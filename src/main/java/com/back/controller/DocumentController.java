package com.back.controller;

import com.back.pojo.Document;
import com.back.pojo.User;
import com.back.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doc")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @PostMapping("/insertDocument")
    @ResponseBody
    public ResponseEntity<Object> insertDocument(@RequestBody Document document){
        Boolean isSuccess=documentService.addDocument(document);
        if(isSuccess==true){
            return new ResponseEntity<>("插入成功", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("插入失败，请重试",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/selectAllUserByDocument")
    @ResponseBody
    public List<User> selectAllUserByDoc(int docId){
        List<User> list=documentService.selectAllUserByDoc(docId);
        return list;
    }

    @GetMapping("/selectAllDocument")
    @ResponseBody
    public List<Document> selectAllDocument(){
        List<Document> list=documentService.selectAllDocument();
        return list;

    }

    @GetMapping("/deleteDocument")
    @ResponseBody
    public ResponseEntity<Object> deleteDoc(int docId){
        Boolean isSuccess=documentService.deleteDoc(docId);
        if(isSuccess){
            return new ResponseEntity<>("删除成功", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("删除失败，请重试",HttpStatus.BAD_REQUEST);
        }
    }

}

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
    public ResponseEntity<Object> insertDocument(@RequestBody Document document) {
        Boolean isSuccess = documentService.addDocument(document);
        if (isSuccess == true) {
            return new ResponseEntity<>("插入成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("插入失败，请重试", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/selectAllUserOfDocument")
    @ResponseBody
    public List<User> selectAllUserOfDoc(int docId) {
        List<User> list = documentService.selectAllUserOfDoc(docId);
        return list;
    }

    @GetMapping("/selectAllDocument")
    @ResponseBody
    public List<Document> selectAllDoc() {
        List<Document> list = documentService.selectAllDocument();
        return list;
    }

    @DeleteMapping("/deleteDocument")
    @ResponseBody
    public ResponseEntity<Object> deleteDoc(int docId) {
        Boolean isSuccess = documentService.deleteDoc(docId);
        if (isSuccess == true) {
            return new ResponseEntity<>("删除成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("删除失败，请重试", HttpStatus.BAD_REQUEST);
        }
    }


//    @GetMapping("/selectAllDocByName")
//    @ResponseBody
//    public ResponseEntity<Object> selectAllDocByName(@RequestParam("name") String name) {
//        List<Document> allDocument = documentService.getAllDocByName(name);
//        if (allDocument == null) {
//            return new ResponseEntity<>("没有查找到内容", HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(allDocument, HttpStatus.OK);
//        }
//    }
}

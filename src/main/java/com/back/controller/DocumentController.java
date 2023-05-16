package com.back.controller;

import com.back.pojo.Document;
import com.back.pojo.User;
import com.back.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            return new ResponseEntity<>("新建成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("新建失败，请重试", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/selectAllUserOfDocument")
    @ResponseBody
    public ResponseEntity<List<User>> selectAllUserOfDoc(@RequestParam("docId") int docId) {
        List<User> list = documentService.selectAllUserOfDoc(docId);
        if (list == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(list);
        }

    }

    @GetMapping("/selectAllDocument")
    @ResponseBody
    public ResponseEntity<List<Document>> selectAllDoc() {
        List<Document> list = documentService.selectAllDocument();
        if (list == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(list);
        }
    }

    @DeleteMapping("/deleteDocument")
    @ResponseBody
    public ResponseEntity<Object> deleteDoc(@RequestParam int docId) {
        boolean isSuccess = documentService.deleteDoc(docId);
        if (isSuccess == true) {
            return new ResponseEntity<>("删除成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("删除失败，请重试", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/selectAllDocByName")
    @ResponseBody
    public ResponseEntity<Object> selectAllDocByName(@RequestParam("name") String name) {
//        System.out.println("正在查找....");
        List<Document> allDocument = documentService.getAllDocByName(name);
        if (allDocument == null) {
            return new ResponseEntity<>("没有查找到内容", HttpStatus.NO_CONTENT);
        } else {
//            System.out.println("成功....");
            return new ResponseEntity<>(allDocument, HttpStatus.OK);
        }
    }

    @PostMapping("/changeDocStatus")
    @ResponseBody
    public ResponseEntity<Object> changeDocStatus(@RequestBody Map<String,Object> map){
        boolean isSuccess = documentService.changeDocStatus((Integer) map.get("docId"), (Boolean) map.get("status"));
        if (isSuccess == true) {
            return new ResponseEntity<>("更改成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("更改失败，请重试", HttpStatus.BAD_REQUEST);
        }
    }

    //分页
    @GetMapping("/selectFileByPage")
    public ResponseEntity<Map<String, Object>> selectFilePage(
            @RequestParam int pageNum,
            @RequestParam int pageSize,
            @RequestParam String fileName,
            @RequestParam String type
    ) {
        pageNum = (pageNum - 1) * pageSize;
        List<Document> files = documentService.selectFileByPage(pageNum, pageSize, fileName, type);
        int total = documentService.selectFileCount(fileName, type);
        Map<String, Object> res = new HashMap<>();
        res.put("total", total);
        res.put("docList", files);
        return ResponseEntity.ok(res);
    }
}

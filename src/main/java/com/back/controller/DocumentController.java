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
        System.out.println(document);
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
    @DeleteMapping("/deleteDocPermanent")
    @ResponseBody
    public ResponseEntity<Object> deleteDocPermanent(@RequestParam int docId) {
        boolean isSuccess = documentService.deleteDocPermanent(docId);
        if (isSuccess == true) {
            return new ResponseEntity<>("删除成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("删除失败，请重试", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/selectAllDocByName")
    @ResponseBody
    public ResponseEntity<Object> selectAllDocByName(@RequestParam("fileName") String fileName,
                                                     @RequestParam("userId") Integer userId) {
        List<Document> allDocument = documentService.getAllDocByName(fileName, userId);
        if (allDocument == null) {
            return new ResponseEntity<>("没有查找到内容", HttpStatus.NO_CONTENT);
        } else {
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
    @PostMapping("/recoverFromBin")
    @ResponseBody
    public ResponseEntity<Object> recoverFromBin(@RequestBody Map<String,Object> map){
        boolean isSuccess = documentService.recoverFromBin((Integer) map.get("docId"));
        if (isSuccess == true) {
            return new ResponseEntity<>("恢复成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("恢复失败", HttpStatus.BAD_REQUEST);
        }
    }

    //分页
    @GetMapping("/selectFileByPage")
    public ResponseEntity<Map<String, Object>> selectFilePage(
            @RequestParam Integer userId,
            @RequestParam Integer pageNum,
            @RequestParam Integer pageSize,
            @RequestParam String fileName,
            @RequestParam String type,
            @RequestParam Integer accessLevel
    ) {
        pageNum = (pageNum - 1) * pageSize;
        List<Document> documents = documentService.selectFileByPage(pageNum, pageSize, fileName, type, accessLevel, userId);
        int total = documentService.selectFileCount(fileName, type, accessLevel, userId);
        Map<String, Object> res = new HashMap<>();
        res.put("total", total);
        res.put("docList", documents);
        return ResponseEntity.ok(res);
    }
}

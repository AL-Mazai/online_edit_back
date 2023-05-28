package com.back.controller;

import com.back.pojo.DeleteRecord;
import com.back.pojo.Document;
import com.back.service.DeleteRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/deleteRecord")
public class DeleteRecordController {

    @Autowired
    DeleteRecordService deleteRecordService;

    @PostMapping("/addDeleteRecord")
    @ResponseBody
    public ResponseEntity<Object> addDeleteRecord(@RequestBody DeleteRecord deleteRecord){
        boolean isSuccess = deleteRecordService.addDeleteRecord(deleteRecord);
        if(isSuccess){
            return new ResponseEntity<>("添加成功！", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("添加失败", HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/deleteRecord")
    @ResponseBody
    public ResponseEntity<Object> deleteRecord(@RequestParam int docId){
        boolean isSuccess = deleteRecordService.deleteRecord(docId);
        if(isSuccess){
            return new ResponseEntity<>("删除成功！", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("删除失败", HttpStatus.BAD_REQUEST);
        }
    }

    //分页
    @GetMapping("/selectFilePageDeleteByUser")
    public ResponseEntity<Map<String, Object>> selectFilePageDeleteByUser(
            @RequestParam int userId,
            @RequestParam int pageNum,
            @RequestParam int pageSize
    ) {
        pageNum = (pageNum - 1) * pageSize;
        List<Document> documents = deleteRecordService.selectAllDocDeleteByUserByPage(userId, pageNum, pageSize);
        System.out.println(documents);//测试
        int total = deleteRecordService.selectFileCountDeleteByUser(userId);
        System.out.println(total);//测试
        Map<String, Object> res = new HashMap<>();
        res.put("total", total);
        res.put("deleteDocList", documents);
        return ResponseEntity.ok(res);
    }
}

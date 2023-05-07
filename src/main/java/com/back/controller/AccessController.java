package com.back.controller;

import com.back.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/access")
public class AccessController {
    @Autowired
    private AccessService accessService;

    @DeleteMapping("/deleteUserOfDoc")
    @ResponseBody
    public ResponseEntity<Object> deleteUserOfDoc(@RequestParam("userId") Integer userId,
                                                  @RequestParam("docId") Integer docId) {
        boolean isSuccess = accessService.deleteUserOfDoc(userId, docId);
        if (isSuccess) {
            return new ResponseEntity<>("删除成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("删除失败", HttpStatus.BAD_REQUEST);
        }
    }
}

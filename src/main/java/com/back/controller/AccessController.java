package com.back.controller;

import com.back.pojo.Access;
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

    @PostMapping("/inviteUserOfDoc")
    @ResponseBody
    public ResponseEntity<Object> inviteUserOfDoc(@RequestBody Access access){
        boolean isSuccess = accessService.inviteUserOfDoc(access);
        if (isSuccess) {
            return new ResponseEntity<>("邀请成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("邀请失败", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/quitDoc")
    @ResponseBody
    public ResponseEntity<Object> quitDoc(@RequestParam("userId") Integer userId,
                                          @RequestParam("docId") Integer docId) {
        boolean isSuccess = accessService.quitDoc(userId, docId);
        if (isSuccess) {
            return new ResponseEntity<>("退出成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("退出失败", HttpStatus.BAD_REQUEST);
        }
    }

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

package com.back.controller;

import com.back.pojo.Avatars;
import com.back.service.AvatarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avatar")
public class AvatarController {

    @Autowired
    AvatarsService avatarsService;

    @GetMapping("/getAvatarUrl")
    @ResponseBody
    public String getAvatarUrl(@RequestParam("userId") Integer userId){
        return avatarsService.getAvatarUrl(userId);
    }
    @PostMapping("/addAvatar")
    @ResponseBody
    public ResponseEntity<Object> addAvatar(@RequestBody Avatars avatars){
        boolean isSuccess = avatarsService.addAvatar(avatars);
        if(isSuccess){
            return new ResponseEntity<>(avatars, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("上传失败", HttpStatus.BAD_REQUEST);
        }
    }
}

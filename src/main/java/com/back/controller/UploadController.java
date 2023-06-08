package com.back.controller;

import com.back.service.UploadImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @program: SpringBoot Qiniu
 * @description:
 * @author: CodeDuck
 * @create: 2020-07-30 16:12
 **/
@Slf4j
@RestController
@RequestMapping("/qiniu")
public class UploadController {

    @Resource
    UploadImageService uploadImageService;

    @PostMapping(value = "/image")
    private String upLoadImage(@RequestParam("file") MultipartFile file) throws IOException {

        if (!file.isEmpty()) {

            String path = uploadImageService.uploadQNImg(file);
            System.out.println("七牛云返回的图片链接:" + path);

            return path;
        }
        return "上传失败";
    }

}


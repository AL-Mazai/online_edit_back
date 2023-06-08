package com.back.service;


import org.springframework.web.multipart.MultipartFile;

/**
 * @program: Springboot Qiniu
 * @description:
 * @author: CodeDuck
 * @create: 2020-07-30 19:48
 **/
public interface UploadImageService {

    String uploadQNImg(MultipartFile file);

    String getPrivateFile(String fileKey);

}
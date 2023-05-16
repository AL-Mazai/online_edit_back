package com.back.controller;

import com.back.pojo.Document;
import com.back.pojo.User;
import com.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getAllUser")
    @ResponseBody
    public List<User> ListUser() {
        return userService.getAllUser();
    }

    @GetMapping("/getUserInfo")
    @ResponseBody
    public ResponseEntity<Object> getUser(@RequestParam("userId") Integer userId) {
        User user = userService.getUserInfo(userId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>("没有该用户的信息", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<Object> login(@RequestBody User userParam) {
        User user = userService.login(userParam.getEmail(), userParam.getPassword());
        if (user != null) {
            /***用map存放用户的状态并返回给前端存储到本地***/
            Map<String,Object> res = new HashMap();
            user.setToken(UUID.randomUUID().toString());//生成一个随机字符串给token
            res.put("token",user.getToken());
            res.put("user",user);
            // 登录成功
            return new ResponseEntity<>(res, HttpStatus.OK);
        } else {
            // 登录失败
            return new ResponseEntity<>("登陆失败", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<Object> register(@RequestBody User user) {
        boolean isSuccess = userService.register(user);
        if (isSuccess) {
            return new ResponseEntity<>("注册成功！", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("用户已存在，可直接登录！", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAllDocCreate")
    @ResponseBody
    public ResponseEntity<Object> getAllDocCreateByUser(@RequestParam("userId") Integer userId) {
        List<Document> documentList = userService.getAllDocCreateByUser(userId);
        if (documentList == null) {
            return new ResponseEntity<>("您没有创建任何文档", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(documentList, HttpStatus.OK);
        }
    }

    @GetMapping("/getAllDocParticipate")
    @ResponseBody
    public ResponseEntity<Object> getAllDocParticipate(@RequestParam("userId") Integer userId) {
//        System.out.println(userId);
        List<Document> documentList = userService.getAllDocParticipate(userId);
        if (documentList == null) {
            return new ResponseEntity<>("查找内容为空", HttpStatus.NO_CONTENT);
        } else {
//            System.out.println(documentList);
            return new ResponseEntity<>(documentList, HttpStatus.OK);
        }
    }

    @PostMapping("/changePassword")
    @ResponseBody
    public ResponseEntity<Object> changePassword(@RequestBody Map<String,String> map) {
        boolean isSuccess = userService.changePassword(map.get("email"), map.get("oldPassword"), map.get("newPassword"));
        if (isSuccess) {
            return new ResponseEntity<>("修改成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("修改失败,请重试", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/changeInfo")
    @ResponseBody
    public ResponseEntity<Object> changeUserInfo(@RequestBody User user) {
        boolean isSuccess = userService.changeUserInfo(user);
        if (isSuccess) {
            return new ResponseEntity<>("修改成功", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("修改失败，请重试", HttpStatus.BAD_REQUEST);
        }
    }
}

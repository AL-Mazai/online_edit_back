package com.back.controller;

import com.back.pojo.Document;
import com.back.pojo.User;
import com.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
            System.out.println("登录成功....");
            // 登录成功
            return new ResponseEntity<>("登陆成功", HttpStatus.OK);
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
        List<Document> documentList = userService.getAllDocParticipate(userId);
        if (documentList == null) {
            return new ResponseEntity<>("查找内容为空", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(documentList, HttpStatus.OK);
        }
    }

    @PostMapping("/changePassword")
    @ResponseBody
    public ResponseEntity<Object> changePassword(@RequestParam("email") String email,
                                                 @RequestParam("oldPassword") String oldPassword,
                                                 @RequestParam("newPassword") String newPassword) {
        boolean isSuccess = userService.changePassword(email, oldPassword, newPassword);
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

package com.back.controller;

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

    @GetMapping("/getAll")
    @ResponseBody
    public List<User> ListUser() {
        return userService.getAllUser();
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<Object> login(@RequestParam("username") String username,
                                        @RequestParam("password") String password) {
        User user = userService.login(username, password);
        if (user != null) {
            // 登录成功
            return new ResponseEntity<>("登陆成功", HttpStatus.OK);
        } else {
            // 登录失败
            return new ResponseEntity<>("登陆失败", HttpStatus.UNAUTHORIZED);
        }
    }
}

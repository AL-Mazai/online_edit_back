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
    public ResponseEntity<Object> login(@RequestParam("email") String email,
                                        @RequestParam("password") String password) {
        User user = userService.login(email, password);
        if (user != null) {
            // 登录成功
            return new ResponseEntity<>("登陆成功", HttpStatus.OK);
        } else {
            // 登录失败
            return new ResponseEntity<>("登陆失败", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<Object> registerUser(@RequestBody User user) {
        boolean isSuccess = userService.register(user);
        if (isSuccess) {
            return new ResponseEntity<>("注册成功！", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("用户已存在，可直接登录！", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/changePassword")
    @ResponseBody
    public ResponseEntity<Object> changePassword(@RequestParam("email") String email,
                                                 @RequestParam("oldPassword") String oldPassword,
                                                 @RequestParam("newPassword") String newPassword){
        boolean isSuccess = userService.changePassword(email,oldPassword,newPassword);
        if (isSuccess) {
            return new ResponseEntity<>("修改成功",HttpStatus.OK);
        } else{
            return new ResponseEntity<>("修改失败,请重试",HttpStatus.BAD_REQUEST);
        }
    }

}

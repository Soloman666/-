package com.example.controller;

import com.example.pojo.Admin;
import com.example.pojo.Result;
import com.example.pojo.Users;
import com.example.service.AdminService;
import com.example.service.UsersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@Slf4j
public class LoginController {
    @Autowired
    private AdminService adminService;

   @PostMapping("/login")
    public Result adminLogin(@RequestBody Admin admin){
       log.info("管理员登录: {}",admin);
        Admin ad = adminService.login(admin);
        return ad !=null?Result.success():Result.error("账号或密码错误！");
    }

}

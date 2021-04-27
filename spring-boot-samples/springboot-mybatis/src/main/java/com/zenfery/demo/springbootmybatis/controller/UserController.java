package com.zenfery.demo.springbootmybatis.controller;

import com.zenfery.demo.springbootmybatis.dao.UserinfoDao;
import com.zenfery.demo.springbootmybatis.model.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserinfoDao userinfoDao;

    @PostMapping("/users")
    public void addUser(@RequestBody Userinfo userinfo) {
        userinfoDao.insert(userinfo);
    }

    @GetMapping("/users/{id}")
    public Userinfo queryUser(@PathVariable Long id){
        return userinfoDao.select(id);
    }
}

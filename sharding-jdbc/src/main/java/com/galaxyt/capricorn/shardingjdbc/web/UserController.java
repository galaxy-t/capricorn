package com.galaxyt.capricorn.shardingjdbc.web;

import com.galaxyt.capricorn.shardingjdbc.entity.Common;
import com.galaxyt.capricorn.shardingjdbc.entity.User;
import com.galaxyt.capricorn.shardingjdbc.inter.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {



    @Autowired
    private IUserService userService;

    @GetMapping("default-add")
    public String defaultAdd() {
        this.userService.defaultAdd();
        return "ok";
    }

    @GetMapping("default-list")
    public List<Common> defaultList() {
        return this.userService.defaultList();
    }



    @GetMapping("add")
    public String add() {
        this.userService.add();
        return "ok";
    }


    @GetMapping("save")
    public String save() {


        this.userService.save();

        return "ok";

    }


    @GetMapping("list")
    public List<User> list() {

        return this.userService.list();

    }






}

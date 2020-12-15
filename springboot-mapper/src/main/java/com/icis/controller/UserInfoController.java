package com.icis.controller;

import com.icis.pojo.UserInfo;
import com.icis.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//  @Controller+@ResponserBody

@RestController
public class UserInfoController {
    //    注入service
    @Autowired
    private UserInfoService userInfoService;

    //    查询所有用户数据
    @GetMapping("/findAll")
    public List<UserInfo> findAll() {
//        调用service查询所有用户数据
        List<UserInfo> userInfoList = userInfoService.findAll();
        for (UserInfo userInfo : userInfoList) {
            System.out.println(userInfo);
        }
        return userInfoList;
    }

    //    根据用户实体查询用户
    @GetMapping("findByUserInfo")
    public List<UserInfo> findByUserInfo(UserInfo userInfo) {
        List<UserInfo> allUser = this.userInfoService.findByUserInfo(userInfo);
        return allUser;
    }

    //    根据名字模糊查询用户
    @GetMapping("findUserByName")
    public List<UserInfo> findUserByName(UserInfo userInfo) {
        List<UserInfo> allUser = this.userInfoService.findByUserLike(userInfo);
        return allUser;
    }

    //    添加用户数据
    @PostMapping("/addUser")
    public String addUser(@RequestBody UserInfo userInfo) {
//        调用service  添加数据
        this.userInfoService.addUser(userInfo);
        return "addUser ok";
    }

    //    添加用户数据  有选择性的添加  null值不添加
    @PostMapping("/addUserSelective")
    public String addUserSelective(@RequestBody UserInfo userInfo) {
//        调用service  添加数据
        this.userInfoService.addUserSelective(userInfo);
        return "addUserSelective ok";
    }

    //    更新用户数据
    @PostMapping("/updateUser")
    public String updateUser(@RequestBody UserInfo userInfo) {
//        调用service  添加数据
        this.userInfoService.updateUser(userInfo);
        return "update ok";
    }

    //    更新用户数据  为空不更新
    @PostMapping("/updateUserSelective")
    public String updateUserSelective(@RequestBody UserInfo userInfo) {
//        调用service  添加数据
        this.userInfoService.updateUserSelective(userInfo);
        return "updateUserSelective ok";
    }

    //    按照条件更新  更新名字有"猪"字的
    @GetMapping("/updateUserByName")
    public String updateUserByName(UserInfo userInfo) {
//        调用service  添加数据
        this.userInfoService.updateUserByName(userInfo);
        return "updateUserByName ok";
    }
//根据主键删除
    @GetMapping("/delUserByPrimaryKey")
    public String delUserByPrimaryKey(UserInfo userInfo){
        this.userInfoService.delUserByPrimaryKey(userInfo);
        return "delUserByPrimaryKey ok";
    }

    //根据条件删除数据
    @GetMapping("/delUsers")
    public String delUsers(UserInfo userInfo){
        this.userInfoService.delUsers(userInfo);
        return "delUsers ok";
    }



}

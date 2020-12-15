package com.icis.service;

import com.icis.pojo.UserInfo;

import java.util.List;

//用户接口实现类
public interface UserInfoService {
//    1.查询所有用户数据
   public List<UserInfo> findAll();

//   2.根据条件查询  等值查询
    public List<UserInfo> findByUserInfo(UserInfo userInfo);

//    3.模糊查询
    public List<UserInfo> findByUserLike(UserInfo userInfo);

//    4.添加用户数据
    public void addUser(UserInfo userInfo);
    //    5.选择性添加用户数据
    public void addUserSelective(UserInfo userInfo);
//    6.更新用户数据
    public void updateUser(UserInfo userInfo);

//    7.选择性更新
    public void updateUserSelective(UserInfo userInfo);
//8.根据名字更新
    void updateUserByName(UserInfo userInfo);
//9.根据主键删除
    void delUserByPrimaryKey(UserInfo userInfo);
//9.按条件删除
    void delUsers(UserInfo userInfo);
}

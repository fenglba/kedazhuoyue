package com.icis.service.impl;

import com.icis.mapper.UserInfoMapper;
import com.icis.pojo.UserInfo;
import com.icis.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class UserInfoServiceImpl implements UserInfoService {
//    注入mapper
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public List<UserInfo> findAll() {
        List<UserInfo> userInfoList = this.userInfoMapper.selectAll();
        return userInfoList;
    }
//根据用户实体查询用户数据
    @Override
    public List<UserInfo> findByUserInfo(UserInfo userInfo) {
        return userInfoMapper.select(userInfo);
    }

    @Override
    public List<UserInfo> findByUserLike(UserInfo userInfo) {
//        构建一个Example条件查询对象
        Example example = new Example(UserInfo.class);
//        构建条件  集合
        Example.Criteria criteria = example.createCriteria();
//        添加具体条件 property 字段名  字段值 value
        criteria.andLike("name","%"+userInfo.getName()+"%");
        List<UserInfo> userInfos = userInfoMapper.selectByExample(example);
        return userInfos;
    }

    @Override
    public void addUser(UserInfo userInfo) {
        this.userInfoMapper.insert(userInfo);
    }

    @Override
    public void addUserSelective(UserInfo userInfo) {
        this.userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public void updateUser(UserInfo userInfo) {
//        根据主键更新  根据主键更新
        this.userInfoMapper.updateByPrimaryKey(userInfo);
    }

    @Override
    public void updateUserSelective(UserInfo userInfo) {
        this.userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public void updateUserByName(UserInfo userInfo) {
        Example example = new Example(UserInfo.class);
//        设置条件
        example.createCriteria().andLike("name","%"+userInfo.getName()+"%");
        this.userInfoMapper.updateByExample(userInfo,example);
    }

    @Override
    public void delUserByPrimaryKey(UserInfo userInfo) {
        this.userInfoMapper.deleteByPrimaryKey(userInfo);
    }

    @Override
    public void delUsers(UserInfo userInfo) {
        this.userInfoMapper.delete(userInfo);
    }


}

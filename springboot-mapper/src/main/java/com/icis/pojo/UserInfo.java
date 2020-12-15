package com.icis.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

//用户实体类  封装用户数据  @Data  lombook  自动生成构造方法 setter和getter方法  toString方法
@Data
public class UserInfo implements Serializable{
//    用户标注这个属性对应的是主键字段
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String loginName;
    @Column
    private String nickName;
    @Column
    private String passwd;
    @Column
    private String name;
    @Column
    private String phoneNum;
    @Column
    private String email;
    @Column
    private String headImg;
    @Column
    private String userLevel;

}

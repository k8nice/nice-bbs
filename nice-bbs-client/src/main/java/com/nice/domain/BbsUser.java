package com.nice.domain;

import lombok.Data;

import java.math.BigInteger;

/**
 * bbs用户实体类
 */
@Data
public class BbsUser extends BaseEntity {

    /**
     * 用户id
     */
    private BigInteger bbsUserId;

    /**
     * 用户名
     */
    private String bbsUserName;

    /**
     * 用户密码
     */
    private String bbsUserPassword;

    /**
     * 用户邮箱
     */
    private String bbsUserEmail;

    /**
     * 用户手机号
     */
    private String bbsUserMobile;

    /**
     * 用户盐值
     */
    private String salt;

    /**
     * 用户是否锁定
     */
    private Boolean isLock;

    /**
     * 用户住址
     */
    private String bbsUserAddress;

    /**
     * 用户性别
     */
    private String bbsUserGender;



}

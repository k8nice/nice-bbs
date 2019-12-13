package com.nice.domain;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.math.BigInteger;

/**
 * bbs用户实体类
 *
 * @author nice
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
    @Size(min = 6,max = 10,message = "用户密码格式不正确")
    private String bbsUserPassword;

    /**
     * 用户邮箱
     */
    @Email
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

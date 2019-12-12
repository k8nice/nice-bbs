package com.nice.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;

@Mapper
public interface BbsUserMapper {

    /**
     * 根据bbs用户名获取bbs用户id
     * @param bbsUserName bbs用户名
     * @return  bbs用户id
     */
    BigInteger queryBbsUserIdToBbsUserName(String bbsUserName);

    /**
     * 根据bbs用户名获取bbs用户密码
     * @param bbsUserName   bbs用户名
     * @return bbs用户密码
     */
    String queryBbsUserPasswordByBbsUserName(String bbsUserName);

    /**
     * 根据用户名查询盐值
     * @param bbsUserName   bbs用户名
     * @return  盐值
     */
    String querySaltByBbsUserName(String bbsUserName);

}
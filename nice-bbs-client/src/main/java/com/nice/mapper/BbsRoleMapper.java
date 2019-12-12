package com.nice.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;

@Mapper
public interface BbsRoleMapper {

    /**
     * 根据bbs角色id获取bbs角色名
     * @param bbsRoleId bbs角色id
     * @return  bbs角色名
     */
    String queryBbsRoleNameByBbsRoleId(BigInteger bbsRoleId);
}

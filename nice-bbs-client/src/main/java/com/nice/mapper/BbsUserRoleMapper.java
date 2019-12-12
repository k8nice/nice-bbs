package com.nice.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

@Mapper
public interface BbsUserRoleMapper {

    /**
     * 根据bbs用户id获取bbs角色id
     * @param bbsUserId bbs用户id
     * @return  bbs角色id
     */
    Set<BigInteger> queryBbsRoleIdByBbsUserId(BigInteger bbsUserId);

}

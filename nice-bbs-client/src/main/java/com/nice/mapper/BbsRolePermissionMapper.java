package com.nice.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.Set;

@Mapper
public interface BbsRolePermissionMapper {

    /**
     * 根据bbs角色id获取bbs权限id
     * @param bbsRoleId bbs角色id
     * @return  bbs权限id
     */
    Set<BigInteger> queryBbsPermissionIdByBbsRoleId(BigInteger bbsRoleId);

}

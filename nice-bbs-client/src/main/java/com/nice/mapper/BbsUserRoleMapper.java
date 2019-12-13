package com.nice.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.Set;

/**
 * bbs用户角色关联mapper接口
 *
 * @author nice
 */
@Mapper
public interface BbsUserRoleMapper {

    /**
     * 根据bbs用户id获取bbs角色id
     *
     * @param bbsUserId bbs用户id
     * @return bbs角色id
     */
    Set<BigInteger> queryBbsRoleIdByBbsUserId(BigInteger bbsUserId);

}

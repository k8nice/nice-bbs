package com.nice.mapper;

import org.apache.ibatis.annotations.Mapper;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

/**
 * bbs权限Mapper接口
 *
 * @author nice
 */
@Mapper
public interface BbsPermissionMapper {

    /**
     * 根据bbs权限id获取bbs权限名
     *
     * @param bbsPermissionId bbs权限id
     * @return bbs角色名
     */
    String queryBbsPermissionNameByPermissionId(@NotNull(message = "查找的权限id不能为空") BigInteger bbsPermissionId);

}

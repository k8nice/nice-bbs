package com.nice.domain;

import io.swagger.annotations.Api;
import lombok.Data;

import java.math.BigInteger;

/**
 * bbs权限类
 * @author nice
 */
@Data
@Api(value = "权限实体类")
public class BbsPermission extends BaseEntity {

    /**
     * 权限id(主键)
     */
    private BigInteger bbsPermissionId;

    /**
     * 权限名
     */
    private String bbsPermissionName;

}

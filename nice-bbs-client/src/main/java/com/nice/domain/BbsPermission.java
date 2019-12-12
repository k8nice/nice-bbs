package com.nice.domain;

import lombok.Data;

import java.math.BigInteger;

/**
 * 权限类
 */
@Data
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

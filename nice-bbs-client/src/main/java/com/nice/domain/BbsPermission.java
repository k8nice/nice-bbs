package com.nice.domain;

import lombok.Data;

import java.math.BigInteger;

/**
 * bbs权限类
 * @author nice
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

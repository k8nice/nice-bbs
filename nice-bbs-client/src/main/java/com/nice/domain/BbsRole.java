package com.nice.domain;

import lombok.Data;

import java.math.BigInteger;

/**
 * 角色类
 *
 * @author nice
 */
@Data
public class BbsRole extends BaseEntity {

    /**
     * 角色id(主键)
     */
    private BigInteger bbsRoleId;

    /**
     * 角色名
     */
    private String bbsRoleName;

}

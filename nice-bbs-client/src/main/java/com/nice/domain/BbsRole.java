package com.nice.domain;

import io.swagger.annotations.Api;
import lombok.Data;

import java.math.BigInteger;

/**
 * 角色类
 *
 * @author nice
 */
@Data
@Api("权限实体类")
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

package com.nice.domain.dto;

import lombok.Data;

import java.math.BigInteger;
import java.util.List;

/**
 * 用户与角色关联
 *
 * @author nice
 */
@Data
public class BbsUserRoleDto {

    /**
     * 用户id
     */
    private BigInteger bbsUserId;

    /**
     * 角色id
     */
    private List<BigInteger> bbsRoleId;

}

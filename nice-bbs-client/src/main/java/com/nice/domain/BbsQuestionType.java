package com.nice.domain;

import lombok.Data;

import java.math.BigInteger;

/**
 * bbs问题类型
 */
@Data
public class BbsQuestionType {

    /**
     * bbs问题类型id
     */
    private BigInteger bbsQuestionTypeId;

    /**
     * bbs问题类型名称
     */
    private String bbsQuestionTypeName;

    /**
     * bbs问题索引
     */
    private Integer index;

}

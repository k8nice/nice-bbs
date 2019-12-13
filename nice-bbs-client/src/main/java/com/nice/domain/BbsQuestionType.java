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

    private String bbsQuestionTypeName;

    private Integer index;

}

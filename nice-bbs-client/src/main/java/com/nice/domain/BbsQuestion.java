package com.nice.domain;

import lombok.Data;

import java.math.BigInteger;


/**
 * bbs问题实体类
 * @author nice
 */
@Data
public class BbsQuestion extends BaseEntity {

    /**
     * bbs问题id
     */
    private BigInteger bbsQuestionId;

    /**
     * bbs问题名称
     */
    private String bbsQuestionName;

    /**
     * bbs问题类型
     */
    private String bbsQuestionType;

    /**
     * bbs问题内容
     */
    private String bbsQuestionContent;

    /**
     * bbs问题描述
     */
    private String bbsQuestionDescription;

    /**
     * bbs用户id
     */
    private BigInteger bbsUserId;

}

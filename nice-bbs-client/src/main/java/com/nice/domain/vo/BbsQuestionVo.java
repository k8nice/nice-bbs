package com.nice.domain.vo;

import lombok.Data;

import java.math.BigInteger;

@Data
public class BbsQuestionVo {

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
     * bbs问题描述
     */
    private String bbsQuestionDescription;

    /**
     * bbs用户名
     */
    private String bbsUserName;

}

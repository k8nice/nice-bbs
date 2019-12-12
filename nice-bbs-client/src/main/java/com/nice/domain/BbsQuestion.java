package com.nice.domain;

import lombok.Data;

import java.math.BigInteger;

@Data
public class BbsQuestion extends BaseEntity {


    private BigInteger bbsQuestionId;
    private String bbsQuestionName;
    private String bbsQuestionType;
    private String bbsQuestionContent;
    private String bbsQuestionDescription;
    private BigInteger bbsUserId;

}

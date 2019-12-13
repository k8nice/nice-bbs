package com.nice.service.impl;

import com.nice.domain.BbsQuestion;
import com.nice.mapper.BbsQuestionMapper;
import com.nice.service.BbsQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BbsQuestionServiceImpl implements BbsQuestionService {

    @Autowired(required = false)
    private BbsQuestionMapper bbsQuestionMapper;

    @Override
    public Boolean addQuestion(BbsQuestion bbsQuestion) {
        LocalDateTime localDateTime = LocalDateTime.now();
        bbsQuestion.setGmtCreate(localDateTime);
        bbsQuestion.setGmtModify(localDateTime);
        bbsQuestionMapper.addQuestion(bbsQuestion);
        return true;
    }


}

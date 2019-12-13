package com.nice.service;

import com.nice.domain.BbsQuestion;

/**
 * bbs问题服务
 *
 * @author nice
 */
public interface BbsQuestionService {

    /**
     * 新增问题
     * @param bbsQuestion   bbs问题实体类
     * @return  true or false true为添加成功 false为添加失败
     */
    Boolean addQuestion(BbsQuestion bbsQuestion);

}

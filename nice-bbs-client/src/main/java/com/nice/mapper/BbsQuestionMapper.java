package com.nice.mapper;

import com.nice.domain.BbsQuestion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BbsQuestionMapper  {

    /**
     * 新增问题
     * @param bbsQuestion   bbs问题实体类
     */
    void addQuestion(BbsQuestion bbsQuestion);

    /**
     * 查询问题列表
     * @return
     */
    List<BbsQuestion> queryBbsQuestionList();

    /**
     * 查询问题数量
     * @return Long
     */
    Long queryBbsQuestionCount();
}

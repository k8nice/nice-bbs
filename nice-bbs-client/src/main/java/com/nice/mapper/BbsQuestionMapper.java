package com.nice.mapper;

import com.nice.domain.BbsQuestion;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BbsQuestionMapper {

    /**
     * 新增问题
     * @param bbsQuestion   bbs问题实体类
     */
    void addQuestion(BbsQuestion bbsQuestion);
}

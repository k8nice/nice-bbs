package com.nice.service;

import com.nice.domain.BbsQuestionType;

import java.util.List;

/**
 * bbs问题类型服务接口
 *
 * @author nice
 */
public interface BbsQuestionTypeService {

    /**
     * 添加问题类型到redis缓存中
     */
    void addQuestionTypeToRedis();

    /**
     * 从redis从取出问题类型
     *
     * @return List<BbsQuestionType> bbs问题类型集合
     */
    List<BbsQuestionType> queryQuestionTypesFromRedis();

}

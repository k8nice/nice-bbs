package com.nice.service;

import com.nice.domain.BbsQuestion;

import java.util.List;

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

    /**
     * 查询问题列表
     * @return List<BbsQuestion>
     */
    List<BbsQuestion> queryBbsQuestionList();

    /**
     * 查询分页问题列表
     * @return List<BbsQuestion> 问题集合
     */
    List<BbsQuestion> queryBbsQuestionPageList(Integer pageNum);

    /**
     * 根据创建时间查询问题分页列表
     * @param pageNum 页码
     * @return
     */
    List<BbsQuestion> queryBbsQuestionPageListOrderByGmtCreate(Integer pageNum);

    /**
     * 获取问题页数
     * @param pageSize 每页多少条记录
     * @return Long     总页数
     */
    Long getBbsQuestionPages(Integer pageSize);

    /**
     * 根据问题id查找问题
     * @param bbsQuestionId 问题id
     * @return BbsQuestion  问题实体类
     */
    BbsQuestion queryBbsQuestionByQuestionId(Long bbsQuestionId);
}

package com.nice.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nice.domain.BbsQuestion;
import com.nice.mapper.BbsQuestionMapper;
import com.nice.service.BbsQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * bbs问题业务实现类
 * @author nice
 */
@Service
public class BbsQuestionServiceImpl implements BbsQuestionService {

    @Autowired(required = false)
    private BbsQuestionMapper bbsQuestionMapper;

    /**
     * 添加问题
     * @param bbsQuestion   bbs问题实体类
     * @return
     */
    @Override
    public Boolean addQuestion(BbsQuestion bbsQuestion) {
        LocalDateTime localDateTime = LocalDateTime.now();
        bbsQuestion.setGmtCreate(localDateTime);
        bbsQuestion.setGmtModify(localDateTime);
        bbsQuestionMapper.addQuestion(bbsQuestion);
        return true;
    }

    /**
     * 查询问题列表
     * @return
     */
    @Override
    public List<BbsQuestion> queryBbsQuestionList() {
        return bbsQuestionMapper.queryBbsQuestionList();
    }

    @Override
    public List<BbsQuestion> queryBbsQuestionPageList(Integer pageNum) {
//        PageInfo pageInfo = PageInfo.of(bbsQuestionMapper.queryBbsQuestionList());
//        pageInfo.setPageNum(pageNum);
//        pageInfo.setPageSize(10);
        PageInfo<BbsQuestion> pageInfo = PageHelper.startPage(pageNum, 10).setOrderBy("bbs_question_id desc").doSelectPageInfo(() -> this.bbsQuestionMapper.queryBbsQuestionList());
//        PageHelper.startPage()
        return pageInfo.getList();
    }


    /**
     * 获取问题页数
     * 这里为了前台展示方便，所以只显示前十页数据
     *
     * @param size 每页多少条记录
     * @return
     */
    @Override
    public Long getBbsQuestionPages(Integer size) {
      Long pages =   bbsQuestionMapper.queryBbsQuestionCount()/size;
//        if (bbsQuestionMapper.queryBbsQuestionCount() % size == 0) {
//            return  pages;
//        }
//        else {
//            return pages+1;
//        }
        if (pages >= 10 ) {
            return 10L;
        }
        else if(bbsQuestionMapper.queryBbsQuestionCount()%size != 0 ) {
            return pages + 1;
        }
        else {
            return pages;
        }
    }


}

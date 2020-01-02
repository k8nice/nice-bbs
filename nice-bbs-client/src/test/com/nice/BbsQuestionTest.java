//package com.nice;
//
//import com.github.pagehelper.PageInfo;
//import com.nice.domain.BbsQuestion;
//import com.nice.mapper.BbsQuestionMapper;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@EnableScheduling
//public class BbsQuestionTest {
//
//    @Autowired
//    private BbsQuestionMapper bbsQuestionMapper;
//
////    private static final Logger LOGGER = LoggerFactory.getLogger(BbsQuestionTest.class);
//
//    @Test
//    public void questionQueryCountTest() {
////       BigInteger count = bbsQuestionMapper.();
////       LOGGER.info("count={}",count);
//       List<BbsQuestion> bbsQuestions = bbsQuestionMapper.queryBbsQuestionList();
//        PageInfo pageInfo = PageInfo.of(bbsQuestions);
//        pageInfo.setPageNum(0);
//        pageInfo.setPageSize(10);
//        System.out.println(pageInfo.getList());
////        PageHelper.startPage(0,10).doSelectPageInfo(bbsQuestionMapper.queryBbsQuestionList());
//    }
//
//
//
//}

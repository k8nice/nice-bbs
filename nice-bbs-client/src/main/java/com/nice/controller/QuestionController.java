package com.nice.controller;

import com.nice.domain.BbsQuestion;
import com.nice.domain.BbsQuestionType;
import com.nice.domain.BbsUser;
import com.nice.service.BbsQuestionService;
import com.nice.service.BbsQuestionTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 问题 控制类
 *
 * @author nice
 */
@Controller
@RequestMapping("/question")
public class QuestionController {

    /**
     * 返回的url的前缀
     */
    private final String QUESTION_PREFIX = "/question/question_";


    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionController.class);

    /**
     * 注入bbs问题类型服务
     */
    @Autowired
    private BbsQuestionTypeService bbsQuestionTypeService;


    @Autowired
    private BbsQuestionService bbsQuestionService;

    /**
     * 访问问题列表页面
     *
     * @return "/question/question_list" 问题列表页面的url
     */
    @GetMapping("/list")
    public String accessQuestionListPage(Model model) {
        Long pages = bbsQuestionService.getBbsQuestionPages(10);
        List<Integer> pagesList = new ArrayList<>();
        for (int i =1;i<=pages;i++) {
            pagesList.add(i);
        }
        model.addAttribute("pages",pagesList);
        model.addAttribute("questions",bbsQuestionService.queryBbsQuestionList());
        return QUESTION_PREFIX + "list";
    }

    /**
     * 访问添加问题页面
     *
     * @param model model视图
     * @return "/question/question_add" 返回添加问题的url
     */
    @GetMapping("/add")
    public String accessQuestionAddPage(Model model) {
        //从redis中获取问题类型
        List<BbsQuestionType> bbsQuestionTypes = bbsQuestionTypeService.queryQuestionTypesFromRedis();
//        bbsQuestionTypes.forEach((bbsQuestionType) -> {
//            bbsQuestionType.setIndex(0);
//        } );
        //给问题类型添加索引
        Stream.iterate(0, i -> i + 1).limit(bbsQuestionTypes.size()).forEach((i -> {
            BbsQuestionType bbsQuestionType = bbsQuestionTypes.get(i);
            bbsQuestionType.setIndex(i);
        }));
        //把问题类型添加到model中
        model.addAttribute("bbsQuestionTypes", bbsQuestionTypes);
        return QUESTION_PREFIX + "add";
    }

    /**
     * 提交问题
     *
     * @param bbsQuestion bbs问题实体类
     * @return "redirect:/"  返回到首页
     */
    @PostMapping("/add")
    public String addQuestion(BbsQuestion bbsQuestion,HttpServletRequest request) {
        BbsUser bbsUser = (BbsUser) request.getSession().getAttribute("USER_SESSION");
        bbsQuestion.setBbsUserId(bbsUser.getBbsUserId());
        if (bbsQuestionService.addQuestion(bbsQuestion)) {
            return "redirect:/";
        } else {
            return QUESTION_PREFIX +"add";
        }
    }


}

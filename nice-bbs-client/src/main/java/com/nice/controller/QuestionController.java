package com.nice.controller;

import com.nice.domain.BbsQuestion;
import com.nice.domain.BbsQuestionType;
import com.nice.service.BbsQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Stream;

/**
 * 问题 控制类
 * @author nice
 */
@Controller
@RequestMapping("/question")
public class QuestionController {

    private final String QUESTION_SUFFIX = "/question/question_" ;

    @Autowired
    BbsQuestionTypeService bbsQuestionTypeService;

    @GetMapping("/list")
    public String accessQuestionListPage() {
        return QUESTION_SUFFIX + "list";
    }

    @GetMapping("/add")
    public String accessQuestionAddPage(Model model) {
        List<BbsQuestionType> bbsQuestionTypes  =bbsQuestionTypeService.queryQuestionTypesFromRedis();
//        bbsQuestionTypes.forEach((bbsQuestionType) -> {
//            bbsQuestionType.setIndex(0);
//        } );
        Stream.iterate(0,i-> i+1).limit(bbsQuestionTypes.size()).forEach((i -> {
           BbsQuestionType  bbsQuestionType =   bbsQuestionTypes.get(i);
           bbsQuestionType.setIndex(i);
        }));
        model.addAttribute("bbsQuestionTypes",bbsQuestionTypes);
        return QUESTION_SUFFIX + "add";
    }

    @PostMapping("/add")
    public String addQuestion(BbsQuestion bbsQuestion) {
        System.out.println(bbsQuestion);
        return "redirect:/";
    }



}

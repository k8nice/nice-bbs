package com.nice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 问题 控制类
 * @author nice
 */
@Controller
@RequestMapping("/question")
public class QuestionController {

    private final String QUESTION_SUFFIX = "/question/question_" ;

    @GetMapping("/list")
    public String accessQuestionListPage() {
        return QUESTION_SUFFIX + "list";
    }

    @GetMapping("/add")
    public String accessQuestionAddPage() {
        return QUESTION_SUFFIX + "add";
    }



}

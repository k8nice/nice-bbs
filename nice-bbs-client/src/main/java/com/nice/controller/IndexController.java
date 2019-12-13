package com.nice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {

    /**
     * 访问首页
     * @return  "index" 主页面
     */
    @GetMapping("/")
    public String accessIndexPage() {
        return "index";
    }

}

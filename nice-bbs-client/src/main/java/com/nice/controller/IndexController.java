package com.nice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 主控制器
 *
 * @author nice
 */
@Controller
public class IndexController {

    /**
     * 访问首页
     *
     * @return "index" 主页面
     */
    @GetMapping("/")
    public String accessIndexPage() {
        //返回首页
        return "index";
    }

}

package com.nice.config;

import com.nice.service.impl.BbsQuestionTypeServiceImpl;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/**
 * 用来配置所有同项目一起启动的组件
 *
 * @author nice
 */
@Configuration
@Import(BbsQuestionTypeServiceImpl.class)
public class AppConfig {
}

package com.nice.service.impl;

import com.google.gson.Gson;
import com.nice.commons.JsonUtils;
import com.nice.domain.BbsQuestionType;
import com.nice.mapper.BbsQuestionTypeMapper;
import com.nice.service.BbsQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 问题类型业务实现类
 * @author nice
 */
@Component
public class BbsQuestionTypeServiceImpl implements BbsQuestionTypeService {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private BbsQuestionTypeMapper bbsQuestionTypeMapper;

    /**
     * 添加问题类型到redis中
     */
    @Bean
    @Override
    public void addQuestionTypeToRedis() {
        //创建一个Gson对象用来序列化
        Gson gson = new Gson();
        //把问题类型集合序列化后存入redis中
        redisTemplate.opsForValue().set("bbsQuestionTypes",gson.toJson(bbsQuestionTypeMapper.queryAllQuestionTypes()));
    }


    @Override
    public List<BbsQuestionType> queryQuestionTypesFromRedis() {
        Gson gson = new Gson();
        String json = (String) redisTemplate.opsForValue().get("bbsQuestionTypes");
        List<BbsQuestionType> bbsQuestionTypes = JsonUtils.toList(json,BbsQuestionType.class);
        return bbsQuestionTypes;
    }
}

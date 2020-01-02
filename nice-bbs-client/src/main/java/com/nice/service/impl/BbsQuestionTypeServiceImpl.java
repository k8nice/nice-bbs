package com.nice.service.impl;

import com.google.gson.Gson;
import com.nice.commons.JsonUtils;
import com.nice.domain.BbsQuestionType;
import com.nice.mapper.BbsQuestionTypeMapper;
import com.nice.service.BbsQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 问题类型业务实现类
 *
 * @author nice
 */
@Component
public class BbsQuestionTypeServiceImpl implements BbsQuestionTypeService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired(required = false)
    private BbsQuestionTypeMapper bbsQuestionTypeMapper;

    /**
     * 添加问题类型到redis中
     */
    @Bean
    @Override
    public String addQuestionTypeToRedis() {
        //创建一个Gson对象用来序列化
        Gson gson = new Gson();
        //把问题类型集合序列化后存入redis中
        redisTemplate.opsForValue().set("bbsQuestionTypes", gson.toJson(bbsQuestionTypeMapper.queryAllQuestionTypes()));
        return gson.toString();
    }

    /**
     * 从redis中获取文章类型
     *
     * @return List<BbsQuestionType> 文章类型的list集合
     */
    @Override
    public List<BbsQuestionType> queryQuestionTypesFromRedis() {
        //创建一个Gson对象
        Gson gson = new Gson();
        //获取文章类型的json
        String json = (String) redisTemplate.opsForValue().get("bbsQuestionTypes");
        //把json转换成文章类型的list集合
        List<BbsQuestionType> bbsQuestionTypes = JsonUtils.toList(json, BbsQuestionType.class);
        //返回该list集合
        return bbsQuestionTypes;
    }
}

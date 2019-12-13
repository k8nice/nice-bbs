package com.nice;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nice.commons.JsonUtils;
import com.nice.domain.BbsQuestionType;
import com.nice.shiro.CustomRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("com.nice")
//@MapperScan("com.nice.mapper")
//@Import(value = com.nice.shiro.ShiroConfiguration.class)
public class ShiroApplicationTest {

    @Autowired
    private CustomRealm customRealm;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void test() {
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(new CustomRealm());
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("nice","224164b32f9778e48e648a047ae72090");
        subject.login(token);
        System.out.println(subject.hasRole("admin"));

    }

    @Test
    public void test1() {
        String json = (String) redisTemplate.opsForValue().get("bbsQuestionTypes");
        List<BbsQuestionType> bbsQuestionTypes = JsonUtils.toList(json,BbsQuestionType.class);
        System.out.println(bbsQuestionTypes.get(0).getBbsQuestionTypeName());
//        System.out.println(json);
    }


}

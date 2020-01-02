package com.nice.controller;

import com.nice.domain.BbsUser;
import com.nice.mapper.BbsUserMapper;
import com.nice.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录控制类
 *
 * @author nice
 */
@Api("登录控制类")
@Controller
@Slf4j
public class LoginController {

/*    @Autowired
    private CustomRealm customRealm;*/

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    /**
     * 注入登录服务
     */
    @Autowired
    private LoginService loginService;


    @Autowired(required = false)
    private BbsUserMapper bbsUserMapper;

    /**
     * 访问登录页面
     *
     * @return "login" 登录页面
     */
    @GetMapping("/login")
    @ApiOperation(value = "访问登录页",notes = "返回登录页面")
    public String accessLoginPage() {
        return "login";
    }

    /**
     * 登录用户
     *
     * @param bbsUser bbs用户实体类
     * @return "/login" 登录页面
     */
    @PostMapping("/login")
    public String loginBbsUser(BbsUser bbsUser, HttpServletRequest request) {



/*        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(customRealm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        Md5Hash md5Hash = new Md5Hash(bbsUser.getBbsUserPassword(),"6c6041de-bfd1-46ca-82e4-b27d91d24eec",1);
        UsernamePasswordToken token = new UsernamePasswordToken("nice",md5Hash.toString());
        subject.login(token);
        System.out.println(subject.hasRole("admin"));*/
        //登录成功，返回首页，否则重新返回登录页面
        if (loginService.loginBbsUser(bbsUser)) {
            BbsUser sessionBbsUser = new BbsUser();
            sessionBbsUser.setBbsUserId(bbsUserMapper.queryBbsUserIdByBbsUserName(bbsUser.getBbsUserName()));
            sessionBbsUser.setBbsUserName(bbsUser.getBbsUserName());
//            LOGGER.info("当前登录的用户为{}",bbsUser.getBbsUserName());
            log.info("当前登录的用户为{}",bbsUser.getBbsUserName());
            request.getSession().setAttribute("USER_SESSION",sessionBbsUser);
            return "redirect:/";
        } else {
            return "login";
        }
    }

}

package com.nice.controller;

import com.nice.domain.BbsUser;
import com.nice.mapper.BbsUserMapper;
import com.nice.service.LoginService;
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
@Controller
public class LoginController {

/*    @Autowired
    private CustomRealm customRealm;*/

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
            request.getSession().setAttribute("USER_SESSION",sessionBbsUser);
            return "redirect:/";
        } else {
            return "login";
        }
    }

}

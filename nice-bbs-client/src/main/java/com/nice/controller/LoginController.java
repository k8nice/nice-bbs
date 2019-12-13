package com.nice.controller;

import com.nice.domain.BbsUser;
import com.nice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 登录控制类
 */
@Controller
public class LoginController {

/*    @Autowired
    private CustomRealm customRealm;*/

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String accessLoginPage() {
        return "login";
    }


    @PostMapping("/login")
    public String loginBbsUser(BbsUser bbsUser) {
/*        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(customRealm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();
        Md5Hash md5Hash = new Md5Hash(bbsUser.getBbsUserPassword(),"6c6041de-bfd1-46ca-82e4-b27d91d24eec",1);
        UsernamePasswordToken token = new UsernamePasswordToken("nice",md5Hash.toString());
        subject.login(token);
        System.out.println(subject.hasRole("admin"));*/
        if (loginService.loginBbsUser(bbsUser)) {
            return"redirect:/";
        }
        else {
            return "login";
        }
    }

}

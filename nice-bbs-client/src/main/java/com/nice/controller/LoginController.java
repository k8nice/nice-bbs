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
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录控制类
 *
 * @author nice
 */
@Api("登录控制类")
@Controller
@Slf4j
@RequestMapping
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
     * 注入验证码工具
     */
//    @Autowired
//    private DefaultKaptcha captchaProducer;

    /**
     * 访问登录页面
     *
     * @return "login" 登录页面
     */
    @GetMapping("/login")
    @ApiOperation(value = "访问登录页",notes = "返回登录页面")
    public String accessLoginPage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
/*        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = captchaProducer.createText();
            httpServletRequest.getSession().setAttribute("vrifyCode", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = captchaProducer.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            try {
                httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
//            return;
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
/*        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                null;
        try {
            responseOutputStream = httpServletResponse.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            responseOutputStream.write(captchaChallengeAsJpeg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            responseOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            responseOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
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
            log.error("登录失败");
            return "login";
        }
    }

}

package com.nice.service.impl;

import com.nice.domain.BbsUser;
import com.nice.mapper.BbsUserMapper;
import com.nice.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录服务实现类
 *
 * @author nice
 */
@Service
public class LoginServiceImpl implements LoginService {

/*    @Autowired
    private CustomRealm customRealm;*/

    /**
     * 注入bbs用户Mapper
     */
    @Autowired(required = false)
    private BbsUserMapper bbsUserMapper;

    /**
     * 登录bbs用户
     *
     * @param bbsUser bbs用户实体类
     * @return true or false
     */
    @Override
    public Boolean loginBbsUser(BbsUser bbsUser) {
/*        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(customRealm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);*/
        Subject subject = SecurityUtils.getSubject();
        //加密
        Md5Hash md5Hash = new Md5Hash(bbsUser.getBbsUserPassword(), bbsUserMapper.querySaltByBbsUserName(bbsUser.getBbsUserName()), 1);
        //把用户名和密码添加到token中
        UsernamePasswordToken token = new UsernamePasswordToken("nice", md5Hash.toString());
        //token认证登录
        subject.login(token);
        if (subject.isAuthenticated()) {
            //授权成功返回true
            return true;
        } else {
            //授权失败返回false
            return false;
        }
    }
}

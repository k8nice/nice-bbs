package com.nice.service.impl;

import com.nice.domain.BbsUser;
import com.nice.mapper.BbsUserMapper;
import com.nice.service.LoginService;
import com.nice.shiro.CustomRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

//    @Autowired
//    private CustomRealm customRealm;

    @Autowired(required = false)
    private BbsUserMapper bbsUserMapper;

    @Override
    public Boolean loginBbsUser(BbsUser bbsUser) {
/*        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(customRealm);
        SecurityUtils.setSecurityManager(defaultSecurityManager);*/
        Subject subject = SecurityUtils.getSubject();
        Md5Hash md5Hash = new Md5Hash(bbsUser.getBbsUserPassword(),bbsUserMapper.querySaltByBbsUserName(bbsUser.getBbsUserName()),1);
        UsernamePasswordToken token = new UsernamePasswordToken("nice",md5Hash.toString());
        subject.login(token);
        if (subject.isAuthenticated()) {
            return true;
        }
        else {
            return false;
        }
    }
}

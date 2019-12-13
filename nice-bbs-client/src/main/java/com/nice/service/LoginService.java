package com.nice.service;

import com.nice.domain.BbsUser;

/**
 * 登录服务接口
 *
 * @author nice
 */
public interface LoginService {

    /**
     * 登录bbs用户
     *
     * @param bbsUser bbs用户实体类
     * @return true or false
     */
    Boolean loginBbsUser(BbsUser bbsUser);

}

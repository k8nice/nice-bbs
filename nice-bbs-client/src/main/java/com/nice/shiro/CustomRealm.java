package com.nice.shiro;


import com.nice.mapper.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * 自定义Realm
 * The current class is   ...
 * This ide name is IntelliJ IDEA.
 * The current project name is shiro-test.
 * The current package name is com.nice.test.realm.
 *
 * @author nice
 * @version jdk1.8
 * @date 2019/12/10 8:52
 */
@Component
public class CustomRealm extends AuthorizingRealm {



/*    @Autowired
    private UserDao userDao;*/


    @Autowired(required = false)
    private  BbsUserMapper bbsUserMapper;

    @Autowired(required = false)
    private  BbsUserRoleMapper bbsUserRoleMapper;

    @Autowired(required = false)
    private  BbsRolePermissionMapper bbsRolePermissionMapper;

    @Autowired(required = false)
    private  BbsPermissionMapper bbsPermissionMapper;

    @Autowired(required = false)
    private  BbsRoleMapper bbsRoleMapper;

//    public static CustomRealm customRealm;


/*    @Autowired
    @Override
    @Autowired
    @PostConstruct
    public  void init() {
        bbsUserMapper = this;
        bbsUserRoleMapper = this.bbsUserRoleMapper;
        bbsRolePermissionMapper = this.bbsRolePermissionMapper;
        bbsPermissionMapper = this.bbsPermissionMapper;
        bbsRoleMapper = this.bbsRoleMapper;
        customRealm = this;
        customRealm.bbsPermissionMapper = this.bbsPermissionMapper;
        customRealm.bbsRoleMapper = this.bbsRoleMapper;
        customRealm.bbsRolePermissionMapper = this.bbsRolePermissionMapper;
        customRealm.bbsUserMapper = this.bbsUserMapper;
        customRealm.bbsUserRoleMapper = this.bbsUserRoleMapper;
    }*/

    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String bbsUserName = (String) principals.getPrimaryPrincipal();
        BigInteger bbsUserId = bbsUserMapper.queryBbsUserIdByBbsUserName(bbsUserName);
        Set<BigInteger> roleIds = getRoleIdsByUserId(bbsUserId);
       Set<String> permissions =   getPermissionsByRoleId(roleIds);
//        Set<BigInteger> permissions = getPermissionsByUserId(bbsUserId);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        Set<String> roles =  getRolesByRoleIds(roleIds);
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }

    /**
     * 根据角色id获取角色
     * @param roleIds 角色id集合
     * @return 角色名集合
     */
    private Set<String> getRolesByRoleIds(Set<BigInteger> roleIds) {
        //创建一个HashSet集合
        Set<String> roles = new HashSet<>();
        //lambda表达式遍历角色id
        roleIds.forEach((roleId) -> {
            //根据角色id获取角色名并写入集合中
            roles.add(bbsRoleMapper.queryBbsRoleNameByBbsRoleId(roleId));
        });
        //返回角色集合
        return roles;
    }

    /**
     * 根据角色id获取权限
     * @param roles 角色集合
     * @return  权限集合
     */
    private Set<String> getPermissionsByRoleId(Set<BigInteger> roles) {
        Set<BigInteger> permissions = new HashSet<>();
        roles.forEach((roleId)->{
            permissions.addAll(bbsRolePermissionMapper.queryBbsPermissionIdByBbsRoleId(roleId));
        });
        Set<String> sets = new HashSet<>();
        permissions.forEach((permissionId) -> {
            sets.add("user:"+bbsPermissionMapper.queryBbsPermissionNameByPermissionId(permissionId));
        } );
/*        sets.add("user:delete");
        sets.add("user:add");*/
        return sets;
    }

    private Set<BigInteger> getRoleIdsByUserId(BigInteger bbsUserId) {
        Set<BigInteger> roleIds = bbsUserRoleMapper.queryBbsRoleIdByBbsUserId(bbsUserId);
        return roleIds;
    }

    /**
     * 认证
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //从主体传过来的认证信息中，获得用户名。
        String userName = (String) token.getPrincipal();
        //通过用户名到数据库中获取凭证
        String password = getPasswordByUserName(userName);
        if (password == null) {
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName,password,userName);
        authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(userName));
        return authenticationInfo;
    }

    /**
     * 模拟数据库
     * @param userName
     * @return
     */
    private String getPasswordByUserName(String userName) {
        if (StringUtils.isNotBlank(userName)) {
            String bbsUserPassword = bbsUserMapper.queryBbsUserPasswordByBbsUserName(userName);
            return bbsUserPassword;
        }

/*        User user = userDao.getUserByUserName(userName);
        if (user != null) {
            return user.getPassword();
        }
        return userMap.get(userName);*/
        return null;
    }

    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("smile","6c6041de-bfd1-46ca-82e4-b27d91d24eec");
        System.out.println(md5Hash.toString());
    }

}

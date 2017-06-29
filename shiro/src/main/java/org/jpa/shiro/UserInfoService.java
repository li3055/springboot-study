package org.jpa.shiro;

import org.jpa.shiro.bean.UserInfo;

public interface UserInfoService {
   
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
   
}
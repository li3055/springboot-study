package org.jpa.shiro;

import javax.annotation.Resource;

import org.jpa.shiro.bean.UserInfo;
import org.springframework.stereotype.Service;
 
@Service
public class UserInfoServiceImpl implements UserInfoService{
   
    @Resource
    private UserInfoRepository userInfoRepository;
   
    @Override
    public UserInfo findByUsername(String username) {
       System.out.println("UserInfoServiceImpl.findByUsername()");
       return userInfoRepository.findByUsername(username);
    }
   
}
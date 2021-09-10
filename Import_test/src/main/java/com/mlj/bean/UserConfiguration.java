package com.mlj.bean;

import org.springframework.context.annotation.Bean;

/**
 * 没有任何spring注解
 */
public class UserConfiguration {
    @Bean
    public User getUser(){
        User user = new User();
        user.setAge(18);
        user.setUserName("小王");
        return user;
    }
}

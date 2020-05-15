package com.test;

import com.pojo.User;
import com.servive.UserService;
import com.servive.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    UserService userService=new UserServiceImpl();

    @Test
    public void registUser() {
        userService.registUser(new User(null,"bbj168","123456","bbj168@qq.com"));
        userService.registUser(new User(null,"abc168","123456","abc168@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"admin","admin","admin@qq.com")));
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("wzg168")){
            System.out.println("用户名存在");
        }else{
            System.out.println("用户名可用");
        }
    }
}
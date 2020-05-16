package com.web;

import com.pojo.User;
import com.servive.UserService;
import com.servive.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private UserService userService=new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //调用userservice。login（）登录处理业务
        User loginUser = userService.login(new User(null,username,password,null));
        //如果等于null，登录失败
        if (loginUser==null){
            //跳回登录界面
            req.getRequestDispatcher("/pages/login.html").forward(req,resp);
        }else {
            req.getRequestDispatcher("/pages/login_success.html").forward(req,resp);
        }
    }
}

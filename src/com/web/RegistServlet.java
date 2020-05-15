package com.web;

import com.pojo.User;
import com.servive.UserService;
import com.servive.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    private UserService userService=new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        //检查验证码是否正确 要求验证码为abcd
        if ("abcd".equalsIgnoreCase(code)){
            if (userService.existsUsername(username)){
                System.out.println("用户名已存在");
                req.getRequestDispatcher("/pages/regist.html").forward(req,resp);
            }else{
                userService.registUser(new User(null,username,password,email));
                req.getRequestDispatcher("/pages/regist_success.html").forward(req,resp);
            }
        }else{
            System.out.println("验证码错误");
            req.getRequestDispatcher("/pages/regist.html").forward(req,resp);
        }
    }
}

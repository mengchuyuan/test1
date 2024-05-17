package com.xxxx.controller;

import com.xxxx.entity.Files;
import com.xxxx.entity.User;
import com.xxxx.entity.vo.MessageModel;
import com.xxxx.service.UserService;
//import sun.net.httpserver.HttpServerImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")

public class UserServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");

    MessageModel messageModel = userService.userLogin(uname,upwd);
    if(messageModel.getCode() == 1){
        User user = (User) messageModel.getObject();

        // 创建Files实例并设置userId



        // 将Files实例添加到会话中


        if(user.getUserId().equals("1")){

            request.getSession().setAttribute("user", messageModel.getObject());
            response.sendRedirect("teacher.jsp");
        }else {request.getSession().setAttribute("user", messageModel.getObject());
            response.sendRedirect("student.jsp");

        }}else{
            request.setAttribute(" messageModel", messageModel);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}

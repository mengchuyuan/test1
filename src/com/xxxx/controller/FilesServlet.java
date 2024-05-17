package com.xxxx.controller;

import com.alibaba.fastjson2.JSON;
import com.xxxx.entity.Files;
import com.xxxx.service.FilesService;
import com.xxxx.service.FilesServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "FilesServlet", value = "/FilesServlet")

public class FilesServlet extends HttpServlet {
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       FilesService filesService = new FilesServiceImpl();
       List<Files> files = filesService.selectAll();
       String filesStr = JSON.toJSONString(files);
       response.setContentType("text/json;charset=utf-8");
       response.getWriter().write(filesStr);
   }
   
   @Override
    protected  void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
    doGet(request,response);
   }
}

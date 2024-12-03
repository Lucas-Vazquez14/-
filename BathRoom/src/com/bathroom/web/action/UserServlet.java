package com.bathroom.web.action;

import com.bathroom.exception.AppException;
import com.bathroom.service.Impl.UserServiceImpl;
import com.bathroom.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/user/login","/user/exit"})
//登录的controller，处理登录的业务
public class UserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String servletPath = request.getServletPath();
        if(servletPath.equals("/user/login")){
            doLogin(request,response);
        }else if(servletPath.equals("/user/exit")){
            try {
                doExit(request,response);
            } catch (AppException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void doExit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, AppException {
        userService.exit(request, response);
        response.sendRedirect(request.getContextPath());
    }

    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int flag = userService.login(request, response);
            if (flag == 1) {
                //进入预约系统
                response.sendRedirect(request.getContextPath()+"/function/show");
            } else if (flag == 2) {
                //进入管理列表
                response.sendRedirect("../list.jsp");
            }
        }catch (AppException e){
            response.sendRedirect("../error.jsp");
        }
    }

}

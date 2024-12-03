package com.bathroom.service.Impl;

import com.bathroom.bean.Users;
import com.bathroom.dao.UsersDao;
import com.bathroom.dao.impl.UsersDaoImpl;
import com.bathroom.exception.AppException;
import com.bathroom.service.UserService;
import com.bathroom.utils.DBUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

//业务代码
public class UserServiceImpl implements UserService {
    private UsersDao usersDao = new UsersDaoImpl();
    @Override
    public int login(HttpServletRequest request, HttpServletResponse response) throws AppException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int flag = 0;
        //flag表示登录状态 2表示管理者模式 1表示登录成功 0表示失败
        try(Connection conn = DBUtil.getConnection()){
            Users users=usersDao.selectByUsername(username);
            if(users!=null){
                if(users.getName().equals("admin")&&users.getPassword().equals(password)){
                    HttpSession session = request.getSession();
                    session.setAttribute("user", users);
                    flag=2;
                } else if (users.getPassword().equals(password)) {
                    flag=1;
                    HttpSession session = request.getSession();
                    session.setAttribute("user", users);
                    String f =request.getParameter("f");
                    //选了就加cookie
                    if("1".equals(f)){
                        Cookie cookie = new Cookie("username",username);
                        Cookie cookie2 = new Cookie("password",password);
                        cookie.setMaxAge(60 * 60 * 24 * 7);
                        cookie2.setMaxAge(60 * 60 * 24 * 7);
                        cookie.setPath(request.getContextPath());
                        cookie2.setPath(request.getContextPath());
                        response.addCookie(cookie);
                        response.addCookie(cookie2);
                    }
                }
            }
        }catch (SQLException e){
           //进入异常
            throw new AppException("登录异常请稍后再试!");
        }
        return flag;
    }

    @Override
    public void exit(HttpServletRequest request, HttpServletResponse response) throws AppException, IOException {
        HttpSession session = request.getSession(false);
        if(session!=null && session.getAttribute("user")!=null){
            session.removeAttribute("user");

            session.invalidate();
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("username")||cookie.getName().equals("password")) {
                        cookie.setPath(request.getContextPath());
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }
                }
            }
        }
    }
}

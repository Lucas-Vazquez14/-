package com.bathroom.web.action;

import com.bathroom.bean.Users;
import com.bathroom.dao.UsersDao;
import com.bathroom.dao.impl.UsersDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet({"/welcome"})
public class WelcomeServlet extends HttpServlet {
    private UsersDao usersDao = new UsersDaoImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("username")) {
                    username = c.getValue();
                }else if (c.getName().equals("password")) {
                    password = c.getValue();
                }
            }
        }
        int flag = 0;
        Users user = new Users();
        if (username != null && password != null) {

            user = usersDao.selectByUsername(username);
            if(user != null) {
                if(password.equals(user.getPassword())) {
                    flag = 1;
                }
            }
            //利用cookie登录成功
            if(flag == 1) {
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
                response.sendRedirect(request.getContextPath()+"/function/show");
            }
        }else{
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }
    }
}

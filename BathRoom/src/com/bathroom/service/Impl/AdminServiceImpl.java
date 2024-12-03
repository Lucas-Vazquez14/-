package com.bathroom.service.Impl;

import com.bathroom.bean.Users;
import com.bathroom.dao.UsersDao;
import com.bathroom.dao.impl.UsersDaoImpl;
import com.bathroom.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    private UsersDao usersDao = new UsersDaoImpl();
    @Override
    public int add(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        int num = Integer.parseInt(request.getParameter("num"));
        Users user = new Users(name, password, num);
        return usersDao.addUsers(user);
    }

    @Override
    public int delete(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        return usersDao.deleteByUsername(name);
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Users user = usersDao.selectByUsername(name);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/editUser.jsp").forward(request,response);
    }

    //收集数据，转发给jsp展示
    @Override
    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Users> list = new ArrayList<>();
        list = usersDao.selectAllUsers();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/detail.jsp").forward(request,response);
    }

    @Override
    public int modify(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        int num = Integer.parseInt(request.getParameter("num"));
        Users user = new Users(name, password, num);
        return usersDao.updateUsers(user);
    }
}

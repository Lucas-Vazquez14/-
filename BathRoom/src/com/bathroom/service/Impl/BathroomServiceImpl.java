package com.bathroom.service.Impl;

import com.bathroom.bean.Bathrooms;
import com.bathroom.dao.BathroomsDao;
import com.bathroom.dao.impl.BathroomsDaoImpl;
import com.bathroom.service.BathroomService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class BathroomServiceImpl implements BathroomService {
    private BathroomsDao bathroomsDao = new BathroomsDaoImpl();
    @Override
    public int add(HttpServletRequest request, HttpServletResponse response) {
        Bathrooms bathrooms = new Bathrooms(false);
        return bathroomsDao.addBathrooms(bathrooms);
    }

    @Override
    public int delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        return bathroomsDao.deleteById(id);
    }

    @Override
    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean status = bathroomsDao.checkById(id);
        Bathrooms bathrooms = new Bathrooms(id,status);
        request.setAttribute("bathrooms", bathrooms);
        request.getRequestDispatcher("/editBathroom.jsp").forward(request,response);
    }

    @Override
    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Bathrooms> list = bathroomsDao.getAllBathrooms();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/b_detail.jsp").forward(request,response);
    }

    @Override
    public int modify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean status = Objects.equals(request.getParameter("status"), "available");
        Bathrooms bathrooms = new Bathrooms(id,status);
        return bathroomsDao.updateBathrooms(bathrooms);
    }
}

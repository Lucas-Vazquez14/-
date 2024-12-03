package com.bathroom.service.Impl;

import com.bathroom.bean.Bathrooms;
import com.bathroom.bean.Users;
import com.bathroom.bean.reservations;
import com.bathroom.dao.BathroomsDao;
import com.bathroom.dao.ReservationsDao;
import com.bathroom.dao.UsersDao;
import com.bathroom.dao.impl.BathroomsDaoImpl;
import com.bathroom.dao.impl.ReservationsDaoImpl;
import com.bathroom.dao.impl.UsersDaoImpl;
import com.bathroom.service.BathroomService;
import com.bathroom.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private UsersDao usersDao = new UsersDaoImpl();
    private BathroomsDao bathroomsDao = new BathroomsDaoImpl();
    private ReservationsDao reservationsDao = new ReservationsDaoImpl();
    @Override
    public int add(HttpServletRequest request, HttpServletResponse response) {
        return 0;
    }

    @Override
    public int delete(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Users user = usersDao.selectByUsername(name);
        long id = reservationsDao.selectByUserName(name);
        boolean status = bathroomsDao.checkById(id);
        Bathrooms bathroom = new Bathrooms(id,status);
        return reservationsDao.deleteReservation(user,bathroom);
    }

    @Override
    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<reservations> list = new ArrayList<>();
        list = reservationsDao.selectAllReservations();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/o_detail.jsp").forward(request,response);
    }

}

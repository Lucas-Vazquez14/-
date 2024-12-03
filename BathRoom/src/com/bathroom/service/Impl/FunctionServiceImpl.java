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
import com.bathroom.service.FunctionService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class FunctionServiceImpl implements FunctionService {
    private UsersDao usersDao = new UsersDaoImpl();
    private BathroomsDao bathroomsDao = new BathroomsDaoImpl();
    private ReservationsDao reservationsDao = new ReservationsDaoImpl();
    @Override
    public void select(HttpServletRequest request, HttpServletResponse response) {
        List<Bathrooms> list = new ArrayList<>();
        list = bathroomsDao.getAllBathrooms();
        request.setAttribute("bathrooms", list);
    }

    @Override
    public boolean deal(HttpServletRequest request, HttpServletResponse response) {
        long bath_id =  Long.parseLong(request.getParameter("bath_id"));
        boolean status = bathroomsDao.checkById(bath_id);
        //如果浴室不可用
        if(!status){
            return false;
        }
        status = false;
        Bathrooms bathrooms = new Bathrooms(bath_id,status);
        Users user = new Users();
        HttpSession session = request.getSession();
        user = (Users) session.getAttribute("user");
        int num = user.getNum();
        //余额次数够用
        if(num>0){
            num--;
            user.setNum(num);
            session.setAttribute("user", user);
            //更新数据库
            usersDao.updateUsers(user);
            //更新浴室状态
            bathroomsDao.updateBathrooms(bathrooms);
            //更新订单状态
            reservationsDao.addReservation(user,bathrooms);
            return true;
        }
        return false;
    }

    @Override
    public void order(HttpServletRequest request, HttpServletResponse response) {
        List <reservations> list = new ArrayList<>();
        list = reservationsDao.selectAllReservations();
        request.setAttribute("list", list);
    }

    @Override
    public void end(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        Long bathroom_id = Long.parseLong(request.getParameter("bathroom_id"));
        Users user = usersDao.selectByUsername(username);
        boolean status = bathroomsDao.checkById(bathroom_id);
        Bathrooms bathrooms = new Bathrooms(bathroom_id,status);
        //修改浴室状态
        status = !status;
        bathrooms.setStatus(status);
        bathroomsDao.updateBathrooms(bathrooms);
        //删除订单
        reservationsDao.deleteReservation(user,bathrooms);
    }
}

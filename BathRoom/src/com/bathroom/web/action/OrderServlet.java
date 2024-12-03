package com.bathroom.web.action;

import com.bathroom.service.Impl.OrderServiceImpl;
import com.bathroom.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/order/add","/order/detail","/order/delete"})
public class OrderServlet extends HttpServlet {
    private OrderService orderservice= new OrderServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ServletPath = request.getServletPath();
        if(ServletPath.equals("/order/detail")){
            orderservice.detail(request, response);
        }else if(ServletPath.equals("/order/delete")){
            int flag = orderservice.delete(request, response);
            if(flag == 1){
                response.sendRedirect(request.getContextPath()+"/order/detail");
            }
        }
    }
}

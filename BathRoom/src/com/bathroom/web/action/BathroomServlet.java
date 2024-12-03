package com.bathroom.web.action;

import com.bathroom.service.BathroomService;
import com.bathroom.service.Impl.BathroomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/bathroom/detail","/bathroom/add","/bathroom/delete","/bathroom/update","/bathroom/modify"})
public class BathroomServlet extends HttpServlet {
    private BathroomService bathroomService = new BathroomServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ServletPath = request.getServletPath();
        if(ServletPath.equals("/bathroom/detail")){
            bathroomService.detail(request,response);
        } else if (ServletPath.equals("/bathroom/add")) {
            int flag = bathroomService.add(request, response);
            if (flag == 1) {
                response.sendRedirect(request.getContextPath()+"/bathroom/detail");
            } else {
                response.sendRedirect(request.getContextPath()+"/error.jsp");
            }
        } else if (ServletPath.equals("/bathroom/delete")) {
            int flag = bathroomService.delete(request, response);
            if (flag == 1) {
                response.sendRedirect(request.getContextPath()+"/bathroom/detail");
            }else {
                response.sendRedirect(request.getContextPath()+"/error.jsp");
            }
        } else if (ServletPath.equals("/bathroom/modify")) {
            int flag = bathroomService.modify(request, response);
            if (flag == 1) {
                response.sendRedirect(request.getContextPath()+"/bathroom/detail");
            } else {
                response.sendRedirect(request.getContextPath()+"/error.jsp");
            }
        } else if (ServletPath.equals("/bathroom/update")) {
            bathroomService.update(request, response);
        }
    }
}

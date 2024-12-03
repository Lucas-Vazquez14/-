package com.bathroom.web.action;

import com.bathroom.service.FunctionService;
import com.bathroom.service.Impl.FunctionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet({"/function/show","/function/deal","/function/order","/function/end"})
public class FunctionServlet extends HttpServlet {
    private FunctionService functionService = new FunctionServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ServletPath = request.getServletPath();
        if (ServletPath.equals("/function/show")) {
            functionService.select(request, response);
            request.getRequestDispatcher("../function.jsp").forward(request, response);
        } else if (ServletPath.equals("/function/deal")) {
            boolean flag = functionService.deal(request, response);
            request.setAttribute("flag", flag);
            response.sendRedirect(request.getContextPath()+"/function/show");
        } else if (ServletPath.equals("/function/order")) {
            functionService.order(request, response);
            request.getRequestDispatcher("../orders.jsp").forward(request, response);
        } else if (ServletPath.equals("/function/end")) {
            functionService.end(request, response);
            response.sendRedirect(request.getContextPath()+"/function/order");
        }
    }
}

package com.bathroom.web.action;

import com.bathroom.service.AdminService;
import com.bathroom.service.Impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//处理管理员的业务
@WebServlet({"/admin/add","/admin/delete","/admin/detail","/admin/update","/admin/modify"})
public class AdminServlet extends HttpServlet {
    private AdminService adminService = new AdminServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ServletPath = request.getServletPath();
        if (ServletPath.equals("/admin/add")) {
            int flag = adminService.add(request, response);
            if (flag == 1) {
                //成功跳转查看列表
                response.sendRedirect(request.getContextPath()+"/admin/detail");
            }else{
                response.sendRedirect(request.getContextPath()+"/error.jsp");
            }
        } else if (ServletPath.equals("/admin/delete")) {
            int flag = adminService.delete(request, response);
            if (flag == 1) {
                response.sendRedirect(request.getContextPath()+"/admin/detail");
            }else {
                response.sendRedirect(request.getContextPath()+"/error.jsp");
            }
        } else if (ServletPath.equals("/admin/detail")) {
            adminService.detail(request, response);
        } else if (ServletPath.equals("/admin/update")) {
            adminService.update(request, response);
        } else if (ServletPath.equals("/admin/modify")) {
            int flag = adminService.modify(request, response);
            if (flag == 1) {
                response.sendRedirect(request.getContextPath()+"/admin/detail");
            }else {
                response.sendRedirect(request.getContextPath()+"/error.jsp");
            }
        }
    }
}

package com.bathroom.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter("/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String servletPath = request.getServletPath();
        HttpSession session = request.getSession();
        //在index或者要去登录或者已经登录的用户不能拦截
        if (servletPath.equals("/index.jsp")||servletPath.equals("/user/login")||
        servletPath.equals("/css/style.css")||servletPath.equals("/welcome")||servletPath.equals("/user/exit")||
        session!=null&&session.getAttribute("user")!=null ){
            //程序继续走
            filterChain.doFilter(request, response);
        }else{
            response.sendRedirect(request.getContextPath());
        }
    }
}

package com.bathroom.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface OrderService {
    int add(HttpServletRequest request, HttpServletResponse response);
    int delete(HttpServletRequest request, HttpServletResponse response);
    void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}

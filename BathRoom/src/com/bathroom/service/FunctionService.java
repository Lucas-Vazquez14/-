package com.bathroom.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface FunctionService {
    void select(HttpServletRequest request, HttpServletResponse response);
    boolean deal(HttpServletRequest request, HttpServletResponse response);
    void order(HttpServletRequest request, HttpServletResponse response);
    void end(HttpServletRequest request, HttpServletResponse response);
}

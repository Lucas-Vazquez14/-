package com.bathroom.service;

import com.bathroom.exception.AppException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface UserService {
    int login(HttpServletRequest request, HttpServletResponse response) throws AppException;
    void exit(HttpServletRequest request, HttpServletResponse response) throws AppException, IOException;
}

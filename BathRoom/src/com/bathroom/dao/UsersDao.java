package com.bathroom.dao;

import com.bathroom.bean.Users;

import java.util.List;

public interface UsersDao {
    int addUsers(Users users);
    int deleteByUsername(String username);
    int updateUsers(Users users);
    Users selectByUsername(String username);
    List<Users> selectAllUsers();
}

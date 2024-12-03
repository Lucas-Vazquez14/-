package com.bathroom.dao;

import com.bathroom.bean.Bathrooms;
import com.bathroom.bean.Users;
import com.bathroom.bean.reservations;

import java.util.List;

public interface ReservationsDao {
    int addReservation(Users users, Bathrooms bathrooms);
    int deleteReservation(Users users, Bathrooms bathrooms);
    String selectByBathroomId(Long id);
    long selectByUserName(String username);
    List<reservations> selectAllReservations();
}

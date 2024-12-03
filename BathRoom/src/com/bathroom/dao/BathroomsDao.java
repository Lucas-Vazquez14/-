package com.bathroom.dao;

import com.bathroom.bean.Bathrooms;

import java.util.List;

public interface BathroomsDao {
    int addBathrooms(Bathrooms bathrooms);
    int deleteById(long id);
    int updateBathrooms(Bathrooms bathrooms);
    boolean checkById(long id);
    List<Bathrooms> getAllBathrooms();
}

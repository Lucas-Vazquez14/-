package com.bathroom.dao.impl;

import com.bathroom.bean.Bathrooms;
import com.bathroom.dao.BathroomsDao;
import com.bathroom.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BathroomsDaoImpl implements BathroomsDao {
    @Override
    public int addBathrooms(Bathrooms bathrooms) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "insert into bathrooms(status) values(?)";
            ps = conn.prepareStatement(sql);
            ps.setBoolean(1, bathrooms.isStatus());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn,ps,null);
        }
        return count;
    }

    @Override
    public int deleteById(long id) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "delete from bathrooms where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn,ps,null);
        }
        return count;
    }

    @Override
    public List<Bathrooms> getAllBathrooms() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Bathrooms> list = new ArrayList<Bathrooms>();
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from bathrooms";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                boolean status = rs.getBoolean("status");
                Bathrooms bathrooms = new Bathrooms(id, status);
                list.add(bathrooms);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn,ps,rs);
        }
        return list;
    }

    @Override
    public int updateBathrooms(Bathrooms bathrooms) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "update bathrooms set status = ? where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setBoolean(1, bathrooms.isStatus());
            ps.setLong(2, bathrooms.getId());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn,ps,null);
        }
        return count;
    }

    @Override
    public boolean checkById(long id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean status = false;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from bathrooms where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                status = rs.getBoolean("status");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn,ps,rs);
        }
        return status;
    }
}

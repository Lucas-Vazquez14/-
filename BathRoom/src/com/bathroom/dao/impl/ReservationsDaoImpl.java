package com.bathroom.dao.impl;

import com.bathroom.bean.Bathrooms;
import com.bathroom.bean.Users;
import com.bathroom.bean.reservations;
import com.bathroom.dao.ReservationsDao;
import com.bathroom.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReservationsDaoImpl implements ReservationsDao {
    @Override
    public int addReservation(Users users, Bathrooms bathrooms) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "insert into reservations(user_name,bathroom_id) values(?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,users.getName());
            ps.setLong(2,bathrooms.getId());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, null);
        }
        return count;
    }

    @Override
    public int deleteReservation(Users users, Bathrooms bathrooms) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "delete from reservations where user_name=? and bathroom_id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,users.getName());
            ps.setLong(2,bathrooms.getId());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, null);
        }
        return count;
    }

    @Override
    public String selectByBathroomId(Long id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String result = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from reservations where bathroom_id=?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1,id);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getString("user_name");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        return result;
    }

    @Override
    public long selectByUserName(String username) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        long result = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from reservations where user_name=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getLong("bathroom_id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        return result;
    }

    @Override
    public List<reservations> selectAllReservations() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<reservations> list = new ArrayList<reservations>();
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from reservations";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String user_name = rs.getString("user_name");
                long bathroom_id = rs.getLong("bathroom_id");
                long id = rs.getLong("id");
                list.add(new reservations(id,user_name,bathroom_id));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }
        return list;
    }
}

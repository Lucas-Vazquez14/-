package com.bathroom.dao.impl;

import com.bathroom.bean.Users;
import com.bathroom.dao.UsersDao;
import com.bathroom.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoImpl implements UsersDao {
    @Override
    public int deleteByUsername(String username) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "delete from users where name = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            count = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn, ps, null);
        }
        return count;
    }

    @Override
    public int addUsers(Users users) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            String sql="insert into users(name,password,num) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, users.getName());
            ps.setString(2, users.getPassword());
            ps.setInt(3, users.getNum());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn,ps,null);
        }
        return count;
    }

    @Override
    public int updateUsers(Users users) {
        Connection conn = null;
        PreparedStatement ps = null;
        int count = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "update users set name=?,password=?,num=? where name = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, users.getName());
            ps.setString(2, users.getPassword());
            ps.setInt(3, users.getNum());
            ps.setString(4, users.getName());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn,ps,null);
        }
        return count;
    }

    @Override
    public Users selectByUsername(String username) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Users users = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from users where name = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {                
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                int num = rs.getInt("num");
                users = new Users(id, name, password, num);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn,ps,rs);
        }
        return users;
    }

    @Override
    public List<Users> selectAllUsers() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Users> usersList = new ArrayList<Users>();
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from users";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String password = rs.getString("password");
                int num = rs.getInt("num");
                usersList.add(new Users(id, name, password, num));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBUtil.close(conn,ps,rs);
        }
        return usersList;
    }
}

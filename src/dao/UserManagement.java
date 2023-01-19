/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import config.Config;
import config.Close;
import entity.User;
import unti.Security;

/**
 *
 * @author DELL
 */
public class UserManagement {

    private Connection conn = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;

    public static List<User> getUserList() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<User> usersList = new ArrayList<>();

        String sql = "SELECT*FROM user";
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", Config.USERNAME, Config.PASSWORD);
            preparedStatement = conn.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User std = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("dob"),
                        rs.getString("phone"),
                        rs.getString("gender"),                      
                        rs.getString("password"),
                        rs.getString("address"),
                        rs.getString("position"),
                        rs.getString("salary"),
                        rs.getString("created_at"),
                        rs.getString("updated_at"),
                        rs.getInt("role_id")
                );

                usersList.add(std);
            }
            
        } catch (SQLException e) {
        } finally {
            Close.closeResultSet(rs);
            Close.closePreparedStatement(preparedStatement);

        }
        return usersList;

    }

    public static User getEmail(String email) {
        User users = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String sql = "SELECT* FROM user where email = ?";
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", Config.USERNAME, Config.PASSWORD);
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                users = new User(
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("gender"),
                        rs.getString("dob"),
                        rs.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.closeConnection(conn);
            Close.closePreparedStatement(preparedStatement);
            Close.closeResultSet(rs);

        }
        return users;
    }

    public static User getLogin(String email, String password) {
        User users = null;
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String sql = "SELECT email,password FROM user where email = ? and password =?";
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", Config.USERNAME, Config.PASSWORD);
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                
                users = new User(
                        
                        rs.getString("email"),
                        
                        rs.getString("password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.closeConnection(conn);
            Close.closePreparedStatement(preparedStatement);

        }
        return users;

    }

    public boolean add(User std) {
        String mahoa = Security.enCryption(std.getPassword());
        boolean flag = false;
        
        String sql = "INSERT INTO user(id, name, email,dob,phone, gender,password ) "
                + "VALUES(?,?,?,?,?,?,?)";
        try {

                        
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", Config.USERNAME, Config.PASSWORD);
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, std.getId());
            preparedStatement.setString(2, std.getName());
            preparedStatement.setString(3, std.getEmail());
            preparedStatement.setString(4, std.getDob());
            preparedStatement.setString(5, std.getPhone());
            preparedStatement.setString(6, std.getGender());
            
            preparedStatement.setString(7, mahoa);
//            preparedStatement.setString(7, std.getAddress());
//            preparedStatement.setString(9, std.getPosition());
//            preparedStatement.setString(10, std.getSalary());

            if (preparedStatement.executeUpdate() > 0) {
                System.out.println("aaaa");
                flag = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.closeConnection(conn);
            Close.closePreparedStatement(preparedStatement);

        }
        return false;

    }
    public static void addStaff(User std){
        
    }

    public static void update(User std) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", Config.USERNAME, Config.PASSWORD);
            String sql = "UPDATE user set name =?, email =?, dob =?,phone =?, gender =?, "
                + "address =?,position =?,salary =? where id = ?";
            preparedStatement = conn.prepareStatement(sql);

            
            preparedStatement.setString(1, std.getName());
            preparedStatement.setString(2, std.getEmail());
            preparedStatement.setString(3, std.getDob());
            preparedStatement.setString(4, std.getPhone());
            
            preparedStatement.setString(5, std.getGender());
//            preparedStatement.setString(6, std.getPassword());
            preparedStatement.setString(6, std.getAddress());
            preparedStatement.setString(7, std.getPosition());
            preparedStatement.setString(8, std.getSalary());
            preparedStatement.setInt(9, std.getId());
//            preparedStatement.setString(11, std.getCreate_at());
//            preparedStatement.setString(12, std.getUpdate_at());
//            preparedStatement.setInt(13, std.getRole_id());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
           e.printStackTrace();
        } finally {
            Close.closeConnection(conn);
            Close.closePreparedStatement(preparedStatement);

        }
        

    }

    public static void delete(int id) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", Config.USERNAME, Config.PASSWORD);
            String sql = "DELETE from user where id= ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.closeConnection(conn);
            Close.closePreparedStatement(preparedStatement);
            Close.closeResultSet(rs);
        }
        

    }
    public static List<User> loadDataUser(int page){
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        int before = page * 10 - 10;
        int after = page * 10 + 1;
        List<User> usersList = new ArrayList<>();
        try {
            String query = "select * from user where id > ? and id < ?";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", Config.USERNAME, Config.PASSWORD);
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, before);
            preparedStatement.setInt(2, after);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                
                User std = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("gender"),
                        rs.getString("dob"),
                        rs.getString("password"),
                        rs.getString("address"),
                        rs.getString("position"),
                        rs.getString("salary"),
                        rs.getString("created_at"),
                        rs.getString("updated_at"),
                        rs.getInt("role_id")
                );

                usersList.add(std);
                
                
                
            }
//            RoomList.forEach(e -> {
//                System.out.println(e);
//            });
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.closeConnection(conn);
            Close.closeResultSet(rs);
            Close.closePreparedStatement(preparedStatement);

        }
        return usersList;
        
    }

    

}

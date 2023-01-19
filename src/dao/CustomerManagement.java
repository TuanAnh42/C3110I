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
import entity.Customer;


/**
 *
 * @author DELL
 */
public class CustomerManagement {
    public static List<Customer> getCustomerList() {
        Connection conn = null ;
        PreparedStatement preparedStatement = null ;
        ResultSet rs = null ;
        List<Customer> customerList = new ArrayList<>();

        String sql = "SELECT*FROM customer";
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", Config.USERNAME, Config.PASSWORD);
            preparedStatement = conn.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Customer customerMn = new Customer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("birthday"),
                        rs.getString("gender"),
                        rs.getString("address"),
                        rs.getInt("staff_id")
                );

                customerList.add(customerMn);
            }

        } catch (SQLException e) {
        } finally {
            Close.closeConnection(conn);
            Close.closeResultSet(rs);
            Close.closePreparedStatement(preparedStatement);

        }
        return customerList;

    }

    public static void add(Customer customerMn) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        boolean flag = false;
        String sql = "INSERT INTO customer(id, name, phone,birthday, gender,address)VALUES(?,?,?,?,?,?)";
        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", Config.USERNAME, Config.PASSWORD);
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, customerMn.getId());
            preparedStatement.setString(2, customerMn.getName());
            preparedStatement.setString(3, customerMn.getPhone());
            preparedStatement.setString(4, customerMn.getBirthday());
            preparedStatement.setString(5, customerMn.getGender());
            preparedStatement.setString(6, customerMn.getAddress());
//            preparedStatement.setInt(7, customerMn.getStaff_id());

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
        

    }

    public static void update(Customer customerMn) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", Config.USERNAME, Config.PASSWORD);
            String sql = "UPDATE customer set id =?, name = ? ,phone = ?,birthday = ? ,gender = ? ,"
                    + " address=?  where id = ?";
            preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, customerMn.getId());
            preparedStatement.setString(2, customerMn.getName());
            preparedStatement.setString(3, customerMn.getPhone());
            preparedStatement.setString(4, customerMn.getBirthday());
            preparedStatement.setString(5, customerMn.getGender());
            preparedStatement.setString(6, customerMn.getAddress());
            
            preparedStatement.setInt(7, customerMn.getId());
            preparedStatement.execute();
            System.out.println(preparedStatement.toString());

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
            String sql = "DELETE from customer where id= ?";
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
     public static List<Customer> loadDataCus(int page){
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        int before = page * 10 - 10;
        int after = page * 10 + 1;
        List<Customer> customerList = new ArrayList<>();
        try {
            String query = "select * from customer where id > ? and id < ?";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", Config.USERNAME, Config.PASSWORD);
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, before);
            preparedStatement.setInt(2, after);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                
                Customer customerMn = new Customer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getString("birthday"),
                        rs.getString("gender"),
                        rs.getString("address"),
                        rs.getInt("staff_id")
                );

                customerList.add(customerMn);
                
                
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
        return customerList;
        
    }

}

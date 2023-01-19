/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import config.Config;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author AD
 */
public class test {
public static  long count() throws SQLException{
            
        
        Connection conn = null ;
        PreparedStatement preparedStatement = null ;
        ResultSet rs = null ;
        try {
            long count = 0 ;
            String sql= "select count(*) from room";
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", Config.USERNAME, Config.PASSWORD);
            preparedStatement = conn.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
               count = (int) rs.getLong(1);
            }
            System.out.println(count);
            return count;
            
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    return 0;
}
    public static void main(String[] args) throws SQLException {
        test.count();
        
    }
}

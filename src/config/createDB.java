/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



/**
 *
 * @author DELL
 */
public class createDB implements Config{
    public static void main(String[] agrs)  {     
        try (Connection conn = DriverManager.getConnection(Config.DB_URL,Config.USERNAME,Config.PASSWORD )) {
            System.out.println("Connecting to database...");
            System.out.println("Creating database...");
            
            PreparedStatement stmt = conn.prepareStatement(DB_URL);

            String sql = "CREATE DATABASE IF NOT EXISTS hotel_management";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
}


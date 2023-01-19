/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class createTB implements Config {

    static final String DB_URL = "jdbc:mysql://localhost:3306/hotel_management?serverTimezone=UTC&useSSL=false";

    public static void main(String[] args) throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL, Config.USERNAME, Config.PASSWORD)) {
            System.out.println("Connecting to database...");
            Statement s = conn.createStatement();
            
            String user = "CREATE TABLE IF NOT EXISTS user "
                    + "(id INTEGER NOT NULL AUTO_INCREMENT,"
                    + " name VARCHAR(50),"
                    + " email VARCHAR(50),"
                    + " dob DATE,"
                    + " phone VARCHAR(20),"
                    + " gender VARCHAR(10),"
                    + " password VARCHAR(35),"
                    + " address VARCHAR(60),"
                    + " position VARCHAR(30),"
                    + " salary VARCHAR(30),"
                    
                    + " created_at DATETIME,"
                    + " updated_at DATETIME,"
                    + " role_id INTEGER,"
                    + " PRIMARY KEY ( id ))";

            String customer = "CREATE TABLE IF NOT EXISTS customer "
                    + "(id INTEGER NOT NULL AUTO_INCREMENT,"
                    + " name VARCHAR(50),"    
                    + " phone VARCHAR(20),"
                    + " birthday DATE,"
                    + " gender VARCHAR(20),"   
                    + " address VARCHAR(50),"
                    + " staff_id INTEGER,"
                    + " PRIMARY KEY ( id ))";


            String room = "CREATE TABLE IF NOT EXISTS room "
                    + "(id INTEGER NOT NULL AUTO_INCREMENT,"
                    + " room_number INTEGER, "                  
                    + " room_type VARCHAR(20) , "
                    + " floor VARCHAR(20), "
                    + " status BOOLEAN, "
                    + " price FLOAT, "
                    + " image VARCHAR(200), "
                    + " PRIMARY KEY ( id ))";

            String book = "CREATE TABLE IF NOT EXISTS book "
                    + "(id INTEGER NOT NULL AUTO_INCREMENT,"
                    + " user_id INTEGER, "                  
                    + " customer_id INTEGER, "
                    + " status BOOLEAN,"
                   
                    + " PRIMARY KEY ( id ))";

            
        

            String role = "CREATE TABLE IF NOT EXISTS role "
                    + "(id INTEGER NOT NULL AUTO_INCREMENT,"
                    + " role_name VARCHAR(50),"
                    + " PRIMARY KEY ( id ))";
            
            s.executeUpdate(user);
            s.executeUpdate(customer);
            s.executeUpdate(room);
            s.executeUpdate(book);
            
            s.executeUpdate(role);
            
            System.out.println("Table created successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

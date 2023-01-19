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
import entity.Room;
import java.util.Vector;


/**
 *
 * @author DELL
 */
public class RoomManagement {

    public static List<Room> getRoomList() {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        List<Room> RoomList = new ArrayList<>();
        String sql = "SELECT*FROM room";
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", Config.USERNAME, Config.PASSWORD);
            preparedStatement = conn.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Room rm = new Room(
                        rs.getInt("id"),
                        rs.getString("room_number"),
                        rs.getString("room_type"),
                        rs.getString("floor"),
                        rs.getBoolean("status"),
                        rs.getFloat("price"),
                        rs.getString("image")
                );

                RoomList.add(rm);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.closeConnection(conn);
            Close.closeResultSet(rs);
            Close.closePreparedStatement(preparedStatement);

        }
        return RoomList;

    }


    public static void add(Room rm) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        boolean flag = false;
        String sql = "INSERT INTO room(id, room_number, room_type,floor,status, price,image) "
                + "VALUES(?,?,?,?,?,?,?)";
        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", Config.USERNAME, Config.PASSWORD);
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, rm.getId());
            preparedStatement.setString(2, rm.getRoom_number());
            preparedStatement.setString(3, rm.getRoom_type());
            preparedStatement.setString(4, rm.getFloor());
            preparedStatement.setBoolean(5, true);
            preparedStatement.setFloat(6, rm.getPrice());
            
            preparedStatement.setString(7, rm.getImage());
//            int row = preparedStatement.executeUpdate();
//            if (row > 0) {
//                System.out.println("A contact was inserted with photo image.");
//            }
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
    public int count(){
        Connection conn = null ;
        PreparedStatement preparedStatement = null ;
        ResultSet rs = null ;
        try {
            int count = 0;
            String sql= "select*from room";
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", Config.USERNAME, Config.PASSWORD);
            preparedStatement = conn.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                count++;
            }
            
//            System.out.println(count);
            return count;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
        
    }
        public static List<Room> getRoomByCondition(int offset) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        List<Room> RoomList = new ArrayList<>();
        String sql = "SELECT*FROM room limit 5 offset " + offset;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", Config.USERNAME, Config.PASSWORD);
            preparedStatement = conn.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {

                Room rm = new Room();

                rm.setId(rs.getInt("Id"));
                rm.setRoom_number(rs.getString("Room_number"));
                rm.setRoom_type(rs.getString("Room_type"));
                rm.setFloor(rs.getString("Floor"));
                rm.setStatus(rs.getBoolean("Status"));
                rm.setPrice(rs.getFloat("Price"));
                rm.setImage(rs.getString("Image"));
                
                RoomList.add(rm);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Close.closeConnection(conn);
            Close.closeResultSet(rs);
            Close.closePreparedStatement(preparedStatement);

        }
        return RoomList;

    }

    public static void update(Room rm) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        String sql = "UPDATE room set room_number =?, room_type =?,floor=?, status =?, price =?, image =? "
                + " where id = ?";

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", Config.USERNAME, Config.PASSWORD);
            preparedStatement = conn.prepareStatement(sql);

//            preparedStatement.setInt(1, rm.getId());
            preparedStatement.setString(1, rm.getRoom_number());
            preparedStatement.setString(2, rm.getRoom_type());
            preparedStatement.setString(3, rm.getFloor());
            preparedStatement.setBoolean(4, rm.getStatus());
            preparedStatement.setFloat(5, rm.getPrice());
            preparedStatement.setString(6, rm.getImage());
            preparedStatement.setInt(7, rm.getId());
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
            String sql = "DELETE from room where id= ?";
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
    public static List<Room> loadDataRoom(int page){
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        int before = page * 10 - 10;
        int after = page * 10 + 1;
        List<Room> RoomList = new ArrayList<>();
        try {
            String query = "select * from room where id > ? and id < ?";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_management", Config.USERNAME, Config.PASSWORD);
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, before);
            preparedStatement.setInt(2, after);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                
                Room rm = new Room(
                        rs.getInt("id"),
                        rs.getString("room_number"),
                        rs.getString("room_type"),
                        rs.getString("floor"),
                        rs.getBoolean("status"),
                        rs.getFloat("price"),
                        rs.getString("image")
                );
                RoomList.add(rm);
                
                
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
        return RoomList;
        
    }

}

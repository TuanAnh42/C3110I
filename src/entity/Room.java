/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author DELL
 */
public class Room {
    private int id;
    private String room_number;
    private String room_type;
    private String floor;
    private boolean status;
    private float price;
    private String image;

    public Room() {
    }

    public Room(String room_number) {
        this.room_number = room_number;
    }
    

    public Room(int id, String room_number, String room_type, String floor, boolean status, float price, String image) {
        this.id = id;
        this.room_number = room_number;
        this.room_type = room_type;
        this.floor = floor;
        this.status = status;
        this.price = price;
        this.image = image;
    }

    public Room(String room_number, String room_type, String floor, boolean status, float price, String image) {
        this.room_number = room_number;
        this.room_type = room_type;
        this.floor = floor;
        this.status = status;
        this.price = price;
        this.image = image;
    }

    public Room(int id, String room_number, String room_type, String floor, float price, String image) {
        this.id = id;
        this.room_number = room_number;
        this.room_type = room_type;
        this.floor = floor;
        this.price = price;
        this.image = image;
    }

    public Room(String room_number, String room_type, String floor, float price, String image) {
        this.room_number = room_number;
        this.room_type = room_type;
        this.floor = floor;
        this.price = price;
        this.image = image;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoom_number() {
        return room_number;
    }

    public void setRoom_number(String room_number) {
        this.room_number = room_number;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Room{" + "id=" + id + ", room_number=" + room_number + ", room_type=" + room_type + ", Floor=" + floor + ", status=" + status + ", price=" + price + ", image=" + image + '}';
    }

//    public String getPrice(float parseFloat) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    
    
}

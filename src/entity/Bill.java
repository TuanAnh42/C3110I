/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author admin
 */
public class Bill {

    private int id;
    private int user_id;
    private int room_id;
    private float price;
    private String time_out;
    private String create_at;
    private String update_at;
   

    public Bill() {
    }

    public Bill(int id, int user_id, int room_id, float price, String time_out, String create_at, String update_at) {
        this.id = id;
        this.user_id = user_id;
        this.room_id = room_id;
        this.price = price;
        this.time_out = time_out;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public Bill(int user_id, int room_id, float price, String time_out, String create_at, String update_at) {
        this.user_id = user_id;
        this.room_id = room_id;
        this.price = price;
        this.time_out = time_out;
        this.create_at = create_at;
        this.update_at = update_at;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCheck_out() {
        return time_out;
    }

    public void setCheck_out(String time_out) {
        this.time_out = time_out;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", user_id=" + user_id + ", room_id=" + room_id + ", price=" + price + ", time_out=" + time_out + ", create_at=" + create_at + ", update_at=" + update_at + '}';
    }

    

    
    
}

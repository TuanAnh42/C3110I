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
public class Books {

    private int id;
    private int user_id;
    private int customer_id;
    private boolean status;

    public Books() {
    }

    public Books(int id, int user_id, int customer_id, boolean status) {
        this.id = id;
        this.user_id = user_id;
        this.customer_id = customer_id;
        this.status = status;
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

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Books{" + "id=" + id + ", user_id=" + user_id + ", customer_id=" + customer_id + ", status=" + status + '}';
    }

}

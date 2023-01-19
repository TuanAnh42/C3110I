/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author pc
 */
public class InvoiceManagement {
    private int id_invoice ;
    private int id_emp;
    private String customerName;
    private String days;
    private String time;
    private String id_room;
    private String price;

    public InvoiceManagement() {
    }

    public InvoiceManagement(int id_invoice, int id_emp, String customerName, String days, String time, String id_room, String price) {
        this.id_invoice = id_invoice;
        this.id_emp = id_emp;
        this.customerName = customerName;
        this.days = days;
        this.time = time;
        this.id_room = id_room;
        this.price = price;
    }

    public int getId_invoice() {
        return id_invoice;
    }

    public void setId_invoice(int id_invoice) {
        this.id_invoice = id_invoice;
    }

    public int getId_emp() {
        return id_emp;
    }

    public void setId_emp(int id_emp) {
        this.id_emp = id_emp;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getId_room() {
        return id_room;
    }

    public void setId_room(String id_room) {
        this.id_room = id_room;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "InvoiceManagement{" + "id_invoice=" + id_invoice + ", id_emp=" + id_emp + ", customerName=" + customerName + ", days=" + days + ", time=" + time + ", id_room=" + id_room + ", price=" + price + '}';
    }
    
    
}

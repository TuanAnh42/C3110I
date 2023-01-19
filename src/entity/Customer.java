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
 
public class Customer {
    private int id;
    private String name;
    private String phone;
    private String birthday;
    private String gender;
    private String address;
    private int staff_id ;

    public Customer() {
       
    }

    public Customer(int id, String name, String phone, String birthday, String gender, String address, int staff_id) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.birthday = birthday;
        this.gender = gender;
        this.address = address;
        this.staff_id = staff_id;
    }

    public Customer(String name, String phone, String birthday, String gender, String address) {
        this.name = name;
        this.phone = phone;
        this.birthday = birthday;
        this.gender = gender;
        this.address = address;
    }

    public Customer(int id, String name, String phone, String birthday, String gender, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.birthday = birthday;
        this.gender = gender;
        this.address = address;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }
    


    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", phone=" + phone + ", birthday=" + birthday + ", address=" + address + ", staff_id=" + staff_id + '}';
    }

    
    
    

}

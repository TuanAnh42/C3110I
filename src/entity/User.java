/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import dao.UserManagement;
import java.sql.Date;
import java.time.LocalDate;
import javax.swing.JTextField;

/**
 *
 * @author pc
 */
  
public class User {
    private int id;
    private String name;
    private String email;
    private String dob;
    private String phone;
    private String gender;
    
    private String password;   
    private String address;
    private String position;
    private String salary;
    private String create_at;
    private String update_at;
    private int role_id;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    

    public User(int id, String name, String email, String dob, String phone, String gender, String password, String address, String position, String salary, String create_at, String update_at, int role_id) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.phone = phone;
        this.gender = gender;
        this.password = password;
        this.address = address;
        this.position = position;
        this.salary = salary;
        this.create_at = create_at;
        this.update_at = update_at;
        this.role_id = role_id;
    }

    public User(String name, String email, String dob, String phone, String gender, String password, String address, String position, String salary, String create_at, String update_at, int role_id) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.phone = phone;
        this.gender = gender;
        this.password = password;
        this.address = address;
        this.position = position;
        this.salary = salary;
        this.create_at = create_at;
        this.update_at = update_at;
        this.role_id = role_id;
    }

   
    


    public User(String name, String email, String dob, String phone, String gender, String password) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.phone = phone;
        this.gender = gender;
        this.password = password;
    }

    public User(int id, String name, String email, String dob, String phone, String gender, String address, String position, String salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.phone = phone;
        this.gender = gender;
        this.address = address;
        this.position = position;
        this.salary = salary;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
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

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", phone=" + phone + ", gender=" + gender + ", password=" + password + ", address=" + address + ", position=" + position + ", salary=" + salary + ", create_at=" + create_at + ", update_at=" + update_at + ", role_id=" + role_id + '}';
    }

    
   
    
   
    

    

    
    
    
}

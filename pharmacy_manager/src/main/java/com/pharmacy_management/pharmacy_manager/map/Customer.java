package com.pharmacy_management.pharmacy_manager.map;

import com.pharmacy_management.pharmacy_manager.DBUtils.DB_DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Customer
{   private String id;
    private String firstName;
    private String lastName;
    private String gender;
    private String email;
    private String phoneNumber;
    private String address;
    private String zipCode;

    public Customer() {
    }

    public Customer(String id, String firstName, String lastName, String gender, String email, String phoneNumber, String address, String zipCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.zipCode = zipCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
    public ArrayList<Customer> customers() throws SQLException {
        ArrayList<Customer> customerArrayList=new ArrayList<>();
        String sql="select * from customer";
        ResultSet resultSet=new DB_DAO().dbUtils(sql);
        while (resultSet.next()){
            id =resultSet.getString("customer_id");
            firstName=resultSet.getString("first_name");
            lastName=resultSet.getString("last_name");
            gender=resultSet.getString("gender");
            email=resultSet.getString("email");
            phoneNumber=resultSet.getString("phone_number");
            address=resultSet.getString("address");
            zipCode=resultSet.getString("zip_code");
            Customer customer=new Customer(id,firstName,lastName,gender,email,phoneNumber,address,zipCode);
            customerArrayList.add(customer);
        }
        return customerArrayList;
    }
}

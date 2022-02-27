package com.pharmacy_management.pharmacy_manager.map;

import com.pharmacy_management.pharmacy_manager.DBUtils.DB_DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Store
{
  private String store_id;
  private String store_name;
  private String email;
  private String phone_number;
  private String address;
  private String zipCode;

  public Store() {
  }

  public Store(String store_id, String store_name, String email, String phone_number, String address, String zipCode) {
    this.store_id = store_id;
    this.store_name = store_name;
    this.email = email;
    this.phone_number = phone_number;
    this.address = address;
    this.zipCode = zipCode;
  }


  public String getStore_id() {
    return store_id;
  }

  public void setStore_id(String store_id) {
    this.store_id = store_id;
  }

  public String getStore_name() {
    return store_name;
  }

  public void setStore_name(String store_name) {
    this.store_name = store_name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone_number() {
    return phone_number;
  }

  public void setPhone_number(String phone_number) {
    this.phone_number = phone_number;
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
    return "Store{" +
            "store_id='" + store_id + '\'' +
            ", store_name='" + store_name + '\'' +
            ", email='" + email + '\'' +
            ", phone_number='" + phone_number + '\'' +
            ", address='" + address + '\'' +
            ", zipCode='" + zipCode + '\'' +
            '}';
  }

  public ArrayList<Store> stores() throws SQLException {
    ArrayList<Store> storeArrayList=new ArrayList<>();
    String sql="select * from store";
    ResultSet resultSet=new DB_DAO().dbUtils(sql);
    while (resultSet.next()){
      store_id =resultSet.getString("store_id");
      store_name=resultSet.getString("store_name");
      email=resultSet.getString("email");
      phone_number=resultSet.getString("phone_number");
      address=resultSet.getString("address");
      zipCode=resultSet.getString("zip_code");
      Store store=new Store(store_id,store_name,email,phone_number,address,zipCode);
      storeArrayList.add(store);
    }
    return storeArrayList;
  }
}

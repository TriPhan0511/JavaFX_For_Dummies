package com.pharmacy_management.pharmacy_manager.map;

import com.pharmacy_management.pharmacy_manager.DBUtils.DB_DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Supplier
{
  private String supplier_id;
  private String supplier_name;
  private String email;
  private String phone_number;
  private String address;
  private String zipCode;

  public Supplier() {
  }

  public Supplier(String supplier_id, String supplier_name, String email, String phone_number, String address, String zipCode) {
    this.supplier_id = supplier_id;
    this.supplier_name = supplier_name;
    this.email = email;
    this.phone_number = phone_number;
    this.address = address;
    this.zipCode = zipCode;
  }

  public String getSupplier_id() {
    return supplier_id;
  }

  public void setSupplier_id(String supplier_id) {
    this.supplier_id = supplier_id;
  }

  public String getSupplier_name() {
    return supplier_name;
  }

  public void setSupplier_name(String supplier_name) {
    this.supplier_name = supplier_name;
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
    return "Supplier{" +
            "supplier_id='" + supplier_id + '\'' +
            ", supplier_name='" + supplier_name + '\'' +
            ", email='" + email + '\'' +
            ", phone_number='" + phone_number + '\'' +
            ", address='" + address + '\'' +
            ", zipCode='" + zipCode + '\'' +
            '}';
  }
  public ArrayList<Supplier> suppliers() throws SQLException {
    ArrayList<Supplier> supplierArrayList=new ArrayList<>();
    String sql="select * from supplier";
    ResultSet resultSet=new DB_DAO().dbUtils(sql);
    while (resultSet.next()){
      supplier_id =resultSet.getString("supplier_id");
      supplier_name=resultSet.getString("supplier_name");
      email=resultSet.getString("email");
      phone_number=resultSet.getString("phone_number");
      address=resultSet.getString("address");
      zipCode=resultSet.getString("zip_code");
      Supplier supplier=new Supplier(supplier_id,supplier_name,email,phone_number,address,zipCode);
      supplierArrayList.add(supplier);
    }
    return supplierArrayList;
  }
}

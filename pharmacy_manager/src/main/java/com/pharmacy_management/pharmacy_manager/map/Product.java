package com.pharmacy_management.pharmacy_manager.map;
import com.pharmacy_management.pharmacy_manager.DBUtils.DB_DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Product
{
  private String product_id;
  private String product_name;
  private double price;
  private String expirationDate;
  private String unit;
  private String category;

  public Product() {
  }

  public Product(String product_id, String product_name, double price, String expirationDate, String unit, String category) {
    this.product_id = product_id;
    this.product_name = product_name;
    this.price = price;
    this.expirationDate = expirationDate;
    this.unit = unit;
    this.category = category;
  }

  public String getProduct_id() {
    return product_id;
  }

  public void setProduct_id(String product_id) {
    this.product_id = product_id;
  }

  public String getProduct_name() {
    return product_name;
  }

  public void setProduct_name(String product_name) {
    this.product_name = product_name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(String expirationDate) {
    this.expirationDate = expirationDate;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  @Override
  public String toString() {
    return "Product{" +
            "product_id='" + product_id + '\'' +
            ", product_name='" + product_name + '\'' +
            ", price=" + price +
            ", expirationDate='" + expirationDate + '\'' +
            ", unit='" + unit + '\'' +
            ", category='" + category + '\'' +
            '}';
  }

  public ArrayList<Product> products() throws SQLException {
    ArrayList<Product> productArrayList=new ArrayList<>();
    String sql="select * from product";
    ResultSet resultSet=new DB_DAO().dbUtils(sql);
    while (resultSet.next()){
      product_id =resultSet.getString("product_id");
      product_name=resultSet.getString("product_name");
      price=resultSet.getDouble("price");
      expirationDate=resultSet.getString("expiration_date");
      unit=resultSet.getString("unit");
      category=resultSet.getString("category_id");
      Product product=new Product(product_id,product_name,price,expirationDate,unit,category);
      productArrayList.add(product);
    }
    return productArrayList;
  }
}

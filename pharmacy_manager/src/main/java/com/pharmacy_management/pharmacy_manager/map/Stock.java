package com.pharmacy_management.pharmacy_manager.map;

import com.pharmacy_management.pharmacy_manager.DBUtils.DB_DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Stock
{
  private String store_id;
  private String product_id;
  private int quantity;

  public Stock() {
  }

  public Stock(String store_id, String product_id, int quantity) {
    this.store_id = store_id;
    this.product_id = product_id;
    this.quantity = quantity;
  }

  public String getStore_id() {
    return store_id;
  }

  public void setStore_id(String store_id) {
    this.store_id = store_id;
  }

  public String getProduct_id() {
    return product_id;
  }

  public void setProduct_id(String product_id) {
    this.product_id = product_id;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return "Stock{" +
            "store_id='" + store_id + '\'' +
            ", product_id='" + product_id + '\'' +
            ", quantity=" + quantity +
            '}';
  }


  public ArrayList<Stock> stocks() throws SQLException {
    ArrayList<Stock> stockArrayList=new ArrayList<>();
    String sql="select * from stock";
    ResultSet resultSet=new DB_DAO().dbUtils(sql);
    while (resultSet.next()){
      store_id =resultSet.getString("store_id");
      product_id=resultSet.getString("product_id");
      quantity=resultSet.getInt("quantity");
      Stock stock=new Stock(store_id,product_id,quantity);
      stockArrayList.add(stock);
    }
    return stockArrayList;
  }
}

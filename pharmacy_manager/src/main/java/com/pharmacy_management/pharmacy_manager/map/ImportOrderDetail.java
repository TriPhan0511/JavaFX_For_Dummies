package com.pharmacy_management.pharmacy_manager.map;

import com.pharmacy_management.pharmacy_manager.DBUtils.DB_DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ImportOrderDetail
{
  private String importOrder_id;
  private String product_id;
  private int quantity;
  private double import_price;

  public ImportOrderDetail() {
  }

  public ImportOrderDetail(String importOrder_id, String product_id, int quantity, double import_price) {
    this.importOrder_id = importOrder_id;
    this.product_id = product_id;
    this.quantity = quantity;
    this.import_price = import_price;
  }

  public String getImportOrder_id() {
    return importOrder_id;
  }

  public void setImportOrder_id(String importOrder_id) {
    this.importOrder_id = importOrder_id;
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

  public double getImport_price() {
    return import_price;
  }

  public void setImport_price(double import_price) {
    this.import_price = import_price;
  }

  @Override
  public String toString() {
    return "ImportOrderDetail{" +
            "importOrder_id='" + importOrder_id + '\'' +
            ", product_id='" + product_id + '\'' +
            ", quantity=" + quantity +
            ", import_price=" + import_price +
            '}';
  }


  public ArrayList<ImportOrderDetail> importOrderDetails() throws SQLException {
    ArrayList<ImportOrderDetail> importOrderDetailArrayList=new ArrayList<>();
    String sql="select * from import_order_detail";
    ResultSet resultSet=new DB_DAO().dbUtils(sql);
    while (resultSet.next()){
      importOrder_id =resultSet.getString("importOrder_id");
      product_id=resultSet.getString("product_id");
      quantity=resultSet.getInt("quantity");
      import_price=resultSet.getDouble("import_price");
      ImportOrderDetail importOrderDetail=new ImportOrderDetail(importOrder_id,product_id,quantity,import_price);
      importOrderDetailArrayList.add(importOrderDetail);
    }
    return importOrderDetailArrayList;
  }
}

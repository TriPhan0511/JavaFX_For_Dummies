package com.pharmacy_management.pharmacy_manager.map;

import com.pharmacy_management.pharmacy_manager.DBUtils.DB_DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ImportOrder
{
  private String importOrder_id;
  private String supplier_id;
  private String store_id;
  private String employee_id;
  private String create_date;

  public ImportOrder() {
  }

  public ImportOrder(String importOrder_id, String supplier_id, String store_id, String employee_id, String create_date) {
    this.importOrder_id = importOrder_id;
    this.supplier_id = supplier_id;
    this.store_id = store_id;
    this.employee_id = employee_id;
    this.create_date = create_date;
  }

  public String getImportOrder_id() {
    return importOrder_id;
  }

  public void setImportOrder_id(String importOrder_id) {
    this.importOrder_id = importOrder_id;
  }

  public String getSupplier_id() {
    return supplier_id;
  }

  public void setSupplier_id(String supplier_id) {
    this.supplier_id = supplier_id;
  }

  public String getStore_id() {
    return store_id;
  }

  public void setStore_id(String store_id) {
    this.store_id = store_id;
  }

  public String getEmployee_id() {
    return employee_id;
  }

  public void setEmployee_id(String employee_id) {
    this.employee_id = employee_id;
  }

  public String getCreate_date() {
    return create_date;
  }

  public void setCreate_date(String create_date) {
    this.create_date = create_date;
  }

  @Override
  public String toString() {
    return "ImportOrder{" +
            "importOrder_id='" + importOrder_id + '\'' +
            ", supplier_id='" + supplier_id + '\'' +
            ", store_id='" + store_id + '\'' +
            ", employee_id='" + employee_id + '\'' +
            ", create_date='" + create_date + '\'' +
            '}';
  }
  public ArrayList<ImportOrder> importOrders() throws SQLException {
    ArrayList<ImportOrder> importOrderArrayList= new ArrayList<>();
    String sql="select * from import_order";
    ResultSet resultSet=new DB_DAO().dbUtils(sql);
    while (resultSet.next()){
      importOrder_id =resultSet.getString("importOrder_id");
      supplier_id=resultSet.getString("supplier_id");
      store_id=resultSet.getString("store_id");
      employee_id=resultSet.getString("employee_id");
      create_date=resultSet.getString("create_date");
      ImportOrder importOrder=new ImportOrder(importOrder_id,supplier_id,store_id,employee_id,create_date);
      importOrderArrayList.add(importOrder);
    }
    return importOrderArrayList;
  }
}

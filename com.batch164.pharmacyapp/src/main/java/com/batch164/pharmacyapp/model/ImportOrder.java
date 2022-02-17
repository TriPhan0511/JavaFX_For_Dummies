package com.batch164.pharmacyapp.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class ImportOrder
{
  private String importOrderID;
  private Supplier supplier;
  private Store store;
  private Employee employee;
  private double total;
  private LocalDate createdAt = LocalDate.now();
  private ArrayList<ImportOrderDetail> listOfImportOrderDetails = new ArrayList<>();

  public ImportOrder()
  {
  }

  public ImportOrder(String importOrderID, Supplier supplier, Store store, Employee employee)
  {
    this.importOrderID = importOrderID;
    this.supplier = supplier;
    this.store = store;
    this.employee = employee;
  }

  public String getImportOrderID()
  {
    return importOrderID;
  }

  public void setImportOrderID(String importOrderID)
  {
    this.importOrderID = importOrderID;
  }

  public Supplier getSupplier()
  {
    return supplier;
  }

  public void setSupplier(Supplier supplier)
  {
    this.supplier = supplier;
  }

  public Store getStore()
  {
    return store;
  }

  public void setStore(Store store)
  {
    this.store = store;
  }

  public Employee getEmployee()
  {
    return employee;
  }

  public void setEmployee(Employee employee)
  {
    this.employee = employee;
  }

  public double getTotal()
  {
    return total;
  }

  public LocalDate getCreatedAt()
  {
    return createdAt;
  }

  public ArrayList<ImportOrderDetail> getListOfImportOrderDetails()
  {
    return listOfImportOrderDetails;
  }

}

package com.batch164.pharmacyapp.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class SalesOrder
{
  private String salesOrderID;
  private Customer customer;
  private Store store;
  private Employee employee;
  private double total;
  private LocalDate createdAt = LocalDate.now();
  private ArrayList<SalesOrderDetail> listOfSalesOrderDetails = new ArrayList<>();

  public SalesOrder()
  {
  }

  public SalesOrder(String salesOrderID, Customer customer, Store store, Employee employee)
  {
    this.salesOrderID = salesOrderID;
    this.customer = customer;
    this.store = store;
    this.employee = employee;
  }

  public String getSalesOrderID()
  {
    return salesOrderID;
  }

  public void setSalesOrderID(String salesOrderID)
  {
    this.salesOrderID = salesOrderID;
  }

  public Customer getCustomer()
  {
    return customer;
  }

  public void setCustomer(Customer customer)
  {
    this.customer = customer;
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

  public ArrayList<SalesOrderDetail> getListOfSalesOrderDetails()
  {
    return listOfSalesOrderDetails;
  }
}

package com.batch164.pharmacyapp.model;

public class Supplier
{
  private String supplierID;
  private String supplierName;
  private String email;
  private String phoneNumber;
  private String address;
  private String zipCode;

  public Supplier() {}

  public Supplier(String supplierID, String supplierName, String email, String phoneNumber, String address, String zipCode)
  {
    this.supplierID = supplierID;
    this.supplierName = supplierName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.zipCode = zipCode;
  }

  public String getSupplierID()
  {
    return supplierID;
  }

  public void setSupplierID(String supplierID)
  {
    this.supplierID = supplierID;
  }

  public String getSupplierName()
  {
    return supplierName;
  }

  public void setSupplierName(String supplierName)
  {
    this.supplierName = supplierName;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }

  public String getAddress()
  {
    return address;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public String getZipCode()
  {
    return zipCode;
  }

  public void setZipCode(String zipCode)
  {
    this.zipCode = zipCode;
  }
}

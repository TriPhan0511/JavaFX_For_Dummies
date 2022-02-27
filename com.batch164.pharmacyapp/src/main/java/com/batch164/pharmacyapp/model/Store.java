package com.batch164.pharmacyapp.model;

public class Store
{
  private String storeID;
  private String storeName;
  private String email;
  private String phoneNumber;
  private String address;
  private String zipCode;

  public Store()
  {
  }

  public Store(String storeID, String storeName, String email, String phoneNumber, String address, String zipCode)
  {
    this.storeID = storeID;
    this.storeName = storeName;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.zipCode = zipCode;
  }

  public String getStoreID()
  {
    return storeID;
  }

  public String getStoreName()
  {
    return storeName;
  }

  public String getEmail()
  {
    return email;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public String getAddress()
  {
    return address;
  }

  public String getZipCode()
  {
    return zipCode;
  }

  public void setStoreID(String storeID)
  {
    this.storeID = storeID;
  }

  public void setStoreName(String storeName)
  {
    this.storeName = storeName;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public void setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public void setZipCode(String zipCode)
  {
    this.zipCode = zipCode;
  }

  @Override
  public String toString()
  {
    StringBuilder builder = new StringBuilder();
    builder.append(storeID);
    return builder.toString();
  }
}

















package com.batch164.pharmacyapp.model;

public class Customer extends Person
{
  private String zipCode;

  public Customer()
  {
  }

  public Customer(String id, String firstName, String lastName,
                  GenderType gender, String email, String phoneNumber,
                  String address)
  {
    super(id, firstName, lastName, gender, email, phoneNumber, address);
  }

  public Customer(String id, String firstName, String lastName,
                  GenderType gender, String email, String phoneNumber,
                  String address, String zipCode)
  {
    super(id, firstName, lastName, gender, email, phoneNumber, address);
    this.zipCode = zipCode;
  }

  public Customer(String id, String fullName, GenderType gender,
                  String email, String phoneNumber, String address,
                  String zipCode)
  {
    super(id, fullName, gender, email, phoneNumber, address);
    this.zipCode = zipCode;
  }

  public String getZipCode()
  {
    return zipCode;
  }

  public void setZipCode(String zipCode)
  {
    this.zipCode = zipCode;
  }

  @Override
  public String toString()
  {
    StringBuilder builder = new StringBuilder();
    builder.append(super.toString());
    builder.append("-");
    builder.append(zipCode);
    return builder.toString();
  }
}

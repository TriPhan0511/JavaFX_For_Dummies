package com.batch164.pharmacyapp.model;

public class Employee extends Person
{
  private boolean locked = false;
  private Employee supervisor;
  private Store store;

  public Employee()
  {
  }

  public Employee(String id, String firstName, String lastName,
                  GenderType gender, String email, String phoneNumber,
                  String address)
  {
    super(id, firstName, lastName,
        gender, email, phoneNumber, address);
  }

  public Employee(String id, String fullName, GenderType gender,
                  String email, String phoneNumber, String address)
  {
    super(id, fullName, gender, email, phoneNumber, address);
  }

  public boolean isLocked()
  {
    return locked;
  }

  public void setLocked(boolean locked)
  {
    this.locked = locked;
  }

  public Employee getSupervisor()
  {
    return supervisor;
  }

  public void setSupervisor(Employee supervisor)
  {
    this.supervisor = supervisor;
  }

  public Store getStore()
  {
    return store;
  }

  public void setStore(Store store)
  {
    this.store = store;
  }

  @Override
  public String toString()
  {
    StringBuilder builder = new StringBuilder();
    builder.append("ID: ");
    builder.append(getId());
    builder.append("\nFirst name: ");
    builder.append(getFirstName());
    builder.append("\nLast name: ");
    builder.append(getLastName());
    builder.append("\nGender: ");
    if (getGender() == GenderType.MALE)
    {
      builder.append("male");
    }
    else
    {
      builder.append("female");
    }
    builder.append("\nEmail: ");
    builder.append(getEmail());
    builder.append("Phone number: ");
    builder.append(getPhoneNumber());
    builder.append("\nAddress: ");
    builder.append(getAddress());
    return builder.toString();
  }
}





















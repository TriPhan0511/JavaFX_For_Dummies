package com.batch164.pharmarcyapplication.model;

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
}

package com.triphan.data_transfering_between_controllers;

public class Employee
{
  private String name;
  private int age;

  public Employee()
  {
  }

  public Employee(String name, int age)
  {
    this.name = name;
    this.age = age;
  }

  public String getName()
  {
    return name;
  }

  public int getAge()
  {
    return age;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setAge(int age)
  {
    this.age = age;
  }
}

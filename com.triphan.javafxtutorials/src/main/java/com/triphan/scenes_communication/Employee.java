package com.triphan.scenes_communication;

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

  public int getAge()
  {
    return age;
  }

  public void setAge(int age)
  {
    this.age = age;
  }
}

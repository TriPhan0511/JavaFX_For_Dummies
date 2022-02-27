package com.pharmacy_management.pharmacy_manager.model;

public class Employee
{
  private String id;
  private String firstName;
  private String lastName;
  private String gender;
  private String email;
  private String phoneNumber;
  private String address;

  public Employee()
  {
  }

  public Employee(String id, String firstName, String lastName,
                  String gender, String email, String phoneNumber,
                  String address)
  {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.gender = gender;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.address = address;
  }

  public Employee(String id, String fullName, String gender,
                  String email, String phoneNumber, String address)
  {
    this.id = id;
    setFullName(fullName);
    this.gender = gender;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.address = address;
  }

  public String getId()
  {
    return id;
  }

  public void setId(String id)
  {
    this.id = id;
  }

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public String getGender()
  {
    return gender;
  }

  public void setGender(String gender)
  {
    this.gender = gender;
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

  public String getFullName()
  {
    return this.firstName + " " + this.lastName;
  }

  public void setFullName(String fullName)
  {
    int spacePos = fullName.indexOf(" ");
    if (spacePos == -1)
    {
      this.firstName = fullName;
      this.lastName = "";
    }
    else
    {
      this.firstName = fullName.substring(0, spacePos);
      this.lastName = fullName.substring(spacePos + 1);
    }
  }

  @Override
  public String toString()
  {
    StringBuilder builder = new StringBuilder();
    builder.append(id);
    builder.append("-");
    builder.append(getFullName());
    builder.append("-");
    builder.append(gender);
    builder.append("-");
    builder.append(email);
    builder.append("-");
    builder.append(phoneNumber);
    builder.append(address);
    return builder.toString();
  }
}

















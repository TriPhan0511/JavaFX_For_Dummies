package com.triphan.testing;

import java.time.LocalDate;

public class Student
{
  private String studentID;
  private String studentName;
  private LocalDate dateOfBirth;
  private String phoneNumber;

  public Student()
  {
  }

  public Student(String studentID, String studentName, LocalDate dateOfBirth, String phoneNumber)
  {
    this.studentID = studentID;
    this.studentName = studentName;
    this.dateOfBirth = dateOfBirth;
    this.phoneNumber = phoneNumber;
  }

  public String getStudentID()
  {
    return studentID;
  }

  public void setStudentID(String studentID)
  {
    this.studentID = studentID;
  }

  public String getStudentName()
  {
    return studentName;
  }

  public void setStudentName(String studentName)
  {
    this.studentName = studentName;
  }

  public LocalDate getDateOfBirth()
  {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth)
  {
    this.dateOfBirth = dateOfBirth;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }

  @Override
  public String toString()
  {
    StringBuilder builder = new StringBuilder();
    builder.append(studentID);
    builder.append("-");
    builder.append(studentName);
    builder.append("-");
    if (dateOfBirth == null)
    {
      builder.append("Not know");
    }
    else
    {
      builder.append(dateOfBirth);
    }
    builder.append("-");
    if (phoneNumber == null)
    {
      builder.append("Not know");
    }
    else
    {
      builder.append(phoneNumber);
    }
    return builder.toString();
  }
}


























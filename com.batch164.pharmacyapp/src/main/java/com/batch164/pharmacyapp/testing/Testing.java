package com.batch164.pharmacyapp.testing;

import com.batch164.pharmacyapp.databasehandler.DatabaseHandler;
import com.batch164.pharmacyapp.model.Employee;
import com.batch164.pharmacyapp.model.GenderType;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Testing
{
  public static void main(String[] args)
  {
    showAllOfEmployees();
  }

  private static void showAllOfEmployees()
  {
    ArrayList<Employee> employeeArrayList = new ArrayList<>();
    String employeeID = "";
    String firstName = "";
    String lastName = "";
    String genderString = "";
    GenderType genderType;
    String email = "";
    String phoneNumber = "";
    String address = "";

      String sql = "SELECT employee_id, first_name, " +
          "last_name, gender, email, phone_number, address " +
          "FROM employee";
      try (Connection connection = DatabaseHandler.getConnection();
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(sql);)
      {
        while (resultSet.next())
        {
          employeeID = resultSet.getString("employee_id");
          firstName = resultSet.getString("first_name");
          lastName = resultSet.getString("last_name");
          genderString = resultSet.getString("gender");
          if (genderString.equalsIgnoreCase("m"))
          {
            genderType = GenderType.MALE;
          }
          else
          {
            genderType = GenderType.FEMALE;
          }
          email = resultSet.getString("email");
          phoneNumber = resultSet.getString("phone_number");
          address = resultSet.getString("address");
          employeeArrayList.add(new Employee(
              employeeID, firstName, lastName, genderType,
              email, phoneNumber, address));
        }

        for (Employee item : employeeArrayList)
        {
          System.out.println(item);
          System.out.println();
        }
      }
      catch (SQLException e)
      {
        e.printStackTrace();
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }

  }

  private static void showAllOfEmployees2()
  {
    ArrayList<Employee> employeeArrayList = new ArrayList<>();
    String employeeID = "";
    String firstName = "";
    String lastName = "";
    String genderString = "";
    GenderType genderType;
    String email = "";
    String phoneNumber = "";
    String address = "";

    try
    {
      String sql = "SELECT employee_id, first_name, " +
          "last_name, gender, email, phone_number, address " +
          "FROM employee";
      try (Connection connection = DatabaseHandler.getConnection();
           Statement statement = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(sql);)
      {
        while (resultSet.next())
        {
          employeeID = resultSet.getString("employee_id");
          firstName = resultSet.getString("first_name");
          lastName = resultSet.getString("last_name");
          genderString = resultSet.getString("gender");
          if (genderString.equalsIgnoreCase("m"))
          {
            genderType = GenderType.MALE;
          }
          else
          {
            genderType = GenderType.FEMALE;
          }
          email = resultSet.getString("email");
          phoneNumber = resultSet.getString("phone_number");
          address = resultSet.getString("address");
          employeeArrayList.add(new Employee(
              employeeID, firstName, lastName, genderType,
              email, phoneNumber, address));
        }

        for (Employee item : employeeArrayList)
        {
          System.out.println(item);
          System.out.println();
        }
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}





















package com.batch164.pharmarcyapplication.utils.dao;

import com.batch164.pharmarcyapplication.model.Employee;
import com.batch164.pharmarcyapplication.model.GenderType;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO
{
  /**
   * Get all information of an employee then
   * create an Employee object and return that object.
   * @param id A string represents the employee's id.
   * @param password A string represents the employee's password.
   * @return An Employee object.
   */
  public static Employee login(String id, String password)
  {
    Employee tempEmployee = null;
    String tempID;
    String tempFirstName;
    String tempLastName;
    String tempGenderString;
    GenderType tempGenderType;
    String tempEmail;
    String tempPhoneNumber;
    String tempAddress;
    String sql = "{ call usp_Login(?,?) }";
    try (Connection connection = DatabaseConnection.getConnection();
         CallableStatement statement = connection.prepareCall(sql))
    {
      statement.setString(1, id);
      statement.setString(2, password);
      try (ResultSet resultSet = statement.executeQuery())
      {
        while (resultSet.next())
        {
          tempID = resultSet.getString("employee_id");
          tempFirstName = resultSet.getString("first_name");
          tempLastName = resultSet.getString("last_name");
          tempGenderString = resultSet.getString("gender");
          if (tempGenderString.equalsIgnoreCase("m"))
          {
            tempGenderType = GenderType.MALE;
          }
          else
          {
            tempGenderType = GenderType.FEMALE;
          }
          tempEmail = resultSet.getString("email");
          tempPhoneNumber = resultSet.getString("phone_number");
          tempAddress = resultSet.getString("address");
          tempEmployee = new Employee(tempID, tempFirstName,
              tempLastName, tempGenderType,
              tempEmail, tempPhoneNumber, tempAddress);
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
    return tempEmployee;
  }
}

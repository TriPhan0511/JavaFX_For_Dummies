package com.batch164.pharmacyapp.utils.dao;

import com.batch164.pharmacyapp.model.Employee;
import com.batch164.pharmacyapp.model.GenderType;

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
   * @param connection A database connection.
   * @param id A string represents the employee's id.
   * @param password A string represents the employee's password.
   * @return An Employee object.
   */
  public static Employee login(Connection connection, String id, String password)
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
    String tempStoreID;
    String tempSupervisorID = null;
    Employee tempSupervisor = null;
    String sql = "{ call usp_Login(?,?) }";
    try (CallableStatement statement = connection.prepareCall(sql))
    {
      statement.setString(1, id);
      statement.setString(2, password);
      try (ResultSet resultSet = statement.executeQuery())
      {
        while (resultSet.next())
        {
          tempID = resultSet.getString("employee_id").trim();
          tempFirstName = resultSet.getString("first_name").trim();
          tempLastName = resultSet.getString("last_name").trim();
          tempGenderString = resultSet.getString("gender");
          if (tempGenderString.equalsIgnoreCase("m"))
          {
            tempGenderType = GenderType.MALE;
          }
          else
          {
            tempGenderType = GenderType.FEMALE;
          }
          tempEmail = resultSet.getString("email").trim();
          tempPhoneNumber = resultSet.getString("phone_number").trim();
          tempAddress = resultSet.getString("address").trim();
          tempStoreID = resultSet.getString("store_id").trim();
          tempSupervisorID = resultSet.getString("supervisor_id");

          tempEmployee = new Employee(tempID, tempFirstName,
              tempLastName, tempGenderType,
              tempEmail, tempPhoneNumber, tempAddress);
        }
      }
    }
    catch (SQLException e)
    {
      for (Throwable t : e)
      {
        t.printStackTrace();
      }
    }
    return tempEmployee;
  }
}

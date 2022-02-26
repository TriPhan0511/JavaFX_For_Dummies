package com.batch164.pharmacyapp.utils.dao;

import com.batch164.pharmacyapp.model.Employee;
import com.batch164.pharmacyapp.model.GenderType;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAO
{
  public static String getSupervisorID(Connection connection, String employeeID)
  {
    String tempSupervisorID = null;
    String sql = " {call usp_Get_SupervisorID(?)} ";
    try (CallableStatement statement = connection.prepareCall(sql))
    {
      statement.setString(1, employeeID);
      try (ResultSet resultSet = statement.executeQuery())
      {
        while (resultSet.next())
        {
          tempSupervisorID = resultSet.getString("supervisor_id");
        }
      }
    } catch (SQLException e)
    {
      for (Throwable t : e)
      {
        t.printStackTrace();
      }
    }
    return tempSupervisorID;
  }

//  public static Employee getAnEmployee(Connection connection, String id)
//  {
//    Employee tempEmployee = null;
//    String tempID;
//    String tempFirstName;
//    String tempLastName;
//    String tempGenderString;
//    GenderType tempGenderType;
//    String tempEmail;
//    String tempPhoneNumber;
//    String tempAddress;
//    String tempStoreID;
//    String tempSupervisorID = null;
//    Employee tempSupervisor = null;
//    String sql = "{ call usp_Get_An_Employee(?) }";
//    try (CallableStatement statement = connection.prepareCall(sql))
//    {
//      statement.setString(1, id);
//      try (ResultSet resultSet = statement.executeQuery())
//      {
//        while (resultSet.next())
//        {
//          tempID = resultSet.getString("employee_id").trim();
//          tempFirstName = resultSet.getString("first_name").trim();
//          tempLastName = resultSet.getString("last_name").trim();
//          tempGenderString = resultSet.getString("gender");
//          if (tempGenderString.equalsIgnoreCase("m"))
//          {
//            tempGenderType = GenderType.MALE;
//          }
//          else
//          {
//            tempGenderType = GenderType.FEMALE;
//          }
//          tempEmail = resultSet.getString("email").trim();
//          tempPhoneNumber = resultSet.getString("phone_number").trim();
//          tempAddress = resultSet.getString("address").trim();
//          tempStoreID = resultSet.getString("store_id").trim();
//          tempSupervisorID = resultSet.getString("supervisor_id");
//
//          tempEmployee = new Employee(tempID, tempFirstName,
//              tempLastName, tempGenderType,
//              tempEmail, tempPhoneNumber, tempAddress);
//        }
//      }
//    }
//    catch (SQLException e)
//    {
//      for (Throwable t : e)
//      {
//        t.printStackTrace();
//      }
//    }
//    return tempEmployee;
//  }


}






















package com.batch164.pharmacyapp.utils.dao;

import com.batch164.pharmacyapp.model.Employee;
import com.batch164.pharmacyapp.model.GenderType;
import com.batch164.pharmacyapp.model.Store;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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

  public static Employee getAnEmployee(Connection connection, String id)
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
    String sql = "{ call usp_Get_An_Employee(?) }";
    try (CallableStatement statement = connection.prepareCall(sql))
    {
      statement.setString(1, id);
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


  public static ObservableList<Employee> getEmployees(Connection connection)
  {
    ObservableList<Employee> employeeObservableList = FXCollections.observableArrayList();
    Employee tempEmployee = null;
    String tempID;
    String tempFirstName;
    String tempLastName;
    String tempGenderString;
    GenderType tempGenderType;
    String tempEmail;
    String tempPhoneNumber;
    String tempAddress;
    int tempLockStatusInt;
    boolean tempLockStatus;
    String tempStoreID;
    Store tempStore = null;
    String tempSupervisorID = null;
    Employee tempSupervisor = null;
    String sql = "{ call usp_Get_Employees }";

    try (CallableStatement statement = connection.prepareCall(sql);
         ResultSet resultSet = statement.executeQuery())
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
        tempLockStatusInt = resultSet.getInt("is_locked");
        if (tempLockStatusInt == 0)
        {
          tempLockStatus = false;
        }
        else
        {
          tempLockStatus = true;
        }
        tempStoreID = resultSet.getString("store_id").trim();
        tempStore = StoreDAO.getAStore(connection, tempStoreID);
        tempSupervisorID = resultSet.getString("supervisor_id");
        tempSupervisor = EmployeeDAO.getAnEmployee(connection, tempSupervisorID);

//        Create an Employee object from the data which has just fetched from the database
        tempEmployee = new Employee(tempID, tempFirstName,
            tempLastName, tempGenderType,
            tempEmail, tempPhoneNumber, tempAddress);
        tempEmployee.setLocked(tempLockStatus);
        tempEmployee.setSupervisor(tempSupervisor);
        tempEmployee.setStore(tempStore);

//        Add the newly created employee object to the list
        employeeObservableList.add(tempEmployee);
      }
    }
    catch (SQLException e)
    {
      for (Throwable t : e)
      {
        e.printStackTrace();
      }
    }
    return employeeObservableList;
  }

  public static ObservableList<String> getSupervisorIDsBaseOnStoreID(
      Connection connection, String storeID)
  {
    ObservableList<String> list = FXCollections.observableArrayList();
    String tempID;
    String sql = "{ call usp_Get_Supervisor_IDs_Base_On_Store_ID(?) }";
    try (CallableStatement statement = connection.prepareCall(sql))
    {
      statement.setString(1, storeID);
      try (ResultSet resultSet = statement.executeQuery())
      {
        while (resultSet.next())
        {
          tempID = resultSet.getString("employee_id").trim();
          list.add(tempID);
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
    return list;
  }

  public static void updateEmployee(
      Employee tempEmployee, Connection connection)
  {
    String sql = "{ call usp_Update_An_Employee(?,?,?,?,?,?,?,?,?,?) }";
    try (CallableStatement statement = connection.prepareCall(sql))
    {
      statement.setString(1, tempEmployee.getId());
      statement.setString(2, tempEmployee.getFirstName());
      statement.setString(3, tempEmployee.getLastName());
      if (tempEmployee.getGender() == GenderType.MALE)
      {
        statement.setString(4, "m");
      }
      else
      {
        statement.setString(4, "f");
      }
      statement.setString(5, tempEmployee.getEmail());
      statement.setString(6, tempEmployee.getPhoneNumber());
      statement.setString(7, tempEmployee.getAddress());
      if (tempEmployee.isLocked())
      {
        statement.setInt(8, 1);
      }
      else
      {
        statement.setInt(8, 0);
      }
      statement.setString(9, tempEmployee.getStore().getStoreID());
      if (tempEmployee.getSupervisor() != null)
      {
        statement.setString(10, tempEmployee.getSupervisor().getId());
      }
      else
      {
        statement.setString(10, "");
      }

      statement.executeUpdate();
    }
    catch (SQLException e)
    {
      for (Throwable t : e)
      {
        t.printStackTrace();
      }
    }
  }

  public static void insertAnEmployeeToDatabase(
      Employee tempEmployee, Connection connection)
  {
    String sql = "{ call usp_Insert_An_Employee_2(?,?,?,?,?,?,?,?,?,?) }";
    try (CallableStatement statement = connection.prepareCall(sql))
    {
      statement.setString(1, tempEmployee.getId());
      statement.setString(2, tempEmployee.getFirstName());
      statement.setString(3, tempEmployee.getLastName());
      if (tempEmployee.getGender() == GenderType.MALE)
      {
        statement.setString(4, "m");
      }
      else
      {
        statement.setString(4, "f");
      }
      statement.setString(5, tempEmployee.getEmail());
      statement.setString(6, tempEmployee.getPhoneNumber());
      statement.setString(7, tempEmployee.getAddress());
      if (tempEmployee.isLocked())
      {
        statement.setInt(8, 1);
      }
      else
      {
        statement.setInt(8, 0);
      }
      statement.setString(9, tempEmployee.getStore().getStoreID());
      if (tempEmployee.getSupervisor() != null)
      {
        statement.setString(10, tempEmployee.getSupervisor().getId());
      }
      else
      {
        statement.setString(10, "");
      }

      statement.executeUpdate();
    }
    catch (SQLException e)
    {
      for (Throwable t : e)
      {
        t.printStackTrace();
      }
    }
  }

  public static String getPasswordBaseOnEmployeeID(String employeeID, Connection connection)
  {
    String tempPassword = "";
    String sql = "{ call usp_Get_Password_Base_On_Employee_ID(?) }";
    try (CallableStatement statement = connection.prepareCall(sql))
    {
      statement.setString(1, employeeID);
      try (ResultSet resultSet = statement.executeQuery())
      {
        while (resultSet.next())
        {
          tempPassword = resultSet.getString("password").trim();
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
    return tempPassword;
  }

  public static boolean updatePassword(Employee currentUser, String newPassword, Connection connection)
  {
    String sql = "{ call usp_Change_Password(?,?) }";
    try (CallableStatement statement = connection.prepareCall(sql))
    {
      statement.setString(1, currentUser.getId());
      statement.setString(2, newPassword);
      if (statement.executeUpdate() == 1)
      {
        return true;
      }
    }
    catch (SQLException e)
    {
      for (Throwable t : e)
      {
        t.printStackTrace();
      }
    }
    return false;
  }
}






















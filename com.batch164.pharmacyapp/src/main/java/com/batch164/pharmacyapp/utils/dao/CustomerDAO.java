package com.batch164.pharmacyapp.utils.dao;

import com.batch164.pharmacyapp.model.Customer;
import com.batch164.pharmacyapp.model.GenderType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO
{
  public static ObservableList<Customer> getCustomers(Connection connection)
  {
    ObservableList<Customer> customers =
        FXCollections.observableArrayList();
    Customer tempCustomer;
    String tempID;
    String tempFirstName;
    String tempLastName;
    String tempGenderString;
    GenderType tempGenderType;
    String tempEmail;
    String tempPhoneNumber;
    String tempAddress;
    String tempZipCode;
    String sql = "{ call usp_Get_Customers }";
    try (CallableStatement statement = connection.prepareCall(sql);
         ResultSet result = statement.executeQuery())
    {

      while (result.next())
      {
        tempID = result.getString("customer_id").trim();
        tempFirstName = result.getString("first_name").trim();
        tempLastName = result.getString("last_name").trim();
        tempGenderString = result.getString("gender");
        if (tempGenderString.equalsIgnoreCase("m"))
        {
          tempGenderType = GenderType.MALE;
        } else
        {
          tempGenderType = GenderType.FEMALE;
        }
        tempEmail = result.getString("email").trim();
        tempPhoneNumber = result.getString("phone_number").trim();
        tempAddress = result.getString("address").trim();
        tempZipCode = result.getString("zip_code").trim();
        tempCustomer = new Customer(tempID, tempFirstName,
            tempLastName, tempGenderType, tempEmail,
            tempPhoneNumber, tempAddress, tempZipCode);
        customers.add(tempCustomer);
      }
    } catch (SQLException e)
    {
      for (Throwable t : e)
      {
        t.printStackTrace();
      }
    }
    return customers;
  }

  public static void deleteAllRecordsInCustomerTable(Connection connection)
  {
    String sql = "{ call usp_Delete_All_Customers }";
    try (CallableStatement statement = connection.prepareCall(sql))
    {
      statement.execute();
    }
    catch (SQLException e)
    {
      for (Throwable t : e)
      {
        e.printStackTrace();
      }
    }
  }

  public static void saveCustomersToDatabase(ObservableList<Customer> customers,
                                       Connection connection)
  {
    for (Customer item : customers)
    {
      CustomerDAO.insertACustomerToDatabase(item, connection);
    }
  }

  public static void insertACustomerToDatabase(Customer tempCustomer,
                                               Connection connection)
  {
    String sql = "{ call usp_Insert_A_Customer(?,?,?,?,?,?,?,?) }";
    try (CallableStatement statement = connection.prepareCall(sql))
    {
      statement.setString(1, tempCustomer.getId());
      statement.setString(2, tempCustomer.getFirstName());
      statement.setString(3, tempCustomer.getLastName());
      if (tempCustomer.getGender() == GenderType.MALE)
      {
        statement.setString(4, "m");
      }
      else
      {
        statement.setString(4, "f");
      }
      statement.setString(5, tempCustomer.getEmail());
      statement.setString(6, tempCustomer.getPhoneNumber());
      statement.setString(7, tempCustomer.getAddress());
      statement.setString(8, tempCustomer.getZipCode());
      statement.executeUpdate();
    }
    catch (SQLException e)
    {
      for (Throwable t : e)
      {
        e.printStackTrace();
      }
    }
  }

  public static void updateEmployee(Customer tempCustomer, Connection connection)
  {
    String sql = "{ call usp_Update_A_Customer(?,?,?,?,?,?,?,?) }";
    try (CallableStatement statement = connection.prepareCall(sql))
    {
      statement.setString(1, tempCustomer.getId());
      statement.setString(2, tempCustomer.getFirstName());
      statement.setString(3, tempCustomer.getLastName());
      if (tempCustomer.getGender() == GenderType.MALE)
      {
        statement.setString(4, "m");
      }
      else
      {
        statement.setString(4, "f");
      }
      statement.setString(5, tempCustomer.getEmail());
      statement.setString(6, tempCustomer.getPhoneNumber());
      statement.setString(7, tempCustomer.getAddress());
      statement.setString(8, tempCustomer.getZipCode());
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

  public static void deleteACustomerBasedOnID(String id, Connection connection)
  {
    String sql = "{ call usp_Delete_A_Customer_Based_On_ID(?) }";
    try (CallableStatement statement = connection.prepareCall(sql))
    {
      statement.setString(1, id);
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
}















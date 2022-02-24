package com.batch164.pharmarcyapplication.utils.dao;


import com.batch164.pharmarcyapplication.model.Customer;
import com.batch164.pharmarcyapplication.model.GenderType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO
{
  public static ObservableList<Customer> getCustomers()
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
    try (Connection conn = DatabaseConnection.getConnection();
         CallableStatement statement = conn.prepareCall(sql);
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
        }
        else
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
    }
    catch (SQLException e)
    {
      for (Throwable t : e)
      {
        t.printStackTrace();
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return customers;
  }
}















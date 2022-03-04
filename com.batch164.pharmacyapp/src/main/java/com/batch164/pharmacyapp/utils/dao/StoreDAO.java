package com.batch164.pharmacyapp.utils.dao;

import com.batch164.pharmacyapp.model.Store;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;

public class StoreDAO
{
  public static Store getStoreBasedOnEmployeeID(String employeeID, Connection connection)
  {
    Store tempStore = null;
    String tempStoreID;
    String tempStoreName;
    String tempEmail;
    String tempPhoneNumber;
    String tempAddress;
    String tempZipCode;
//    String tempManagerID;
//    LocalDate tempManagerStartDate;
    String sql = "{ Call usp_GetStoreBasedOnEmployeeID(?) }";
    try (CallableStatement statement = connection.prepareCall(sql))
    {
      statement.setString(1, employeeID);
      try (ResultSet resultSet = statement.executeQuery())
      {
        while (resultSet.next())
        {
          tempStoreID = resultSet.getString("store_id").trim();
          tempStoreName = resultSet.getString("store_name").trim();
          tempEmail = resultSet.getString("email").trim();
          tempPhoneNumber = resultSet.getString("phone_number").trim();
          tempAddress = resultSet.getString("address").trim();
          tempZipCode = resultSet.getString("zip_code").trim();
//        tempManagerID = resultSet.getString("manager_id");
//        tempManagerStartDate = LocalDate.ofInstant(
//            resultSet.getDate("manager_start_date").toInstant(),
//            ZoneId.systemDefault());
          tempStore = new Store(tempStoreID, tempStoreName, tempEmail,
              tempPhoneNumber, tempAddress, tempZipCode);
//          //      Testing
//          System.out.println(tempStore);
        }
      }

    }
    catch (SQLException e)
    {
      for (Throwable t : e)
      {
        e.printStackTrace();
      }
    }

    return tempStore;
  }

  public static Store getAStore(Connection connection, String storeID)
  {
    Store tempStore = null;
    String tempStoreID;
    String tempStoreName;
    String tempEmail;
    String tempPhoneNumber;
    String tempAddress;
    String tempZipCode;
    String sql = "{ call usp_Get_A_Store(?) }";
    try (CallableStatement statement = connection.prepareCall(sql))
    {
      statement.setString(1, storeID);
      try (ResultSet resultSet = statement.executeQuery())
      {
        while (resultSet.next())
        {
          tempStoreID = resultSet.getString("store_id").trim();
          tempStoreName = resultSet.getString("store_name").trim();
          tempEmail = resultSet.getString("email").trim();
          tempPhoneNumber = resultSet.getString("phone_number").trim();
          tempAddress = resultSet.getString("address").trim();
          tempZipCode = resultSet.getString("zip_code").trim();

          tempStore = new Store(tempStoreID, tempStoreName, tempEmail,
              tempPhoneNumber, tempAddress, tempZipCode);
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
    return tempStore;
  }

  public static ObservableList<String> getStoreIDs(Connection connection)
  {
    ObservableList<String> list = FXCollections.observableArrayList();
    String tempID;
    String sql = "{ call usp_Get_Stores }";
    try (CallableStatement statement = connection.prepareCall(sql);
         ResultSet resultSet = statement.executeQuery())
    {
      while (resultSet.next())
      {
        tempID = resultSet.getString("store_id").trim();
        list.add(tempID);
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
}



























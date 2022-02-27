package com.batch164.pharmacyapp.utils.dao;

import com.batch164.pharmacyapp.model.Store;

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
          tempStoreID = resultSet.getString("store_id");
          tempStoreName = resultSet.getString("store_name");
          tempEmail = resultSet.getString("email");
          tempPhoneNumber = resultSet.getString("phone_number");
          tempAddress = resultSet.getString("address");
          tempZipCode = resultSet.getString("zip_code");
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
}

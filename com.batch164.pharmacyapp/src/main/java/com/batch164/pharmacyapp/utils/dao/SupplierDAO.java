package com.batch164.pharmacyapp.utils.dao;

import com.batch164.pharmacyapp.model.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierDAO
{
  public static ObservableList<Supplier> getSuppliers(Connection connection)
  {
    ObservableList<Supplier> supplierObservableList =
        FXCollections.observableArrayList();
    Supplier tempSupplier = null;
    String tempID;
    String tempName;
    String tempEmail;
    String tempPhoneNumber;
    String tempAddress;
    String tempZipCode;
    String sql = "{ call usp_Get_Suppliers }";
    try (CallableStatement statement = connection.prepareCall(sql);
         ResultSet resultSet = statement.executeQuery())
    {
      while (resultSet.next())
      {
        tempID = resultSet.getString("supplier_id").trim();
        tempName = resultSet.getString("suplier_name").trim();
        tempEmail = resultSet.getString("email").trim();
        tempPhoneNumber = resultSet.getString("phone_number").trim();
        tempAddress = resultSet.getString("address").trim();
        tempZipCode = resultSet.getString("zip_code").trim();
        tempSupplier = new Supplier(tempID, tempName, tempEmail,
            tempPhoneNumber, tempAddress, tempZipCode);
        supplierObservableList.add(tempSupplier);
      }
    } catch (SQLException e)
    {
      for (Throwable t : e)
      {
        t.printStackTrace();
      }
    }
    return supplierObservableList;
  }

  public static void insertASupplierToDatabase(
      Supplier tempSupplier, Connection connection)
  {
    String sql = "{ call usp_Insert_A_Supplier(?,?,?,?,?,?) }";
    try (CallableStatement statement = connection.prepareCall(sql))
    {
      statement.setString(1, tempSupplier.getSupplierID());
      statement.setString(2, tempSupplier.getSupplierName());
      statement.setString(3, tempSupplier.getEmail());
      statement.setString(4, tempSupplier.getPhoneNumber());
      statement.setString(5, tempSupplier.getAddress());
      statement.setString(6, tempSupplier.getZipCode());
      statement.execute();
    }
    catch (SQLException e)
    {
      for (Throwable t : e)
      {
        t.printStackTrace();
      }
    }
  }

  public static void updateSupplier(
      Supplier tempSupplier, Connection connection)
  {
    String sql = "{ call usp_Update_A_Supplier(?,?,?,?,?,?) }";
    try (CallableStatement statement = connection.prepareCall(sql))
    {
      statement.setString(1, tempSupplier.getSupplierID());
      statement.setString(2, tempSupplier.getSupplierName());
      statement.setString(3, tempSupplier.getEmail());
      statement.setString(4, tempSupplier.getPhoneNumber());
      statement.setString(5, tempSupplier.getAddress());
      statement.setString(6, tempSupplier.getZipCode());
      statement.execute();
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




















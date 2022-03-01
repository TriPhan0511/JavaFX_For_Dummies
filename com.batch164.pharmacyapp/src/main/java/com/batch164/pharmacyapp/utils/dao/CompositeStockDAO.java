package com.batch164.pharmacyapp.utils.dao;

import com.batch164.pharmacyapp.model.composite.CompositeStock;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompositeStockDAO
{
  public static ObservableList<CompositeStock> getInformation(Connection connection)
  {
    ObservableList<CompositeStock> data = FXCollections.observableArrayList();
    CompositeStock tempCompositeStock;
    String tempStoreID;
    String tempStoreName;
    String tempCategoryID;
    String tempCategoryName;
    String tempProductID;
    String tempProductName;
    int tempQuantity;
    String sql = "{ call usp_Get_Information_From_Stock_Store_Category_And_Product }";
    try (CallableStatement statement = connection.prepareCall(sql);
         ResultSet resultSet = statement.executeQuery())
    {
      while (resultSet.next())
      {
        tempStoreID = resultSet.getString("store_id").trim();
        tempStoreName = resultSet.getString("store_name").trim();
        tempCategoryID = resultSet.getString("category_id").trim();
        tempCategoryName = resultSet.getString("category_name").trim();
        tempProductID = resultSet.getString("product_id").trim();
        tempProductName = resultSet.getString("product_name").trim();
        tempQuantity = resultSet.getInt("quantity");
        tempCompositeStock = new CompositeStock(tempStoreID, tempStoreName,
            tempCategoryID, tempCategoryName, tempProductID,
            tempProductName, tempQuantity);

        data.add(tempCompositeStock);
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return data;
  }
}























package com.triphan.searchbar_and_tableview;

import com.triphan.searchbar_and_tableview.databasehandler.DatabaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class SearchBarAndTableViewController implements Initializable
{
  @FXML
  private TableView<Product> productTableView;
  @FXML
  private TableColumn<Product, Integer> productIDTableColumn;
  @FXML
  private TableColumn<Product, String> brandTableColumn;
  @FXML
  private TableColumn<Product, String> modelNumberTableColumn;
  @FXML
  private TableColumn<Product, Integer> modelYearTableColumn;
  @FXML
  private TableColumn<Product, String> productNameTableColumn;
  @FXML
  private TableColumn<Product, String> descriptionTableColumn;

  @FXML
  private TextField keywordsTextField;

  //  Class fields
  ObservableList<Product> productObservableList = loadData();

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle)
  {
//    Set data for the table
    productTableView.setItems(productObservableList);
//    Set data for columns
    productIDTableColumn.setCellValueFactory(
        new PropertyValueFactory<Product, Integer>("productID"));
    brandTableColumn.setCellValueFactory(
        new PropertyValueFactory<Product, String>("brand"));
    modelNumberTableColumn.setCellValueFactory(
        new PropertyValueFactory<Product, String>("modelNumber"));
    modelYearTableColumn.setCellValueFactory(
        new PropertyValueFactory<Product, Integer>("modelYear"));
    productNameTableColumn.setCellValueFactory(
        new PropertyValueFactory<Product, String>("productName"));
    descriptionTableColumn.setCellValueFactory(
        new PropertyValueFactory<Product, String>("description"));

//    ------ BEGIN OF SEARCHING (based on product name, description, and model year) -------------
//    Initialize a filtered list
    FilteredList<Product> filteredData =
        new FilteredList<>(productObservableList, b -> true);

    keywordsTextField.textProperty().addListener((observable, oldValue, newValue) -> {
      filteredData.setPredicate(product -> {
//        If no search value then display all records or whatever records it currently has.
        if (newValue.isEmpty() || newValue.isBlank() || newValue == null)
        {
          return true;
        }
        String searchKeyword = newValue.toLowerCase();
        if (product.getProductName().toLowerCase().indexOf(searchKeyword) > -1)
        {
          return true; // Mean we found a match in product name.
        }
        else if (product.getDescription().toLowerCase().indexOf(searchKeyword) > -1)
        {
          return true; // Mean we found a match in description.
        }
        else if (Integer.toString(product.getModelYear()).indexOf(searchKeyword) > -1)
        {
          return true; // Mean we found a match in model year.
        }
        else
        {
          return false; // No match found.
        }
      });
    });
    SortedList<Product> sortedData = new SortedList<>(filteredData);
//    Bind sorted result with table
    sortedData.comparatorProperty().bind(productTableView.comparatorProperty());
//    Apply filtered and sorted data to the table
    productTableView.setItems(sortedData);

//    ------ END OF SEARCHING (based on product name, description, and model year) -------------
  }

  //  Helper method
  private void printList(List<Product> list)
  {
    for (Product item : list)
    {
      System.out.println(item);
    }
  }

  //  Helper method
  private ObservableList<Product> loadData()
  {
    ObservableList<Product> products = FXCollections.observableArrayList();
    int tempProductID;
    String tempProductName;
    String tempBrand;
    String tempModelNumber;
    int tempModelYear;
    String tempDescription;
    String sql = "{ call usp_Get_Products }";
    try (Connection connection = DatabaseConnection.getConnection();
         CallableStatement statement = connection.prepareCall(sql);
         ResultSet resultSet = statement.executeQuery())
    {
      while (resultSet.next())
      {
        tempProductID = resultSet.getInt("product_id");
        tempProductName = resultSet.getString("product_name").trim();
        tempBrand = resultSet.getString("brand").trim();
        tempModelNumber = resultSet.getString("model_number").trim();
        tempModelYear = resultSet.getInt("model_year");
        tempDescription = resultSet.getString("description").trim();

        products.add(new Product(tempProductID, tempBrand,
            tempModelNumber, tempModelYear,
            tempProductName, tempDescription));
      }
    }
    catch (SQLException e)
    {
      for (Throwable t : e)
      {
        t.printStackTrace();
      }
    } catch (IOException e)
    {
      e.printStackTrace();
    }
    return products;
  }
}

























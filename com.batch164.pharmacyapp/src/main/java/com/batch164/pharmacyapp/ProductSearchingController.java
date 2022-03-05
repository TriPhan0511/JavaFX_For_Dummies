package com.batch164.pharmacyapp;

import com.batch164.pharmacyapp.model.Employee;
import com.batch164.pharmacyapp.model.MyController;
import com.batch164.pharmacyapp.model.Store;
import com.batch164.pharmacyapp.model.composite.CompositeStock;
import com.batch164.pharmacyapp.utils.dao.CompositeStockDAO;
import com.batch164.pharmacyapp.utils.dao.DatabaseConnection;
import com.batch164.pharmacyapp.utils.scenehandler.SceneHandler;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProductSearchingController implements Initializable, MyController
{
  @FXML
  private Label welcomeLabel;
  @FXML
  private Label currentStoreLabel;

  private Employee currentUser;
  private Store currentStore;

  @Override
  public void setCurrentUser(Employee currentUser)
  {
    this.currentUser = currentUser;
  }

  @Override
  public void setCurrentStore(Store currentStore)
  {
    this.currentStore = currentStore;
  }

  @Override
  public void displayWelcomeMessage()
  {
    welcomeLabel.setText("Welcome, " + currentUser.getFullName() + " (staff)!");
  }

  @Override
  public void displayCurrentStore()
  {
    currentStoreLabel.setText("You are in " + currentStore.getStoreName() + ".");
  }
//  -------------------------------------------------------------------------------------------------

  @FXML
  private Button exitButton;
  @FXML
  private void exitButton_Click(ActionEvent event)
  {
    Stage stage = (Stage) ((Node) event.getSource()).
        getScene().getWindow();
    stage.close();
  }

  @FXML
  private Button goBackButton;
  @FXML
  void goBackButton_Click(ActionEvent event) throws IOException
  {
    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("staff-view.fxml"));
    SceneHandler.setInformationAndSwitchScene(loader, currentStore, currentUser, event);
  }

//  ----------------------------------------------------------------------------------

//  ------- Belows are the individual fields and methods for customer scene ----------

  @FXML
  private TextField keywordsTextField;

  @FXML
  private TableView<CompositeStock> productSearchingTableView;

  @FXML
  private TableColumn<CompositeStock, String> storeIDColumn;
  @FXML
  private TableColumn<CompositeStock, String> storeNameColumn;
  @FXML
  private TableColumn<CompositeStock, String> categoryIDColumn;
  @FXML
  private TableColumn<CompositeStock, String> categoryNameColumn;
  @FXML
  private TableColumn<CompositeStock, String> productIDColumn;
  @FXML
  private TableColumn<CompositeStock, String> productNameColumn;
  @FXML
  private TableColumn<CompositeStock, Integer> quantityColumn;

//  ----------------------------------------------------------------------------------

//  Class fields
//  Database connection
  private Connection connection;
//  Data for the productSearchingTableView
  ObservableList<CompositeStock> compositeStockObservableList;

//  ----------------------------------------------------------------------------------

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle)
  {
//    Initialize the database connection
//    (via DatabaseConnection.getConnection2 method)
    try
    {
//      connection = DatabaseConnection.getConnection2();
      connection = DatabaseConnection.getConnection();
    }
    catch (SQLException e)
    {
      for (Throwable t : e)
      {
        e.printStackTrace();
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
//    Initialize compositeStockObservableList
    compositeStockObservableList = CompositeStockDAO.getInformation(connection);
//    Set data for the productSearchingTableView
    productSearchingTableView.setItems(compositeStockObservableList);
//    Set data for the columns
    storeIDColumn.setCellValueFactory(
        new PropertyValueFactory<CompositeStock, String>("storeID"));
    storeNameColumn.setCellValueFactory(
        new PropertyValueFactory<CompositeStock, String>("storeName"));
    categoryIDColumn.setCellValueFactory(
        new PropertyValueFactory<CompositeStock, String>("categoryID"));
    categoryNameColumn.setCellValueFactory(
        new PropertyValueFactory<CompositeStock, String>("categoryName"));
    productIDColumn.setCellValueFactory(
        new PropertyValueFactory<CompositeStock, String>("productID"));
    productNameColumn.setCellValueFactory(
        new PropertyValueFactory<CompositeStock, String>("productName"));
    quantityColumn.setCellValueFactory(
        new PropertyValueFactory<CompositeStock, Integer>("quantity"));

//    ----------------------- BEGIN OF SEARCHING -------------------------------
//    (based on store's , store's name, product's id, product's name and quantity)
//    Initialize a filtered list
    FilteredList<CompositeStock> filteredData =
        new FilteredList<>(compositeStockObservableList, b -> true);

    keywordsTextField.textProperty().addListener((observable, oldValue, newValue) -> {
      filteredData.setPredicate(compositeStock -> {
//        If no search value then display all records or whatever records it currently has.
        if (newValue.isEmpty() || newValue.isBlank() || newValue == null)
        {
          return true;
        }
        String searchKeyword = newValue.toLowerCase();
        if (compositeStock.getStoreID().toLowerCase().indexOf(searchKeyword) > -1)
        {
          return true; // Mean we found a match in store ID.
        }
        else if (compositeStock.getStoreName().toLowerCase().indexOf(searchKeyword) > -1)
        {
          return true; // Mean we found a match in store name.
        }
        else if (compositeStock.getCategoryID().toLowerCase().indexOf(searchKeyword) > -1)
        {
          return true; // Mean we found a match in category name.
        }
        else if (compositeStock.getCategoryName().toLowerCase().indexOf(searchKeyword) > -1)
        {
          return true; // Mean we found a match in category name.
        }
        else if (compositeStock.getProductID().toLowerCase().indexOf(searchKeyword) > -1)
        {
          return true; // Mean we found a match in product ID.
        }
        else if (compositeStock.getProductName().toLowerCase().indexOf(searchKeyword) > -1)
        {
          return true; // Mean we found a match in product name.
        }
        else if (Integer.toString(compositeStock.getQuantity()).indexOf(searchKeyword) > -1)
        {
          return true; // Mean we found a match in quantity.
        }
        else
        {
          return false; // No match found.
        }
      });
    });
    SortedList<CompositeStock> sortedData = new SortedList<>(filteredData);
//    Bind sorted result with table
    sortedData.comparatorProperty().bind(productSearchingTableView.comparatorProperty());
//    Apply filtered and sorted data to the table
    productSearchingTableView.setItems(sortedData);

//    ----------------------- BEGIN OF SEARCHING -------------------------------

////    ------ BEGIN OF SEARCHING (based on product name, store name, and quantity) -------------
////    Initialize a filtered list
//    FilteredList<CompositeStock> filteredData =
//        new FilteredList<>(compositeStockObservableList, b -> true);
//
//    keywordsTextField.textProperty().addListener((observable, oldValue, newValue) -> {
//      filteredData.setPredicate(compositeStock -> {
////        If no search value then display all records or whatever records it currently has.
//        if (newValue.isEmpty() || newValue.isBlank() || newValue == null)
//        {
//          return true;
//        }
//        String searchKeyword = newValue.toLowerCase();
//        if (compositeStock.getProductName().toLowerCase().indexOf(searchKeyword) > -1)
//        {
//          return true; // Mean we found a match in product name.
//        }
//        else if (compositeStock.getStoreName().toLowerCase().indexOf(searchKeyword) > -1)
//        {
//          return true; // Mean we found a match in store name.
//        }
//        else if (Integer.toString(compositeStock.getQuantity()).indexOf(searchKeyword) > -1)
//        {
//          return true; // Mean we found a match in quantity.
//        }
//        else
//        {
//          return false; // No match found.
//        }
//      });
//    });
//    SortedList<CompositeStock> sortedData = new SortedList<>(filteredData);
////    Bind sorted result with table
//    sortedData.comparatorProperty().bind(productSearchingTableView.comparatorProperty());
////    Apply filtered and sorted data to the table
//    productSearchingTableView.setItems(sortedData);
//
////    ------ END OF SEARCHING (based on product name, description, and model year) -------------




  }

//  ----------------------------------------------------------------------------------










}






































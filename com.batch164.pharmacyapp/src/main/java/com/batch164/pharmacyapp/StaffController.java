package com.batch164.pharmacyapp;

import com.batch164.pharmacyapp.model.Employee;
import com.batch164.pharmacyapp.model.Store;
import com.batch164.pharmacyapp.utils.scenehandler.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class StaffController implements Initializable
{
  //  ------- Belows are the common fields and methods for every scene ----------
  @FXML
  private Button exitButton;
  @FXML
  private Button logoutButton;
  @FXML
  private Button profileButton;

  @FXML
  private Label welcomeLabel;

  @FXML
  void logoutButton_Click(ActionEvent event)
  {
//    TODO
    Alert alert = new Alert(Alert.AlertType.INFORMATION,
        "Under construction. Coming soon!");
    alert.show();
  }

  @FXML
  void profileButton_Click(ActionEvent event)
  {
//    TODO
    Alert alert = new Alert(Alert.AlertType.INFORMATION,
        "Under construction. Coming soon!");
    alert.show();
  }

  @FXML
  private void exitButton_Click(ActionEvent event)
  {
    Stage stage = (Stage) ((Node) event.getSource()).
        getScene().getWindow();
    stage.close();
  }

//  ---------------------------------------------------------------------------------------

//  ------- Belows are the individual fields and methods for staff scene ----------
  @FXML
  private Button sellingButton;

  @FXML
  private Button customerManagementButton;

  @FXML
  private Button productSearchingButton;
  @FXML
  void productSearchingButton_Click(ActionEvent event) throws IOException
  {
    SceneHandler.switchScene("product-searching-view.fxml", event);
  }

  @FXML
  void customerManagementButton_Click(ActionEvent event) throws IOException
  {
//    Go to "customer-view" scene
    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("customer-view.fxml"));
    Parent root = loader.load();
//    CustomerController customerController = loader.getController();
//    customerController.setConnection(connection);
    Scene customerScene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(customerScene);
  }



  @FXML
  void saveButton_Click(ActionEvent event)
  {

  }

  @FXML
  void sellingButton_Click(ActionEvent event)
  {

  }

//  ---------------------------------------------------------------------------------------

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle)
  {

  }
//  ---------------------------------------------------------------------------------------

  //  Class fields
  private Connection connection;

  //  Class methods
//  The below method will be called at LoginDatabaseController
//  to set database connection for the connection class field.
  public void setConnection(Connection connection)
  {
    this.connection = connection;
  }
  public Connection getConnection()
  {
    return connection;
  }
//  ---------------------------------------------------------------------------------------





//  ---------------------------------------------------------------------------------------



////  Get the current employee
//  private Employee currentEmployee = null;
////  This method will be called at LoginSystemController
//  public void setCurrentEmployee(Employee tempEmployee)
//  {
//    this.currentEmployee = tempEmployee;
//  }
//
////  Get the current store
//  private Store currentStore = null;
////  This method will be called at LoginSystemController
//  public void setCurrentStore(Store tempStore)
//  {
//    this.currentStore = tempStore;
//  }
}




























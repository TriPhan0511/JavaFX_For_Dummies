package com.batch164.pharmacyapp;

import com.batch164.pharmacyapp.model.Employee;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ManagerController
{

  //  ------- Belows are the common fields and methods for every scene ----------
  @FXML
  private Label welcomeLabel;
  public void displayWelcomeMessage()
  {
    welcomeLabel.setText("Welcome, " + currentUser.getFullName());
  }

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
  private Button logoutButton;
  @FXML
  void logoutButton_Click(ActionEvent event)
  {
//    TODO
    Alert alert = new Alert(Alert.AlertType.INFORMATION,
        "Under construction. Coming soon!");
    alert.show();
  }

  @FXML
  private Button profileButton;
  @FXML
  void profileButton_Click(ActionEvent event)
  {
//    TODO
    Alert alert = new Alert(Alert.AlertType.INFORMATION,
        "Under construction. Coming soon!");
    alert.show();
  }
//  ---------------------------------------------------------------------------------------

  //  ------- Belows are the individual fields and methods for staff scene ----------
  @FXML
  private Button employeeManagementButton;
  @FXML
  private void employeeManagementButton_Click(ActionEvent event) throws IOException
  {
    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("employee-manager-view.fxml"));
//    FXMLLoader loader = new FXMLLoader(
//        getClass().getResource("employee-view.fxml"));
    Parent root = loader.load();
    Scene employeeScene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(employeeScene);
  }

//------------------------------------------------------------------------------------------------------

//  Another class fields

  private Employee currentUser;

  public Employee getCurrentUser()
  {
    return currentUser;
  }

  public void setCurrentUser(Employee currentUser)
  {
    this.currentUser = currentUser;
  }
  //  ----------------------------------------------------------------------------------------

}

























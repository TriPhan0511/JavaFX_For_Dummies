package com.batch164.pharmacyapp;

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

public class ManagerController
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
  private Button employeeManagementButton;

  @FXML
  private void employeeManagementButton_Click(ActionEvent event) throws IOException
  {
    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("employee-view.fxml"));
    Parent root = loader.load();
    Scene employeeScene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(employeeScene);
  }

//  ---------------------------------------------------------------------------------------

}

























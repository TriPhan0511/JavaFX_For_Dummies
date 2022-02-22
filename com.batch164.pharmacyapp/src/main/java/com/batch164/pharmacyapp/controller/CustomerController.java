package com.batch164.pharmacyapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CustomerController {

  @FXML
  private Button logoutButton;
  @FXML
  private Button profileButton;
  @FXML
  private Button exitButton;

  @FXML
  private Label welcomeLabel;

  @FXML
  void logoutButton_Click(ActionEvent event)
  {

  }

  @FXML
  void profileButton_Click(ActionEvent event)
  {

  }

  @FXML
  private void exitButton_Click(ActionEvent event)
  {
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.close();
  }

}























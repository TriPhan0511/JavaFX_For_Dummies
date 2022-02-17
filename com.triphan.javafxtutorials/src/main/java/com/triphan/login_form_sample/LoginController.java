package com.triphan.login_form_sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController
{
  @FXML
  private TextField usernameTextField;
  @FXML
  private PasswordField passwordField;
  @FXML
  private Button loginButton;
  @FXML
  private Button cancelButton;

  @FXML
  private void loginButton_Click()
  {

  }

  @FXML
  private void cancelButton_Click(ActionEvent event)
  {
//    Get reference to the stage
//    Way 1:
//    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

//    Way 2:
    Stage stage = (Stage) cancelButton.getScene().getWindow();
//    Call the close method
    stage.close();
  }
}


























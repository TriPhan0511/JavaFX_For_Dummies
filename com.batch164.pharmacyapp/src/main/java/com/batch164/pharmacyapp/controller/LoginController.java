package com.batch164.pharmacyapp.controller;

import com.batch164.pharmacyapp.model.Employee;
import com.batch164.pharmacyapp.utils.dao.LoginDAO;
import com.batch164.pharmacyapp.utils.validation.TextFieldValidation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController
{
  //  Common  fields and methods
  @FXML
  private Button exitButton;
  @FXML
  private void exitButton_Click(ActionEvent event)
  {
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.close();
  }


//  Individual fields and methods
  @FXML
  private TextField idTextField;
  @FXML
  private PasswordField passwordField;
  @FXML
  private Button loginButton;
  @FXML
  private Button cancelButton;
  @FXML
  private Label errorMessageLabel;

  @FXML
  private void loginButton_Click()
  {
    TextFieldValidation textFieldValidation =
        new TextFieldValidation();
    String blankErrorMessage = "Please enter id and password";
    if (textFieldValidation.isBlank(idTextField, errorMessageLabel, blankErrorMessage)
        || textFieldValidation.isBlank(passwordField, errorMessageLabel, blankErrorMessage))
    {
      passwordField.setText("");
    }
    else
    {
      Employee employee = LoginDAO.login(
          idTextField.getText().trim(),
          passwordField.getText().trim());
      if (employee == null)
      {
        errorMessageLabel.setText("Login failed. Please try again.");
        passwordField.setText("");
      }
      else
      {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, employee.toString());
        alert.show();
        errorMessageLabel.setText("");
        idTextField.setText("");
        passwordField.setText("");
      }
    }
  }

  @FXML
  private void cancelButton_Click(ActionEvent event)
  {
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.close();
  }
}
























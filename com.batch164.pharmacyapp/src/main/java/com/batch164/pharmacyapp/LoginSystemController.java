package com.batch164.pharmacyapp;

import com.batch164.pharmacyapp.model.Employee;
import com.batch164.pharmacyapp.utils.TextFieldHandler;
import com.batch164.pharmacyapp.utils.dao.LoginDAO;
import com.batch164.pharmacyapp.utils.validation.TextFieldValidation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class LoginSystemController
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
  private Button resetButton;
  @FXML
  private Label errorMessageLabel;

  //  Database Connection
  Connection connection;

  public void setConnection(Connection connection)
  {
    this.connection = connection;
  }

  @FXML
  private void loginButton_Click(ActionEvent event) throws IOException
  {
    if (isValidTextFields())
    {
      String tempID = idTextField.getText().trim();
      String tempPassword = passwordField.getText().trim();
      Employee tempEmployee = LoginDAO.login(connection, tempID, tempPassword);
      if (tempEmployee == null)
      {
        errorMessageLabel.setText("Login failed. Please try again.");
        passwordField.setText("");
      } else // Should go to another scene base on tempEmployee
      {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, tempEmployee.toString());
        alert.show();
        errorMessageLabel.setText("");
        idTextField.setText("");
        passwordField.setText("");
      }
    }
  }
  @FXML
  private void resetButton_Click(ActionEvent event)
  {
    TextFieldHandler.clearTextFields(idTextField, passwordField);
  }

  //  Helper method
  private boolean isValidTextFields()
  {
    if (!TextFieldValidation.isBlank(
        idTextField,
        errorMessageLabel,
        "User name is required.")
        && !TextFieldValidation.isBlank(
        passwordField,
        errorMessageLabel,
        "Password is required."))
    {
      return true;
    }
    passwordField.setText("");
    return false;
  }
}















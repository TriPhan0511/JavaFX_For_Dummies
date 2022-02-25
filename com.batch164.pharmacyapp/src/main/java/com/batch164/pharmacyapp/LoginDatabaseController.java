package com.batch164.pharmacyapp;

import com.batch164.pharmacyapp.model.Employee;
import com.batch164.pharmacyapp.utils.TextFieldHandler;
import com.batch164.pharmacyapp.utils.dao.DatabaseConnection;
import com.batch164.pharmacyapp.utils.dao.LoginDAO;
import com.batch164.pharmacyapp.utils.validation.TextFieldValidation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginDatabaseController
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
  private TextField userNameTextField;
  @FXML
  private PasswordField passwordField;
  @FXML
  private Button loginButton;
  @FXML
  private Button resetButton;
  @FXML
  private Label errorMessageLabel;

  //  Database Connection
  private Connection connection = null;

  public Connection getConnection()
  {
    return this.connection;
  }

  @FXML
  private void loginButton_Click(ActionEvent event) throws IOException
  {
    if (isValidTextFields())
    {
//      Initialize a connection to the database
      String databaseUserName = userNameTextField.getText().trim();
      String databasePassword = passwordField.getText().trim();
      try
      {
        connection = DatabaseConnection.getConnection(
            databaseUserName, databasePassword);
      } catch (SQLException e)
      {
        e.printStackTrace();
      }
      if (connection != null) // Go to the "login-system-view" scene
      {
        FXMLLoader loader = new FXMLLoader(
            getClass().getResource("login-system-view.fxml"));
        Parent root = loader.load();

//        Set database connection for LoginSystemController (!IMPORTANT)
        LoginSystemController loginSystemController = loader.getController();
        loginSystemController.setConnection(connection);

//        Switch scene
        Scene loginSystemScene = new Scene(root);
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        primaryStage.setScene(loginSystemScene);
      }
      else
      {
        errorMessageLabel.setText("Login failed. Please try again.");
      }
    }
  }

  @FXML
  private void resetButton_Click(ActionEvent event)
  {
    TextFieldHandler.clearTextFields(userNameTextField, passwordField);
  }

  //  Helper method
  private boolean isValidTextFields()
  {
    if (!TextFieldValidation.isBlank(
        userNameTextField,
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


















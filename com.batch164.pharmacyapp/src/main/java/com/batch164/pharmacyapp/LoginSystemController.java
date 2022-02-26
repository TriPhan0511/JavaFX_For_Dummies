package com.batch164.pharmacyapp;

import com.batch164.pharmacyapp.model.Employee;
import com.batch164.pharmacyapp.utils.TextFieldHandler;
import com.batch164.pharmacyapp.utils.dao.EmployeeDAO;
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
  private Connection connection;
//  The below method will be called in LoginDatabaseController
//  to set database connection for the connection class field.
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
      goToNextScene(tempEmployee, event, errorMessageLabel, passwordField);
    }
  }

  //  Helper method
  private void goToNextScene(Employee tempEmployee,
                             ActionEvent event,
                             Label errorMessageLabel,
                             PasswordField passwordField) throws IOException
  {
    if (tempEmployee == null)
    {
      errorMessageLabel.setText("Login failed. Please try again.");
      passwordField.setText("");
    }
    else
    {
//      Get supervisorID of the current employee.
//      1. If the supervisorID is null, it means the current employee is a manager,
//          so we go to the  "manager-view" scene.

//      2. If the supervisorID is not null,
//          we continue get supervisorID of the current employee's supervisor.
//          And we have two cases:
//          2.1 If the supervisorID of the current employee's supervisor is null,
//              it means the current employee is a supervisor,
//              so we go to the "supervisor-view" scene.
//          2.2 If the supervisor ID of the current employee's supervisor is not null,
//              it means the current employee is a staff,
//              so we go to the "staff-view" scene.


      FXMLLoader loader;
      Parent root;
      String tempSupervisorID =
          EmployeeDAO.getSupervisorID(connection, tempEmployee.getId());
      if (tempSupervisorID == null)
      {
//        Go to the "manager-view" scene
        loader = new FXMLLoader(
            getClass().getResource("manager-view.fxml"));
        root = loader.load();
        Scene managerScene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(managerScene);
      }
      else
      {
        String tempHigherSupervisorID =
            EmployeeDAO.getSupervisorID(connection, tempSupervisorID);
        if (tempHigherSupervisorID == null)
        {
//          Go to the "supervisor-view" scene
          loader = new FXMLLoader(
              getClass().getResource("supervisor-view.fxml"));
          root = loader.load();
          Scene supervisorScene = new Scene(root);
          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          stage.setScene(supervisorScene);
        }
        else
        {
//          Go to the "staff-view" scene
          loader = new FXMLLoader(
              getClass().getResource("staff-view.fxml"));
          root = loader.load();
          Scene staffScene = new Scene(root);
          Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
          stage.setScene(staffScene);
        }
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















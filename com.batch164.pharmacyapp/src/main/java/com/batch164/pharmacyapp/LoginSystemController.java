package com.batch164.pharmacyapp;

import com.batch164.pharmacyapp.model.Employee;
import com.batch164.pharmacyapp.utils.Clearing;
import com.batch164.pharmacyapp.utils.dao.DatabaseConnection;
import com.batch164.pharmacyapp.utils.dao.EmployeeDAO;
import com.batch164.pharmacyapp.utils.dao.LoginDAO;
import com.batch164.pharmacyapp.utils.scenehandler.SceneHandler;
import com.batch164.pharmacyapp.utils.validation.TextFieldValidation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginSystemController implements Initializable
{
  //  ------- Belows are the common fields and methods for every scene ----------
  @FXML
  private Button exitButton;
  @FXML
  private void exitButton_Click(ActionEvent event)
  {
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.close();
  }

  //  ------- Belows are the individual fields and methods for staff scene ----------
  @FXML
  private TextField idTextField;
  @FXML
  private PasswordField passwordField;

  @FXML
  private Label errorMessageLabel;

  @FXML
  private Button loginButton;
  @FXML
  private void loginButton_Click(ActionEvent event) throws IOException
  {
    if (isValidTextFields())
    {
      String tempID = idTextField.getText().trim();
      String tempPassword = passwordField.getText().trim();
      Employee tempEmployee = LoginDAO.login(connection, tempID, tempPassword);

//      Get reference to StaffController
      FXMLLoader loader;
      loader = new FXMLLoader(getClass().getResource("staff-view.fxml"));
      loader.load();
      StaffController staffController = loader.getController();


//      Go to next scene
      goToNextScene(tempEmployee, event, errorMessageLabel, passwordField);
    }
  }

  @FXML
  private Button resetButton;
  @FXML
  private void resetButton_Click(ActionEvent event)
  {
    Clearing.clearTextFields(idTextField, passwordField);
  }

  //  ------------------------------------------------------------------------------------------

  //  Class fields
  private Connection connection;

//  ------------------------------------------------------------------------------------------

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle)
  {
    try
    {
      connection = DatabaseConnection.getConnection();
    }
    catch (SQLException e)
    {
      for (Throwable t : e)
      {
        t.printStackTrace();
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

//  ------------------------------------------------------------------------------------------

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
//      Get supervisorID of the current employee,
//      then indicate which next scene we will go to:
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
        SceneHandler.switchScene("manager-view.fxml", event);
      }
      else
      {
        String tempHigherSupervisorID =
            EmployeeDAO.getSupervisorID(connection, tempSupervisorID);
        if (tempHigherSupervisorID == null)
        {
//          Go to the "supervisor-view" scene
          SceneHandler.switchScene("supervisor-view.fxml", event);
        }
        else
        {
//          Go to the "staff-view" scene
          SceneHandler.switchScene("staff-view.fxml", event);
        }
      }
    }
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















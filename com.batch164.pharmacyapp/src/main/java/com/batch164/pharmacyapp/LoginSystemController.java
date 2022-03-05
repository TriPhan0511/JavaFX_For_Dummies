package com.batch164.pharmacyapp;

import com.batch164.pharmacyapp.model.Employee;
import com.batch164.pharmacyapp.model.RoleType;
import com.batch164.pharmacyapp.model.Store;
import com.batch164.pharmacyapp.utils.Clearing;
import com.batch164.pharmacyapp.utils.EmployeeUtils;
import com.batch164.pharmacyapp.utils.dao.DatabaseConnection;
import com.batch164.pharmacyapp.utils.dao.EmployeeDAO;
import com.batch164.pharmacyapp.utils.dao.LoginDAO;
import com.batch164.pharmacyapp.utils.dao.StoreDAO;
import com.batch164.pharmacyapp.utils.scenehandler.SceneHandler;
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
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginSystemController implements Initializable
{
  @FXML
  private TextField idTextField;
  @FXML
  private PasswordField passwordField;

  @FXML
  private Label errorMessageLabel;

  @FXML
  private Button exitButton;
  @FXML
  private void exitButton_Click(ActionEvent event)
  {
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.close();
  }

  @FXML
  private Button loginButton;
  @FXML
  private void loginButton_Click(ActionEvent event) throws IOException
  {
    if (isValidTextFields())
    {
//      Base on the user's input, fetch an employee from the database.
//      If the fetched employee is null, display the error message.
//      Otherwise, go to the next scene.
      String inputID = idTextField.getText().trim();
      String inputPassword = passwordField.getText().trim();
      Employee currentUser = LoginDAO.login(connection, inputID, inputPassword);
      if (currentUser == null)
      {
        errorMessageLabel.setText("Login failed. Please try again.");
        passwordField.setText("");
      }
      else
      {
        goToNextScene(currentUser, event, connection);
      }
    }
  }

  @FXML
  private Button resetButton;
  @FXML
  private void resetButton_Click(ActionEvent event)
  {
    Clearing.clearTextFields(idTextField, passwordField);
  }

  //  -----------------------------------------------------------------------------------------------

  //  Class fields
  private Connection connection;

//  ---------------------------------------------------------------------------------------------------

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

  //  Helper method
  private void goToNextScene(
      Employee currentUser, ActionEvent event,
      Connection connection) throws IOException
  {
//    Get the store which the current user belongs to
    Store currentStore = StoreDAO.getStoreBasedOnEmployeeID(
        currentUser.getId(), connection);

    FXMLLoader loader;
    if (EmployeeUtils.indicateRoleOfUser(currentUser, connection) == RoleType.MANAGER)
    {
      loader = new FXMLLoader(
          getClass().getResource("manager-view.fxml"));
      SceneHandler.setInformationAndSwitchScene(loader, currentStore, currentUser, event);
    }
    else if (EmployeeUtils.indicateRoleOfUser(currentUser, connection) == RoleType.SUPERVISOR)
    {
      loader = new FXMLLoader(
          getClass().getResource("supervisor-view.fxml"));
      SceneHandler.setInformationAndSwitchScene(loader, currentStore,currentUser,event);
    }
    else if (EmployeeUtils.indicateRoleOfUser(currentUser, connection) == RoleType.STAFF)
    {
      loader = new FXMLLoader(
          getClass().getResource("staff-view.fxml"));
      SceneHandler.setInformationAndSwitchScene(loader, currentStore, currentUser, event);
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















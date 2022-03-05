package com.batch164.pharmacyapp;

import com.batch164.pharmacyapp.model.Employee;
import com.batch164.pharmacyapp.model.MyController;
import com.batch164.pharmacyapp.model.Store;
import com.batch164.pharmacyapp.utils.Clearing;
import com.batch164.pharmacyapp.utils.dao.DatabaseConnection;
import com.batch164.pharmacyapp.utils.dao.EmployeeDAO;
import com.batch164.pharmacyapp.utils.validation.PasswordFieldValidation;
import com.batch164.pharmacyapp.utils.validation.TextFieldValidation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PasswordChangingController implements Initializable, MyController
{
  @FXML
  private Label welcomeLabel;
  public void displayWelcomeMessage()
  {
    welcomeLabel.setText("Welcome, " + currentUser.getFullName() + " (manager)!");
  }

  @FXML
  private Label currentStoreLabel;
  public void displayCurrentStore()
  {
    currentStoreLabel.setText("You are in " + currentStore.getStoreName() + ".");
  }

  @FXML
  private Label errorMessageLabel;


  @FXML
  private PasswordField currentPasswordField;
  @FXML
  private PasswordField newPasswordField;
  @FXML
  private PasswordField confirmPasswordField;

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
  private Button changePasswordButton;
  @FXML
  void changePasswordButton_Click(ActionEvent event)
  {
    String passwordFromDatabase = EmployeeDAO.getPasswordBaseOnEmployeeID(
        currentUser.getId(), connection);

    if (isValidTextFields(passwordFromDatabase,
        currentPasswordField,
        newPasswordField,
        confirmPasswordField,
        errorMessageLabel))


    {
      System.out.println("OK");
    }
  }

  //  Helper method
  private boolean isValidTextFields(String passwordFromDatabase,
                                    PasswordField currentPasswordField,
                                    PasswordField newPasswordField,
                                    PasswordField confirmPasswordField,
                                    Label errorMessageLabel)
  {
    if (!TextFieldValidation.isBlank(currentPasswordField, errorMessageLabel,
        "The current password is required.")
        && !TextFieldValidation.isBlank(newPasswordField, errorMessageLabel,
        "The new password is required.")
        && !TextFieldValidation.isBlank(confirmPasswordField, errorMessageLabel,
        "Please confirm the new password.")
        && PasswordFieldValidation.areSame(newPasswordField, confirmPasswordField,
        errorMessageLabel, "New password and confirm password are not the same")
        && !PasswordFieldValidation.areSame(newPasswordField, currentPasswordField,
          errorMessageLabel, "The new password must different from the new password.")
        && PasswordFieldValidation.areSame2(passwordFromDatabase, currentPasswordField,
        errorMessageLabel, "The current password you entered was wrong.")
    )
    {

      Clearing.clearLabels(errorMessageLabel);
      return true;
    }
    return false;
  }

////  Helper method
//  private boolean isValidTextFields(PasswordField currentPasswordField,
//                                    PasswordField newPasswordField,
//                                    PasswordField confirmPasswordField,
//                                    Label errorMessageLabel)
//  {
//    if (!TextFieldValidation.isBlank(currentPasswordField, errorMessageLabel,
//                            "The current password is required.")
//        && !TextFieldValidation.isBlank(newPasswordField, errorMessageLabel,
//                            "The new password is required.")
//        && !TextFieldValidation.isBlank(confirmPasswordField, errorMessageLabel,
//                            "Please confirm the new password.")
//    )
//    {
//      Clearing.clearLabels(errorMessageLabel);
//      return true;
//    }
//    return false;
//  }

  @FXML
  private Button resetButton;
  @FXML
  void resetButton_Click(ActionEvent event)
  {
    Clearing.clearTextFields(currentPasswordField, newPasswordField,
        confirmPasswordField);
    Clearing.clearLabels(errorMessageLabel);
  }

  //  ----------------------------------------------------------------------------------------

  //  Another class fields
  private Connection connection;

  private Employee currentUser;
  public Employee getCurrentUser()
  {
    return currentUser;
  }
  public void setCurrentUser(Employee currentUser)
  {
    this.currentUser = currentUser;
  }

  private Store currentStore;
  public void setCurrentStore(Store currentStore)
  {
    this.currentStore = currentStore;
  }

  //  ----------------------------------------------------------------------------------------

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
}

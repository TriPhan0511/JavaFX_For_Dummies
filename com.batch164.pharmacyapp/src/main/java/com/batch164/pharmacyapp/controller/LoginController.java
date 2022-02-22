package com.batch164.pharmacyapp.controller;

import com.batch164.pharmacyapp.model.Employee;
import com.batch164.pharmacyapp.utils.dao.LoginDAO;
import com.batch164.pharmacyapp.utils.validation.TextFieldValidation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController
{
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

//  private Employee login(String username, String password)
//  {
//    Employee tempEmployee = null;
//    String tempID;
//    String tempFirstName;
//    String tempLastName;
//    String tempGenderString;
//    GenderType tempGenderType;
//    String tempEmail;
//    String tempPhoneNumber;
//    String tempAddress;
//    String sql = "{ call usp_Login(?,?) }";
//    try (Connection connection = DatabaseConnection.getConnection();
//         CallableStatement statement = connection.prepareCall(sql))
//    {
//      statement.setString(1, username);
//      statement.setString(2, password);
//      try (ResultSet resultSet = statement.executeQuery())
//      {
//        while (resultSet.next())
//        {
//          tempID = resultSet.getString("employee_id");
//          tempFirstName = resultSet.getString("first_name");
//          tempLastName = resultSet.getString("last_name");
//          tempGenderString = resultSet.getString("gender");
//          if (tempGenderString.equalsIgnoreCase("m"))
//          {
//            tempGenderType = GenderType.MALE;
//          }
//          else
//          {
//            tempGenderType = GenderType.FEMALE;
//          }
//          tempEmail = resultSet.getString("email");
//          tempPhoneNumber = resultSet.getString("phone_number");
//          tempAddress = resultSet.getString("address");
//          tempEmployee = new Employee(tempID, tempFirstName,
//              tempLastName, tempGenderType,
//              tempEmail, tempPhoneNumber, tempAddress);
//        }
//      }
//    }
//    catch (SQLException e)
//    {
//      e.printStackTrace();
//    }
//    catch (IOException e)
//    {
//      e.printStackTrace();
//    }
//    return tempEmployee;
//  }
}

































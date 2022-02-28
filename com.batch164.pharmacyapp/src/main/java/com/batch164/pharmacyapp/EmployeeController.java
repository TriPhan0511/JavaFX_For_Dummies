package com.batch164.pharmacyapp;

import com.batch164.pharmacyapp.model.Employee;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Optional;

public class EmployeeController
{
  //  ------- Belows are the common fields and methods for every scene ----------
  @FXML
  private Button exitButton;
  @FXML
  private Button logoutButton;
  @FXML
  private Button profileButton;
  @FXML
  private Label welcomeLabel;

  @FXML
  void logoutButton_Click(ActionEvent event)
  {
//    TODO
    Alert alert = new Alert(Alert.AlertType.INFORMATION,
        "Under construction. Coming soon!");
    alert.show();
  }

  @FXML
  void profileButton_Click(ActionEvent event)
  {
//    TODO
    Alert alert = new Alert(Alert.AlertType.INFORMATION,
        "Under construction. Coming soon!");
    alert.show();
  }

  @FXML
  private void exitButton_Click(ActionEvent event)
  {
    Stage stage = (Stage) ((Node) event.getSource()).
        getScene().getWindow();
    stage.close();
  }

//  ----------------------------------------------------------------------------------

//  ------- Belows are the individual fields and methods for customer scene ----------

//  Table
  @FXML
  private TableView<Employee> employeeTableView;

//  Columns
  @FXML
  private TableColumn<Employee, String> idColumn;

  @FXML
  private TableColumn<Employee, String> firstNameColumn;
  @FXML
  void firstNameColumn_OnEditCommit(ActionEvent event)
  {

  }

  @FXML
  private TableColumn<Employee, String> lastNameColumn;
  @FXML
  void lastNameColumn_OnEditCommit(ActionEvent event)
  {

  }

  @FXML
  private TableColumn<Employee, String> genderColumn;

  @FXML
  private TableColumn<Employee, String> emailColumn;
  @FXML
  void emailColumn_OnEditCommit(ActionEvent event)
  {

  }

  @FXML
  private TableColumn<Employee, String> phoneNumberColumn;
  @FXML
  void phoneNumberNameColumn_OnEditCommit(ActionEvent event)
  {

  }

  @FXML
  private TableColumn<Employee, String> addressColumn;
  @FXML
  void addressNameColumn_OnEditCommit(ActionEvent event)
  {

  }

  @FXML
  private TableColumn<Employee, String> lockStatusColumn;
  @FXML
  void lockStatusColumn_OnEditCommit(ActionEvent event)
  {

  }
  @FXML
  private TableColumn<Employee, String> supervisorIDColumn;
  @FXML
  void supervisorIDColumn_OnEditCommit(ActionEvent event)
  {

  }
  @FXML
  private TableColumn<Employee, String> storeIDColumn;
  @FXML
  void storeIDColumn_OnEditCommit(ActionEvent event)
  {

  }

//  Buttons and event listeners
  @FXML
  private Button addButton;
  @FXML
  void addButton_Click(ActionEvent event)
  {

  }

  @FXML
  private Button deleteButton;
  @FXML
  void deleteButton_Click(ActionEvent event) {

  }

  @FXML
  private Button goBackButton;
  @FXML
  void goBackButton_Click(ActionEvent event) {

  }

  @FXML
  private Button saveButton;
  @FXML
  void saveButton_Click(ActionEvent event)
  {

  }

//  Labels
  @FXML
  private Label addressErrorLabel;
  @FXML
  private Label emailErrorLabel;
  @FXML
  private Label firstNameErrorLabel;
  @FXML
  private Label idErrorLabel;
  @FXML
  private Label lastNameErrorLabel;
  @FXML
  private Label phoneNumberErrorLabel;
  @FXML
  private Label zipCodeErrorLabel;

//  TextFields
  @FXML
  private TextField addressTextField;
  @FXML
  private TextField emailTextField;
  @FXML
  private TextField firstNameTextField;
  @FXML
  private TextField idTextField;
  @FXML
  private TextField lastNameTextField;
  @FXML
  private TextField phoneNumberTextField;
  @FXML
  private TextField zipCodeTextField;

  @FXML
  private TextField supervisorIDTextField;
  @FXML
  private TextField storeIDTextField;

//  RadioButtons and ToggleGroup
  @FXML
  private RadioButton maleRadioButton;
  @FXML
  private RadioButton femaleRadioButton;
  @FXML
  private ToggleGroup genderToggleGroup;

  @FXML
  private RadioButton unlockRadioButton;
  @FXML
  private RadioButton lockRadioButton;
  @FXML
  private ToggleGroup lockStatusToggleGroup;



}

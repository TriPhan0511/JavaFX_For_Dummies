package com.batch164.pharmacyapp;

import com.batch164.pharmacyapp.model.Customer;
import com.batch164.pharmacyapp.model.GenderType;
import com.batch164.pharmacyapp.utils.TextFieldHandler;
import com.batch164.pharmacyapp.utils.dao.CustomerDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerController implements Initializable
{

  //  Common  fields and methods
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
    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Under construction. Coming soon!");
    alert.show();
  }

  @FXML
  void profileButton_Click(ActionEvent event)
  {
    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Under construction. Coming soon!");
    alert.show();
  }

  @FXML
  private void exitButton_Click(ActionEvent event)
  {
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.close();
  }

//  Individual fields and methods
//  Buttons
  @FXML
  Button saveButton;

  @FXML
  Button addButton;
  @FXML
  Button deleteButton;

//  Text fields
  @FXML
  TextField idTextField;
  @FXML
  TextField firstNameTextField;
  @FXML
  TextField lastNameTextField;
  @FXML
  RadioButton maleRadioButton;
  @FXML
  RadioButton femaleRadioButton;
  @FXML
  TextField emailTextField;
  @FXML
  TextField phoneNumberTextField;
  @FXML
  TextField addressTextField;
  @FXML
  TextField zipCodeTextField;

//  Labels
  @FXML
  Label idErrorLabel;
  @FXML
  Label firstNameErrorLabel;
  @FXML
  Label lastNameErrorLabel;
  @FXML
  Label emailErrorLabel;
  @FXML
  Label phoneNumberErrorLabel;
  @FXML
  Label addressErrorLabel;
  @FXML
  Label zipCodeErrorLabel;

  //  Tableview
  @FXML
  TableView<Customer> customerTableView;

  //  Table Columns
  @FXML
  TableColumn<Customer, String> idColumn;
  @FXML
  TableColumn<Customer, String> firstNameColumn;
  @FXML
  TableColumn<Customer, String> lastNameColumn;
  @FXML
  TableColumn<Customer, String> genderColumn;
  @FXML
  TableColumn<Customer, String> emailColumn;
  @FXML
  TableColumn<Customer, String> phoneNumberColumn;
  @FXML
  TableColumn<Customer, String> addressColumn;
  @FXML
  TableColumn<Customer, String> zipCodeColumn;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle)
  {
//    Set data for the customer TableView
    customerTableView.setItems(CustomerDAO.getCustomers());

//    Set Multiple Selection Mode for the customer TableView
    customerTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

//    Set properties from the table's collection to the columns.
//    And create text fields in table columns (for editing purpose)
    idColumn.setCellValueFactory(
        new PropertyValueFactory<Customer, String>("id"));
    firstNameColumn.setCellValueFactory(
        new PropertyValueFactory<Customer, String>("firstName"));
    lastNameColumn.setCellValueFactory(
        new PropertyValueFactory<Customer, String>("lastName"));
    genderColumn.setCellValueFactory(
        new PropertyValueFactory<Customer, String>("gender"));
    emailColumn.setCellValueFactory(
        new PropertyValueFactory<Customer, String>("email"));
    phoneNumberColumn.setCellValueFactory(
        new PropertyValueFactory<Customer, String>("phoneNumber"));
    addressColumn.setCellValueFactory(
        new PropertyValueFactory<Customer, String>("address"));
    zipCodeColumn.setCellValueFactory(
        new PropertyValueFactory<Customer, String>("zipCode"));
  }

  @FXML
  private void saveButton_Click()
  {

  }

  @FXML
  private void addButton_Click()
  {
    Customer tempCustomer;
    String tempID = idTextField.getText().trim();
    String tempFirstName = firstNameTextField.getText().trim();
    String tempLastName = lastNameTextField.getText().trim();
    GenderType tempGenderType;
    if (maleRadioButton.isSelected())
    {
      tempGenderType = GenderType.MALE;
    }
    else
    {
      tempGenderType = GenderType.FEMALE;
    }
    String tempEmail = emailTextField.getText().trim();
    String tempPhoneNumber = phoneNumberTextField.getText().trim();
    String tempAddress = addressTextField.getText().trim();
    String tempZipCode = zipCodeTextField.getText().trim();
    tempCustomer = new Customer(tempID, tempFirstName,
        tempLastName, tempGenderType, tempEmail,
        tempPhoneNumber, tempAddress, tempZipCode);
    customerTableView.getItems().add(tempCustomer);

//    Clear the text fields
    TextFieldHandler.clearTextFields(idTextField,
        firstNameTextField, lastNameTextField,
        emailTextField, phoneNumberTextField,
        addressTextField, zipCodeTextField);

  }

  @FXML
  private void deleteButton_Click()
  {

  }
}























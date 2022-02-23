package com.batch164.pharmacyapp;

import com.batch164.pharmacyapp.model.Customer;
import com.batch164.pharmacyapp.model.GenderType;
import com.batch164.pharmacyapp.utils.TextFieldHandler;
import com.batch164.pharmacyapp.utils.dao.CustomerDAO;
import com.batch164.pharmacyapp.utils.validation.TextFieldValidation;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
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
//  -------------------------------------------------------------------------------------------------------

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
  public void initialize(URL url,
         ResourceBundle resourceBundle)
  {
//    Set data for the customer TableView
    customerTableView.setItems(CustomerDAO.getCustomers());

//    Set Multiple Selection Mode for the customer TableView
    customerTableView.getSelectionModel().
        setSelectionMode(SelectionMode.MULTIPLE);

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

//  Action Event Handler of the save button
  @FXML
  private void saveButton_Click()
  {
//    TODO
    Alert alert = new Alert(Alert.AlertType.INFORMATION,
        "Under construction. Coming soon!");
    alert.show();
  }

//  Action Event Handler of the add button and the text fields
  @FXML
  private void addButton_Click()
  {
    if (isValidTextFields())
    {
//      Create a Customer object from user's input
      Customer tempCustomer = createACustomer(
          idTextField, firstNameTextField,
          lastNameTextField, maleRadioButton,
          femaleRadioButton, emailTextField,
          phoneNumberTextField, addressTextField,
          zipCodeTextField);
//      Add the newly created Customer object to
//      the customer table's collection list.
      customerTableView.getItems().add(tempCustomer);
//      Clear all the text fields
      TextFieldHandler.clearTextFields(idTextField,
          firstNameTextField, lastNameTextField,
          emailTextField, phoneNumberTextField,
          addressTextField, zipCodeTextField);
    }
  }

//  Action Event Handler of the delete button
  @FXML
  private void deleteButton_Click()
  {
//    Get the list of selected Customer objects
    ObservableList<Customer> selectedItems =
        customerTableView.getSelectionModel().getSelectedItems();
//    Show an alert to ask the confirmation from the user
//    about the customers deleting
    String message;
    if (selectedItems.size() == 0)
    {
      message = "You should select the items you want to delete.";
      Alert alert = new Alert(Alert.AlertType.INFORMATION, message);
      alert.show();
    }
    else
    {
      message = selectedItems.size() == 1 ?
          "Are you sure you want to delete this item?" :
          "Are you sure you wan to delete these items?";
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
          message, ButtonType.YES, ButtonType.NO);
      Optional<ButtonType> response = alert.showAndWait();
      if (response.isPresent() && response.get() == ButtonType.YES)
      {
        customerTableView.getItems().removeAll(selectedItems);
      }
    }
  }

//  This method create a Customer object from user's input
  private Customer createACustomer(
      TextField idTextField, TextField firstNameTextField,
      TextField lastNameTextField, RadioButton maleRadioButton,
      RadioButton femaleRadioButton, TextField emailTextField,
      TextField phoneNumberTextField, TextField addressTextField,
      TextField zipCodeTextField)
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
    return tempCustomer;
  }

//  This method validates all the text fields on the scene
  private boolean isValidTextFields()
  {
    String blankErrorMessage = " This field is required.";

//    Validate the id text field
    if (!TextFieldValidation.isBlank(idTextField,
        idErrorLabel, blankErrorMessage))
    {
      idErrorLabel.setText("");
    }

//    Validate the first name text field
    if (!TextFieldValidation.isBlank(firstNameTextField,
        firstNameErrorLabel, blankErrorMessage))
    {
      firstNameErrorLabel.setText("");
    }

//    Validate the last name text field
    if (!TextFieldValidation.isBlank(lastNameTextField,
        lastNameErrorLabel, blankErrorMessage))
    {
      lastNameErrorLabel.setText("");
    }

//    Validate the email text field
    if (!TextFieldValidation.isBlank(emailTextField,
        emailErrorLabel, blankErrorMessage))
    {
      emailErrorLabel.setText("");
    }

//    Validate the phone number text field
    if (!TextFieldValidation.isBlank(phoneNumberTextField,
        phoneNumberErrorLabel, blankErrorMessage)
        && TextFieldValidation.isInteger(phoneNumberTextField,
        phoneNumberErrorLabel, "Invalid phone number."))
    {
      phoneNumberErrorLabel.setText("");
    }

//    Validate the address text field
    if (!TextFieldValidation.isBlank(addressTextField,
        addressErrorLabel, blankErrorMessage))
    {
      addressErrorLabel.setText("");
    }

//    Validate the zip code text field
    if (!TextFieldValidation.isBlank(zipCodeTextField,
        zipCodeErrorLabel, blankErrorMessage))
    {
      zipCodeErrorLabel.setText("");
    }

//    If all the text fields is valid, return true, otherwise return false
    if (idErrorLabel.getText().equals("")
        && firstNameErrorLabel.getText().equals("")
        && lastNameErrorLabel.getText().equals("")
        && emailErrorLabel.getText().equals("")
        && phoneNumberErrorLabel.getText().equals("")
        && addressErrorLabel.getText().equals("")
        && zipCodeErrorLabel.getText().equals(""))
    {
      return true;
    }
    return false;
  }
}























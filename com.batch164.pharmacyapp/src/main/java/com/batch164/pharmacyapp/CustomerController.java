
package com.batch164.pharmacyapp;

import com.batch164.pharmacyapp.model.Customer;
import com.batch164.pharmacyapp.model.GenderType;
import com.batch164.pharmacyapp.utils.TextFieldHandler;
import com.batch164.pharmacyapp.utils.dao.CustomerDAO;
import com.batch164.pharmacyapp.utils.validation.EmailTextFieldValidation;
import com.batch164.pharmacyapp.utils.validation.IDTextFieldValidation;
import com.batch164.pharmacyapp.utils.validation.TextFieldValidation;
import com.batch164.pharmacyapp.utils.validation.Validation;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

public class CustomerController implements Initializable
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

//  ------- Belows are the individual fields and methods for customer scene ----------

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
  private TableView<Customer> customerTableView;

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

//  Override the initialize method which
//  will be called after the constructor calling.
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

//    Note: The ID property should not be changed.
    idColumn.setCellValueFactory(
        new PropertyValueFactory<Customer, String>("id"));

    firstNameColumn.setCellValueFactory(
        new PropertyValueFactory<Customer, String>("firstName"));
    firstNameColumn.setCellFactory(
        TextFieldTableCell.forTableColumn());

    lastNameColumn.setCellValueFactory(
        new PropertyValueFactory<Customer, String>("lastName"));
    lastNameColumn.setCellFactory(
        TextFieldTableCell.forTableColumn());

    genderColumn.setCellValueFactory(
        new PropertyValueFactory<Customer, String>("gender"));

    emailColumn.setCellValueFactory(
        new PropertyValueFactory<Customer, String>("email"));
    emailColumn.setCellFactory(
        TextFieldTableCell.forTableColumn());

    phoneNumberColumn.setCellValueFactory(
        new PropertyValueFactory<Customer, String>("phoneNumber"));
    phoneNumberColumn.setCellFactory(
        TextFieldTableCell.forTableColumn());

    addressColumn.setCellValueFactory(
        new PropertyValueFactory<Customer, String>("address"));
    addressColumn.setCellFactory(
        TextFieldTableCell.forTableColumn());

    zipCodeColumn.setCellValueFactory(
        new PropertyValueFactory<Customer, String>("zipCode"));
    zipCodeColumn.setCellFactory(
        TextFieldTableCell.forTableColumn());
  }

//  ----------------- Belows are Event handlers -----------------------------

//  Action Event handler of the save button
  @FXML
  private void saveButton_Click()
  {
//    TODO
    Alert alert = new Alert(Alert.AlertType.INFORMATION,
        "Under construction. Coming soon!");
    alert.show();
  }

//  Action Event handler of the add button and the text fields
  @FXML
  private void addButton_Click()
  {
//    First, validate all the text fields
    if (isValidTextFields())
    {
//      Next, create a Customer object from user's input
      Customer tempCustomer = createACustomer(
          idTextField, firstNameTextField,
          lastNameTextField, maleRadioButton,
          femaleRadioButton, emailTextField,
          phoneNumberTextField, addressTextField,
          zipCodeTextField);
//      Then, add the newly created Customer object to
//      the customer table's collection list.
      customerTableView.getItems().add(tempCustomer);
//      Finally, clear all the text fields
      TextFieldHandler.clearTextFields(idTextField,
          firstNameTextField, lastNameTextField,
          emailTextField, phoneNumberTextField,
          addressTextField, zipCodeTextField);
    }
  }

//  Action Event handler of the delete button
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

  @FXML
  private void firstNameColumn_OnEditCommit(Event event)
  {
    TableColumn.CellEditEvent<Customer, String> cellEditEvent;
    cellEditEvent = (TableColumn.CellEditEvent<Customer, String>) event;
    Customer tempCustomer = cellEditEvent.getRowValue();
    tempCustomer.setFirstName(cellEditEvent.getNewValue());
  }

  @FXML
  private void lastNameColumn_OnEditCommit(Event event)
  {
    TableColumn.CellEditEvent<Customer, String> cellEditEvent;
    cellEditEvent = (TableColumn.CellEditEvent<Customer, String>) event;
    Customer tempCustomer = cellEditEvent.getRowValue();
    tempCustomer.setLastName(cellEditEvent.getNewValue());
  }

  @FXML
  private void emailColumn_OnEditCommit(Event event)
  {
    TableColumn.CellEditEvent<Customer, String> cellEditEvent;
    cellEditEvent = (TableColumn.CellEditEvent<Customer, String>) event;
    Customer tempCustomer = cellEditEvent.getRowValue();
    tempCustomer.setEmail(cellEditEvent.getNewValue());
  }

  @FXML
  private void phoneNumberNameColumn_OnEditCommit(Event event)
  {
    TableColumn.CellEditEvent<Customer, String> cellEditEvent;
    cellEditEvent = (TableColumn.CellEditEvent<Customer, String>) event;
    Customer tempCustomer = cellEditEvent.getRowValue();
    tempCustomer.setPhoneNumber(cellEditEvent.getNewValue());
  }

  @FXML
  private void addressNameColumn_OnEditCommit(Event event)
  {
    TableColumn.CellEditEvent<Customer, String> cellEditEvent;
    cellEditEvent = (TableColumn.CellEditEvent<Customer, String>) event;
    Customer tempCustomer = cellEditEvent.getRowValue();
    tempCustomer.setAddress(cellEditEvent.getNewValue());
  }

  @FXML
  private void zipCodeNameColumn_OnEditCommit(Event event)
  {
    TableColumn.CellEditEvent<Customer, String> cellEditEvent;
    cellEditEvent = (TableColumn.CellEditEvent<Customer, String>) event;
    Customer tempCustomer = cellEditEvent.getRowValue();
    tempCustomer.setZipCode(cellEditEvent.getNewValue());
  }


//  ----------------- Belows are helper methods -----------------------------

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

//    Validate the id text field:
//    Get the existing IDs
    ArrayList<String> existedIDs = new ArrayList<>();
    for (Customer item : customerTableView.getItems())
    {
      existedIDs.add(item.getId());
    }
//    Validate
    if (IDTextFieldValidation.validate(
        idTextField,
        idErrorLabel,
        existedIDs
    ))
    {
      idErrorLabel.setText("");
    }

//    Validate the first name text field:
    if (!TextFieldValidation.isBlank(firstNameTextField,
        firstNameErrorLabel, blankErrorMessage))
    {
      firstNameErrorLabel.setText("");
    }

//    Validate the last name text field:
    if (!TextFieldValidation.isBlank(lastNameTextField,
        lastNameErrorLabel, blankErrorMessage))
    {
      lastNameErrorLabel.setText("");
    }

//    Validate the email text field:
//    Get the existing email addresses
    ArrayList<String> existingEmails = new ArrayList<>();
    for (Customer item : customerTableView.getItems())
    {
      existingEmails.add(item.getEmail());
    }
//    Validate
    if (EmailTextFieldValidation.validate(emailTextField,
        emailErrorLabel, existingEmails))
    {
      emailErrorLabel.setText("");
    }


//    Validate the phone number text field:
    if (!TextFieldValidation.isBlank(phoneNumberTextField,
        phoneNumberErrorLabel, blankErrorMessage)
        && TextFieldValidation.isInteger(phoneNumberTextField,
        phoneNumberErrorLabel, "Invalid phone number."))
    {
      phoneNumberErrorLabel.setText("");
    }

//    Validate the address text field:
    if (!TextFieldValidation.isBlank(addressTextField,
        addressErrorLabel, blankErrorMessage))
    {
      addressErrorLabel.setText("");
    }

//    Validate the zip code text field:
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























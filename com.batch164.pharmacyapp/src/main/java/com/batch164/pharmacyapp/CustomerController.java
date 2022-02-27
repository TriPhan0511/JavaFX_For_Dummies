
package com.batch164.pharmacyapp;

import com.batch164.pharmacyapp.model.Customer;
import com.batch164.pharmacyapp.model.GenderType;
import com.batch164.pharmacyapp.utils.TextFieldHandler;
import com.batch164.pharmacyapp.utils.dao.CustomerDAO;
import com.batch164.pharmacyapp.utils.dao.DatabaseConnection;
import com.batch164.pharmacyapp.utils.validation.EmailTextFieldValidation;
import com.batch164.pharmacyapp.utils.validation.IDTextFieldValidation;
import com.batch164.pharmacyapp.utils.validation.TextFieldValidation;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
//  ------------------------------------------------------------

  //  Class fields
  private Connection connection;
  //  Class methods
//  The below method will be called at LoginDatabaseController (NOT YET)
//  to set database connection for the connection class field.
  public void setConnection(Connection connection)
  {
    this.connection = connection;
  }

////  Declare a temporary list to contain newly added customer
//  ObservableList<Customer> addedObservableList = FXCollections.observableArrayList();

  //  Declare a list to contain all employee from "customer" table in database
  List<Customer> originalListOfCustomers = new ArrayList<>();

  //  Declare a list to contain all employee's id from "customer" table in the database
  List<String> originalListOfIDs = new ArrayList<>();

  //  Declare a list to contain all employee's ids of the employee who be deleted.
  List<String> deletedListOfIDs = new ArrayList<>();

  //  Declare a list to contain all employees who be deleted.
  List<Customer> deletedListOfEmployees = new ArrayList<>();
//  -------------------------------------------------------------------------

  //  Helper method
//  private boolean isExisted(Customer item, List<Customer> originalListOfCustomers)
//  {
//    if (originalListOfCustomers.contains(item))
//    {
//      return true;
//    }
//    return false;
//  }

  private boolean isExisted(String id, List<String> originalListOfIDs)
  {
    if (originalListOfIDs.contains(id))
    {
      return true;
    }
    return false;
  }

//  private boolean isExisted(Customer item, List<String> originalListOfIDs)
//  {
//    if (originalListOfIDs.contains(item.getId()))
//    {
//      return true;
//    }
//    return false;
//  }

//  Override the initialize method which
//  will be called after the constructor calling.
  @Override
  public void initialize(URL url,
         ResourceBundle resourceBundle)
  {
//    Temporary connection
//    (Because I can not get connection from StaffController)
    try
    {
      connection = DatabaseConnection.getConnection2();
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

//    Get records from "customer" table in the database and add them to the
    for (Customer item : CustomerDAO.getCustomers(connection))
    {
      originalListOfCustomers.add(item);
    }

//    Get all of employee's ids from "customer" table in the database and add them to the
    for (Customer item : CustomerDAO.getCustomers(connection))
    {
      originalListOfIDs.add(item.getId());
    }

//    Customer TableView
//    Set data for the customer TableView
    customerTableView.setItems(CustomerDAO.getCustomers(connection));

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
////    Way 1:
////    Delete all records in the "customer" table in the database
////    Then add new records from the customer tableview to the "customer" table in the database
//    CustomerDAO.deleteAllRecordsInCustomerTable(connection);
//    CustomerDAO.saveCustomersToDatabase(customerTableView.getItems(), connection);

////    Way 2:
////    Check each item in the customer table's collection list:
////      1. If the item's id exists in the originalListOfIDs:
////          Update the item to the "customer" table
////      2. If the item's id does not exist in the originalListOfIDs:
////          Insert the item to the "customer" table
//    for (Customer item : customerTableView.getItems())
//    {
//      if (isExisted(item.getId(), originalListOfIDs))
//      {
//        CustomerDAO.updateEmployee(item, connection);
//      }
//      else
//      {
//        CustomerDAO.insertACustomerToDatabase(item, connection);
//      }
//    }

//    Way 3:
//    1. Check each item's id in deletedListOfIDs:
//      If it does not exist in the customer table's collection list:
//        Delete the item from the "customer" table in the database.
//    2. Check each item in the customer table's collection list:
//      2.1 If the item's id exists in the originalListOfIDs:
//            Update the item to the "customer" table.
//      2.2 If the item's id does not exist in the originalListOfIDs:
//            Insert the item to the "customer" table.

//    Step 1:
//    Get list of IDs in the table's collection list
    List<String> idsInTable = new ArrayList<>();
    for (Customer item : customerTableView.getItems())
    {
      idsInTable.add(item.getId());
    }

//    Check
    for (String id : deletedListOfIDs)
    {
      if (!isExisted(id, idsInTable))
      {
        CustomerDAO.deleteACustomerBasedOnID(id, connection);
      }
    }

//    Step 2:
    for (Customer item : customerTableView.getItems())
    {
      if (isExisted(item.getId(), originalListOfIDs))
      {
        System.out.println("existed");
        CustomerDAO.updateEmployee(item, connection);
      }
      else
      {
        System.out.println("NOT existed");
        CustomerDAO.insertACustomerToDatabase(item, connection);
      }
    }

    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Saved");
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

////      Add the newly created Customer object to
////      the temporary list
////      TODO
//      addedObservableList.add(tempCustomer);

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
//        Add selected items' id to the deletedListOfIDs
        for (Customer item : selectedItems)
        {
          deletedListOfIDs.add(item.getId());
        }

//        Add selected items to the deletedListOfCustomers
        for (Customer item : selectedItems)
        {
          deletedListOfEmployees.add(item);
        }

//        Delete the selected item from customer table's collection list.
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






//  Helper method


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
//    Check if the ID exists
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























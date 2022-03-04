
package com.batch164.pharmacyapp;

import com.batch164.pharmacyapp.model.Customer;
import com.batch164.pharmacyapp.model.GenderType;
import com.batch164.pharmacyapp.utils.Clearing;
import com.batch164.pharmacyapp.utils.dao.CustomerDAO;
import com.batch164.pharmacyapp.utils.dao.DatabaseConnection;
import com.batch164.pharmacyapp.utils.scenehandler.SceneHandler;
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
    if (isDataChanged)
    {
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
          "Dou you want to save the changes?",
          ButtonType.YES, ButtonType.NO);
      Optional<ButtonType> response = alert.showAndWait();
      if (response.isPresent() && response.get() == ButtonType.YES)
      {
        saveToDatabase(customerTableView, deletedListOfIDs,
            originalListOfIDs, connection);
      }
    }
    Stage stage = (Stage) ((Node) event.getSource()).
        getScene().getWindow();
    stage.close();
  }

//  ----------------------------------------------------------------------------------

//  ------- Belows are the individual fields and methods for customer scene ----------

//  Buttons
  @FXML
  private Button saveButton;
  @FXML
  private Button addButton;
  @FXML
  private Button deleteButton;
  @FXML
  private Button goBackButton;

//  Text fields
  @FXML
  private TextField idTextField;
  @FXML
  private TextField firstNameTextField;
  @FXML
  private TextField lastNameTextField;
  @FXML
  private RadioButton maleRadioButton;
  @FXML
  private RadioButton femaleRadioButton;
  @FXML
  private TextField emailTextField;
  @FXML
  private TextField phoneNumberTextField;
  @FXML
  private TextField addressTextField;
  @FXML
  private TextField zipCodeTextField;

//  Labels
  @FXML
  private Label idErrorLabel;
  @FXML
  private Label firstNameErrorLabel;
  @FXML
  private Label lastNameErrorLabel;
  @FXML
  private Label emailErrorLabel;
  @FXML
  private Label phoneNumberErrorLabel;
  @FXML
  private Label addressErrorLabel;
  @FXML
  private Label zipCodeErrorLabel;

  //  Tableview
  @FXML
  private TableView<Customer> customerTableView;

  //  Table Columns
  @FXML
  private TableColumn<Customer, String> idColumn;
  @FXML
  private TableColumn<Customer, String> firstNameColumn;
  @FXML
  private TableColumn<Customer, String> lastNameColumn;
  @FXML
  private TableColumn<Customer, String> genderColumn;
  @FXML
  private TableColumn<Customer, String> emailColumn;
  @FXML
  private TableColumn<Customer, String> phoneNumberColumn;
  @FXML
  private TableColumn<Customer, String> addressColumn;
  @FXML
  private TableColumn<Customer, String> zipCodeColumn;

//  Event handlers for columns
  @FXML
  private void firstNameColumn_OnEditCommit(Event event)
  {
    TableColumn.CellEditEvent<Customer, String> cellEditEvent;
    cellEditEvent = (TableColumn.CellEditEvent<Customer, String>) event;
    Customer tempCustomer = cellEditEvent.getRowValue();
    tempCustomer.setFirstName(cellEditEvent.getNewValue());

//    Finally, notify the data has changed.
    isDataChanged = true;
  }

  @FXML
  private void lastNameColumn_OnEditCommit(Event event)
  {
    TableColumn.CellEditEvent<Customer, String> cellEditEvent;
    cellEditEvent = (TableColumn.CellEditEvent<Customer, String>) event;
    Customer tempCustomer = cellEditEvent.getRowValue();
    tempCustomer.setLastName(cellEditEvent.getNewValue());

//    Finally, notify the data has changed.
    isDataChanged = true;
  }

  @FXML
  private void emailColumn_OnEditCommit(Event event)
  {
    TableColumn.CellEditEvent<Customer, String> cellEditEvent;
    cellEditEvent = (TableColumn.CellEditEvent<Customer, String>) event;
    Customer tempCustomer = cellEditEvent.getRowValue();
    tempCustomer.setEmail(cellEditEvent.getNewValue());

//    Finally, notify the data has changed.
    isDataChanged = true;
  }

  @FXML
  private void phoneNumberNameColumn_OnEditCommit(Event event)
  {
    TableColumn.CellEditEvent<Customer, String> cellEditEvent;
    cellEditEvent = (TableColumn.CellEditEvent<Customer, String>) event;
    Customer tempCustomer = cellEditEvent.getRowValue();
    tempCustomer.setPhoneNumber(cellEditEvent.getNewValue());

//    Finally, notify the data has changed.
    isDataChanged = true;
  }

  @FXML
  private void addressNameColumn_OnEditCommit(Event event)
  {
    TableColumn.CellEditEvent<Customer, String> cellEditEvent;
    cellEditEvent = (TableColumn.CellEditEvent<Customer, String>) event;
    Customer tempCustomer = cellEditEvent.getRowValue();
    tempCustomer.setAddress(cellEditEvent.getNewValue());

//    Finally, notify the data has changed.
    isDataChanged = true;
  }

  @FXML
  private void zipCodeNameColumn_OnEditCommit(Event event)
  {
    TableColumn.CellEditEvent<Customer, String> cellEditEvent;
    cellEditEvent = (TableColumn.CellEditEvent<Customer, String>) event;
    Customer tempCustomer = cellEditEvent.getRowValue();
    tempCustomer.setZipCode(cellEditEvent.getNewValue());

//    Finally, notify the data has changed.
    isDataChanged = true;
  }
//  ------------------------------------------------------------

  //  Class fields
  private Connection connection;
//  !IMPORTANT
//  (NOT YET, WE HAVE TO INITIALIZE THE DATABASE CONNECTION IN THE initialize method,
//  via DatabaseConnection.getConnection2)
//  The below method will be called at LoginDatabaseController
//  to set database connection for the connection class field.
  public void setConnection(Connection connection)
  {
    this.connection = connection;
  }

  //  Declare a ObservableList object to contain all Customer objects fetched from the database.
  //  (via CustomerDAO.getCustomers())
  ObservableList<Customer> customerObservableList;

  //  Declare a list to contain all employee's id from "customer" table in the database
  List<String> originalListOfIDs = new ArrayList<>();

  //  Declare a list to contain all employee's ids of the employee who be deleted.
  List<String> deletedListOfIDs = new ArrayList<>();

  //  Declare a flag to notify when the data is changed
  private boolean isDataChanged = false;

//  -------------------------------------------------------------------------



  @Override
  public void initialize(URL url, ResourceBundle resourceBundle)
  {
//    Initialize the database connection
//    (via DatabaseConnection.getConnection2 method)
    try
    {
//      connection = DatabaseConnection.getConnection2();
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

// Initialize the customerObservableList
    customerObservableList = CustomerDAO.getCustomers(connection);

//    Get all of customer's ids from "customer" table in the database and add them to the
    for (Customer item : customerObservableList)
    {
      originalListOfIDs.add(item.getId());
    }

//    Set data for the customer TableView
    customerTableView.setItems(customerObservableList);

//    Set Multiple Selection Mode for the customer TableView
    customerTableView.getSelectionModel().
        setSelectionMode(SelectionMode.MULTIPLE);

//    Set properties from the table's collection to the columns.
//    And create text fields in table columns (for editing purpose)

//    Set data for the columns
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
  if (isDataChanged)
  {
    saveToDatabase(customerTableView, deletedListOfIDs,
        originalListOfIDs, connection);
    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Saved");
    alert.show();

//    Set the flag isDataChanged to false
    isDataChanged = false;
  }
  else
  {
    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Nothing has changed.");
    alert.show();
  }
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
//      the customer table's data.
      customerTableView.getItems().add(tempCustomer);
//      Then, clear all the text fields
      Clearing.clearTextFields(idTextField,
          firstNameTextField, lastNameTextField,
          emailTextField, phoneNumberTextField,
          addressTextField, zipCodeTextField);

//      Finally, notify the data has changed.
      isDataChanged = true;
    }
  }

  @FXML
  private void goBackButton_Click(ActionEvent event) throws IOException
  {
    SceneHandler.switchScene("staff-view.fxml", event);

//    FXMLLoader loader = new FXMLLoader(getClass().getResource("staff-view.fxml"));
//    Parent root = loader.load();
//    Scene staffScene = new Scene(root);
//    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//    stage.setScene(staffScene);
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

//        Delete the selected item from customer table's data.
        customerTableView.getItems().removeAll(selectedItems);

//        Finally, notify the data has changed.
        isDataChanged = true;
      }
    }
  }

//  ----------------- Belows are helper methods -----------------------------

////  This method used to save data to the database (Way 2)
////  DO NOT DELETE
////  Way 2: CASE: DO NOT USE THE "Delete" BUTTON
//  private void saveToDatabase2(TableView<Customer> customerTableView,
//                               List<String> originalListOfIDs,
//                               Connection connection)
//  {
//    //    Way 2: CASE: DO NOT USE THE "Delete" BUTTON
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
//  }

  //  This method used to save data to the database (Way 1)
//  CASE : Use the Delete button.
  private void saveToDatabase(TableView<Customer> customerTableView,
                              List<String> deletedListOfIDs,
                              List<String> originalListOfIDs,
                              Connection connection)
  {
    //    Way 1:
//    1. Check each item's id in deletedListOfIDs:
//      If it DOES NOT exist in a list contains all ids in the table's data.
//        Delete the item from the "customer" table in the database.
//    2. Check each item in the customer table's data:
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
        CustomerDAO.updateEmployee(item, connection);
      }
      else
      {
        CustomerDAO.insertACustomerToDatabase(item, connection);
      }
    }
  }

  //  This method checks whether an id exists in a list or not.
  private boolean isExisted(String id, List<String> originalListOfIDs)
  {
    if (originalListOfIDs.contains(id))
    {
      return true;
    }
    return false;
  }

//  This method creates a Customer object from user's input
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

//  Helper method
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























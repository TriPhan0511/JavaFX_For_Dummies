package com.batch164.pharmacyapp;

import com.batch164.pharmacyapp.model.Employee;
import com.batch164.pharmacyapp.model.GenderType;
import com.batch164.pharmacyapp.model.Store;
import com.batch164.pharmacyapp.utils.Clearing;
import com.batch164.pharmacyapp.utils.dao.DatabaseConnection;
import com.batch164.pharmacyapp.utils.dao.EmployeeDAO;
import com.batch164.pharmacyapp.utils.dao.StoreDAO;
import com.batch164.pharmacyapp.utils.scenehandler.SceneHandler;
import com.batch164.pharmacyapp.utils.validation.ComboBoxValidation;
import com.batch164.pharmacyapp.utils.validation.EmailTextFieldValidation;
import com.batch164.pharmacyapp.utils.validation.IDTextFieldValidation;
import com.batch164.pharmacyapp.utils.validation.TextFieldValidation;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable
{
  //  ------- Belows are the common fields and methods for every scene ----------
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
  private Button goBackButton;
  @FXML
  void goBackButton_Click(ActionEvent event) throws IOException
  {
    SceneHandler.switchScene("manager-view.fxml", event);
  }
//  ----------------------------------------------------------------------------------

//  ------- Belows are the individual fields and methods for customer scene ----------

//  Table
  @FXML
  private TableView<Employee> employeeTableView;
  @FXML
  private void employeeTableView_Click()
  {
    Employee selectedEmployee =
        employeeTableView.getSelectionModel().getSelectedItem();
    setInformationForFields(selectedEmployee, idTextField,
        firstNameTextField, lastNameTextField,
        maleRadioButton, femaleRadioButton,
        emailTextField, phoneNumberTextField,
        addressTextField, lockRadioButton,
        unlockRadioButton, storeIDComboBox,
        supervisorIDComboBox, connection);
  }

//  Columns
  @FXML
  private TableColumn<Employee, String> idColumn;
  @FXML
  private TableColumn<Employee, String> firstNameColumn;
  @FXML
  private TableColumn<Employee, String> lastNameColumn;
  @FXML
  private TableColumn<Employee, String> genderColumn;
  @FXML
  private TableColumn<Employee, String> emailColumn;
  @FXML
  private TableColumn<Employee, String> phoneNumberColumn;
  @FXML
  private TableColumn<Employee, String> addressColumn;
  @FXML
  private TableColumn<Employee, String> lockStatusColumn;
  @FXML
  private TableColumn<Employee, String> supervisorColumn;
  @FXML
  private TableColumn<Employee, String> storeColumn;

  //  Buttons and event listeners
  @FXML
  private Button addOrUpdateButton;
  @FXML
  private void addOrUpdateButton_Click()
  {
//    Get the id from user's input
    String inputID = idTextField.getText().trim();
//    Get all existed ids in the table's data
    List<String> ids = new ArrayList<>();
    for (Employee item : employeeTableView.getItems())
    {
      ids.add(item.getId());
    }
//    Get index of the input id
    int index = indexOfAString(inputID, ids);

//    If the input id has existed in the table's data,
//    update the table row contains the input id.
//    If the input id has not existed in the table's data,
//    add a new row to the table.
    if (index != -1)
    {
      if (isValidTextFieldsForUpdating(
          firstNameTextField, firstNameErrorLabel,
          lastNameTextField, lastNameErrorLabel,
          emailTextField, emailErrorLabel,
          phoneNumberTextField, phoneNumberErrorLabel,
          addressTextField, addressErrorLabel,
          "This field is required."
      ))
      {
        Employee tempEmployee = createAnEmployeeFromUserInput(
            idTextField, firstNameTextField,lastNameTextField,
            maleRadioButton, emailTextField, phoneNumberTextField,
            addressTextField, unlockRadioButton, storeIDComboBox,
            supervisorIDComboBox, connection);
        updateARow(employeeTableView, index, tempEmployee);
        //    Reset text fields and combo boxes
        resetButton_Click();
        //    Notify the data has changed.
        isDataChanged = true;
      }

    }
    else
    {
      if (isValidFieldsForAdding(
          employeeTableView,
          idTextField, idErrorLabel,
          firstNameTextField, firstNameErrorLabel,
          lastNameTextField, lastNameErrorLabel,
          emailTextField, emailErrorLabel,
          phoneNumberTextField, phoneNumberErrorLabel,
          addressTextField, addressErrorLabel,
          storeIDComboBox, storeIDErrorLabel,
          supervisorIDComboBox, supervisorIDErrorLabel
      ))
      {
        Employee tempEmployee = createAnEmployeeFromUserInput(
            idTextField, firstNameTextField,lastNameTextField,
            maleRadioButton, emailTextField, phoneNumberTextField,
            addressTextField, unlockRadioButton, storeIDComboBox,
            supervisorIDComboBox, connection);
        addANewRow(employeeTableView, tempEmployee);
        //    Reset text fields and combo boxes
        resetButton_Click();
        //   Notify the data has changed.
        isDataChanged = true;
      }

    }

  }

//  Helper method
  private void addANewRow(TableView<Employee> employeeTableView,
                          Employee tempEmployee)
  {
    employeeTableView.getItems().add(tempEmployee);
  }

  //  Helper method
  private void updateARow(TableView<Employee> employeeTableView,
                          int index, Employee tempEmployee)
  {
    employeeTableView.getItems().set(index, tempEmployee);
  }

  @FXML
  private Button resetButton;
  @FXML
  private void resetButton_Click()
  {
//    Clear all text fields
    Clearing.clearTextFields(idTextField,
        firstNameTextField, lastNameTextField, emailTextField,
        phoneNumberTextField, addressTextField);
//    Clear all labels
    Clearing.clearLabels(idErrorLabel, firstNameErrorLabel,
        lastNameErrorLabel, emailErrorLabel,
        phoneNumberErrorLabel, addressErrorLabel);
//    Set data for the supervisorIDComboBox
    String currentStoreID = storeIDComboBox.getValue();
    supervisorIDObservableList =
        EmployeeDAO.getSupervisorIDsBaseOnStoreID(
            connection, currentStoreID);
    supervisorIDComboBox.setItems(supervisorIDObservableList);
//    Set first value for supervisorIDComboBox
    supervisorIDComboBox.setValue("");
  }

  @FXML
  private Button saveButton;
  @FXML
  private void saveButton_Click()
  {
    if (isDataChanged)
    {
      saveToDatabase(employeeTableView, originalListOfIDs, connection);
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
  private Label storeIDErrorLabel;
  @FXML
  private Label supervisorIDErrorLabel;

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

  //  ComboBoxes
  @FXML
  private ComboBox<String> supervisorIDComboBox;

  @FXML
  private ComboBox<String> storeIDComboBox;

  @FXML
  private void storeIDComboBox_Change()
  {
    String currentStoreID = storeIDComboBox.getValue();
//    Set data for the supervisorIDComboBox
    supervisorIDObservableList =
        EmployeeDAO.getSupervisorIDsBaseOnStoreID(
            connection, currentStoreID);
    supervisorIDComboBox.setItems(supervisorIDObservableList);
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle)
  {
//    Initialize the database connection
    try
    {
      connection = DatabaseConnection.getConnection();
    } catch (SQLException e)
    {
      e.printStackTrace();
    } catch (IOException e)
    {
      e.printStackTrace();
    }
//    Set data for the table
    employeeObservableList = EmployeeDAO.getEmployees(connection);
    employeeTableView.setItems(employeeObservableList);
//    Set data for columns
    idColumn.setCellValueFactory(
        new PropertyValueFactory<Employee, String>("id"));
    firstNameColumn.setCellValueFactory(
        new PropertyValueFactory<Employee, String>("firstName"));
    lastNameColumn.setCellValueFactory(
        new PropertyValueFactory<Employee, String>("lastName"));
    genderColumn.setCellValueFactory(
        new PropertyValueFactory<Employee, String>("gender"));
    emailColumn.setCellValueFactory(
        new PropertyValueFactory<Employee, String>("email"));
    phoneNumberColumn.setCellValueFactory(
        new PropertyValueFactory<Employee, String>("phoneNumber"));
    addressColumn.setCellValueFactory(
        new PropertyValueFactory<Employee, String>("address"));
    lockStatusColumn.setCellValueFactory(
        new PropertyValueFactory<Employee, String>("locked"));
    supervisorColumn.setCellValueFactory(
        new PropertyValueFactory<Employee, String>("supervisor"));
    storeColumn.setCellValueFactory(
        new PropertyValueFactory<Employee, String>("store"));

//    Set data for the storeIDComboBox
    storeIDStringObservableList = StoreDAO.getStoreIDs(connection);
    storeIDComboBox.setItems(storeIDStringObservableList);

//    Get all of employee's ids from "customer" table in the database and add them to the
    for (Employee item : employeeObservableList)
    {
      originalListOfIDs.add(item.getId());
    }
  }

//  Helper method
//  This method check whether a string is contained within a list or not.
//  If the string is contained within a list, return the index of that string within the list
//  Otherwise, return -1.
  private int indexOfAString(String string, List<String> list)
  {
    for (int i = 0; i < list.size(); i++)
    {
      if (list.get(i).equalsIgnoreCase(string))
      {
        return i;
      }
    }
    return -1;
  }



//  Helper method
@FXML
private void setInformationForFields(
    Employee selectedEmployee, TextField idTextField,
    TextField firstNameTextField, TextField lastNameTextField,
    RadioButton maleRadioButton, RadioButton femaleRadioButton,
    TextField emailTextField, TextField phoneNumberTextField,
    TextField addressTextField, RadioButton lockRadioButton,
    RadioButton unlockRadioButton, ComboBox<String> storeIDComboBox,
    ComboBox<String> supervisorIDComboBox, Connection connection)
{
  idTextField.setText(selectedEmployee.getId());
  firstNameTextField.setText(selectedEmployee.getFirstName());
  lastNameTextField.setText(selectedEmployee.getLastName());
  if (selectedEmployee.getGender() == GenderType.MALE)
  {
    maleRadioButton.setSelected(true);
  }
  else
  {
    femaleRadioButton.setSelected(true);
  }
  emailTextField.setText(selectedEmployee.getEmail());
  phoneNumberTextField.setText(selectedEmployee.getPhoneNumber());
  addressTextField.setText(selectedEmployee.getAddress());
  if (selectedEmployee.isLocked())
  {
    lockRadioButton.setSelected(true);
  }
  else
  {
    unlockRadioButton.setSelected(true);
  }
  storeIDComboBox.setValue(selectedEmployee.getStore().getStoreID());
  Employee temSupervisor = selectedEmployee.getSupervisor();
  if (temSupervisor == null)
  {
    supervisorIDComboBox.setValue("");
  }
  else
  {
    supervisorIDComboBox.setValue(temSupervisor.getId());
  }

//  Set the data for supervisorIDComboBox
  ObservableList<String> observableList =
      EmployeeDAO.getSupervisorIDsBaseOnStoreID(
          connection, storeIDComboBox.getValue());

  if (selectedEmployee != null)
  {
    String tempID = selectedEmployee.getId();
    int index = indexOfAString(tempID, observableList);
    if (index != -1)
    {
      observableList.remove(index);
    }
  }
  supervisorIDComboBox.setItems(observableList);
}

//  Class fields
//  Database connection
  private Connection connection;
//  Declare a variable that hols the data for the table
  ObservableList<Employee> employeeObservableList;
//  Declare a variable that hols the data for the storeIDComboBox
  ObservableList<String> storeIDStringObservableList;

//  Declare a variable that hols the data for the supervisorIDComboBox
  ObservableList<String> supervisorIDObservableList;

//  Declare a list to contain all employee's id from "customer" table in the database
  List<String> originalListOfIDs = new ArrayList<>();

//  Declare a flag to notify when the data is changed
  private boolean isDataChanged = false;

//  ----------------------------------------------------------------------------------------

//  ----------------- Belows are helper methods -----------------------------

  //  Helper method
//  This method validates all the text fields on the scene
  private boolean isValidTextFieldsForUpdating(
      TextField firstNameTextField, Label firstNameErrorLabel,
      TextField lastNameTextField, Label lastNameErrorLabel,
      TextField emailTextField, Label emailErrorLabel,
      TextField phoneNumberTextField, Label phoneNumberErrorLabel,
      TextField addressTextField, Label addressErrorLabel,
      String blankErrorMessage
  )
  {
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
//    and the existing ids
    ArrayList<String> existingEmails = new ArrayList<>();
    ArrayList<String> existingIDs = new ArrayList<>();
    for (Employee item : employeeTableView.getItems())
    {
      existingEmails.add(item.getEmail());
      existingIDs.add(item.getId());
    }

    String tempID = idTextField.getText().trim();
    int index = indexOfAString(tempID, existingIDs);
    if (index != -1)
    {
      existingEmails.remove(index);
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

//    If all the text fields is valid, return true, otherwise return false
    if (
        firstNameErrorLabel.getText().equals("")
        && lastNameErrorLabel.getText().equals("")
        && emailErrorLabel.getText().equals("")
        && phoneNumberErrorLabel.getText().equals("")
        && addressErrorLabel.getText().equals(""))
    {
      return true;
    }
    return false;
  }

//  Helper method
//  This method validates all the fields on the scene
  private boolean isValidFieldsForAdding(
      TableView<Employee> employeeTableView,
      TextField idTextField, Label idErrorLabel,
      TextField firstNameTextField, Label firstNameErrorLabel,
      TextField lastNameTextField, Label lastNameErrorLabel,
      TextField emailTextField, Label emailErrorLabel,
      TextField phoneNumberTextField, Label phoneNumberErrorLabel,
      TextField addressTextField, Label addressErrorLabel,
      ComboBox<String> storeIDComboBox, Label storeIDErrorLabel,
      ComboBox<String> supervisorIDComboBox, Label supervisorIDErrorLabel
  )
  {
    String blankErrorMessage = " This field is required.";

//    Validate the id text field:
//    Get the existing IDs
    ArrayList<String> existedIDs = new ArrayList<>();
    for (Employee item : employeeTableView.getItems())
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
    for (Employee item : employeeTableView.getItems())
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

//    Validate the storeIDComboBox
    if (!ComboBoxValidation.isBlank(storeIDComboBox,
        storeIDErrorLabel, "Please choose a store's id"))
    {
      storeIDErrorLabel.setText("");
    }

//    Validate the supervisorIDComboBox
    if (!ComboBoxValidation.isBlank(supervisorIDComboBox,
        supervisorIDErrorLabel, "Please choose a supervisor's id."))
    {
      supervisorIDErrorLabel.setText("");
    }

//    If all the text fields is valid, return true, otherwise return false
    if (idErrorLabel.getText().equals("")
        && firstNameErrorLabel.getText().equals("")
        && lastNameErrorLabel.getText().equals("")
        && emailErrorLabel.getText().equals("")
        && phoneNumberErrorLabel.getText().equals("")
        && addressErrorLabel.getText().equals("")
        && storeIDErrorLabel.getText().equals("")
        && supervisorIDErrorLabel.getText().equals("")
    )
    {
      return true;
    }
    return false;
  }

//  Helper method
//  This method creates an Employee object from user's input
  private Employee createAnEmployeeFromUserInput(
      TextField idTextField,
      TextField firstNameTextField, TextField lastNameTextField,
      RadioButton maleRadioButton,
      TextField emailTextField,TextField phoneNumberTextField,
      TextField addressTextField,RadioButton unlockRadioButton,
      ComboBox<String> storeIDComboBox, ComboBox<String> supervisorIDComboBox,
      Connection connection
      )
  {
    String tempID;
    String tempFirstName;
    String tempLastName;
    GenderType tempGenderType;
    String tempEmail;
    String tempPhoneNumber;
    String tempAddress;
    boolean tempLockStatus;
    Store tempStore;
    String tempStoreID;
    Employee tempSupervisor;
    String tempSupervisorID;

    Employee tempEmployee;
    tempID = idTextField.getText().trim();
    tempFirstName = firstNameTextField.getText().trim();
    tempLastName = lastNameTextField.getText().trim();

    if (maleRadioButton.isSelected())
    {
      tempGenderType = GenderType.MALE;
    }
    else
    {
      tempGenderType = GenderType.FEMALE;
    }
    tempEmail = emailTextField.getText().trim();
    tempPhoneNumber = phoneNumberTextField.getText().trim();
    tempAddress = addressTextField.getText().trim();
    if (unlockRadioButton.isSelected())
    {
      tempLockStatus = false;
    }
    else
    {
      tempLockStatus = true;
    }
    tempStoreID = storeIDComboBox.getValue();
    tempStore = StoreDAO.getAStore(connection, tempStoreID);
    tempSupervisorID = supervisorIDComboBox.getValue();
    tempSupervisor = EmployeeDAO.getAnEmployee(connection, tempSupervisorID);

//    Create an Employee object
    tempEmployee = new Employee(tempID, tempFirstName,
        tempLastName, tempGenderType, tempEmail,
        tempPhoneNumber, tempAddress);
//    Set lock status, store and supervisor for newly created Employee object.
    tempEmployee.setLocked(tempLockStatus);
    tempEmployee.setStore(tempStore);
    tempEmployee.setSupervisor(tempSupervisor);

    return tempEmployee;
  }

//  Helper method
//  This method used to save data to the database (Way 2)
//  DO NOT DELETE
//  CASE: DO NOT USE THE "Delete" BUTTON
  private void saveToDatabase(TableView<Employee> employeeTableView,
                              List<String> originalListOfIDs,
                              Connection connection)
  {
    //    Way 2: CASE: DO NOT USE THE "Delete" BUTTON
//    Check each item in the employee table's collection list:
//      1. If the item's id exists in the originalListOfIDs:
//          Update the item to the "employee" table
//      2. If the item's id does not exist in the originalListOfIDs:
//          Insert the item to the "employee" table
    for (Employee item : employeeTableView.getItems())
    {
      if (isExisted(item.getId(), originalListOfIDs))
      {
//        Testing
        System.out.println(item);
        System.out.println(item.getStore().getStoreID());
        EmployeeDAO.updateEmployee(item, connection);
      }
      else
      {
        EmployeeDAO.insertAnEmployeeToDatabase(item, connection);
      }
    }
  }

//  Helper method
//  This method checks whether an id exists in a list or not.
private boolean isExisted(String id, List<String> originalListOfIDs)
{
  if (originalListOfIDs.contains(id))
  {
    return true;
  }
  return false;
}
}































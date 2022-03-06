package com.batch164.pharmacyapp;

import com.batch164.pharmacyapp.model.*;
import com.batch164.pharmacyapp.utils.Clearing;
import com.batch164.pharmacyapp.utils.dao.DatabaseConnection;
import com.batch164.pharmacyapp.utils.dao.SupplierDAO;
import com.batch164.pharmacyapp.utils.scenehandler.SceneHandler;
import com.batch164.pharmacyapp.utils.validation.EmailTextFieldValidation;
import com.batch164.pharmacyapp.utils.validation.IDTextFieldValidation;
import com.batch164.pharmacyapp.utils.validation.TextFieldValidation;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import java.util.Optional;
import java.util.ResourceBundle;

public class SupplierController implements Initializable, InformationDisplayable
{
  @FXML
  private Label welcomeLabel;
  @FXML
  private Label currentStoreLabel;

  private Employee currentUser;
  private Store currentStore;

  @Override
  public void setCurrentUser(Employee currentUser)
  {
    this.currentUser = currentUser;
  }

  @Override
  public void setCurrentStore(Store currentStore)
  {
    this.currentStore = currentStore;
  }

  @Override
  public void displayWelcomeMessage()
  {
    welcomeLabel.setText("Welcome, " + currentUser.getFullName() + " (supervisor)!");
  }

  @Override
  public void displayCurrentStore()
  {
    currentStoreLabel.setText("You are in " + currentStore.getStoreName() + ".");
  }
//  -------------------------------------------------------------------------------------------------

  @FXML
  private Button exitButton;
  @FXML
  private void exitButton_Click(ActionEvent event)
  {
    if (isDataChanged)
    {
      Alert alert = new Alert(Alert.AlertType.WARNING,
          "Something has changed.\nDo you want to save the changes?",
          ButtonType.YES, ButtonType.NO);
      Optional<ButtonType> response = alert.showAndWait();
      if (response.isPresent() && response.get() == ButtonType.YES)
      {
        saveToDatabase(table, addedIDs, updatedIDs, connection);
      }
    }
    Stage stage = (Stage) ((Node) event.getSource()).
        getScene().getWindow();
    stage.close();
  }

  @FXML
  private Button goBackButton;
  @FXML
  void goBackButton_Click(ActionEvent event) throws IOException
  {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("supervisor-view.fxml"));
    SceneHandler.setInformationAndSwitchScene(loader, currentStore, currentUser, event);
  }
//  ---------------------------------------------------------------------------------------------------

//  ------- Belows are the individual fields and methods for this scene ----------

  //  Table
  @FXML
  private TableView<Supplier> table;
  @FXML
  private void table_Click()
  {
    Supplier selectedSupplier =
        table.getSelectionModel().getSelectedItem();
    if (selectedSupplier != null)
    {
      setInformationForFields(
          selectedSupplier,
          idTextField, nameTextField,
          emailTextField, phoneNumberTextField,
          addressTextField, zipCodeTextField
      );
    }
  }

  //  Columns
  @FXML
  private TableColumn<Supplier, String> idColumn;
  @FXML
  private TableColumn<Supplier, String> nameColumn;
  @FXML
  private TableColumn<Supplier, String> emailColumn;
  @FXML
  private TableColumn<Supplier, String> phoneNumberColumn;
  @FXML
  private TableColumn<Supplier, String> addressColumn;
  @FXML
  private TableColumn<Supplier, String> zipCodeColumn;

  //  Buttons and event listeners
  @FXML
  private Button addOrUpdateButton;
  @FXML
  private void addOrUpdateButton_Click()
  {
//    Check the id from user's input:
//    If the input id has existed in the table's data,
//    update the table row contains the input id.
//    If the input id has not existed in the table's data,
//    add a new row to the table

//    Get the id from user's input
    String inputID = idTextField.getText().trim();
//    Get all existed ids in the table's data
    List<String> ids = new ArrayList<>();
    for (Supplier item : table.getItems())
    {
      ids.add(item.getSupplierID());
    }
//    Get index of the input id
    int index = indexOfAString(inputID, ids);
    if (index != -1)
    {
//      The input id has existed in the table's data,
//      then update a row in the table
      if (isValidTextFieldsForUpdating(
          nameTextField, nameErrorLabel,
          emailTextField, emailErrorLabel,
          phoneNumberTextField, phoneNumberErrorLabel,
          addressTextField, addressErrorLabel,
          zipCodeTextField, zipCodeErrorLabel,
          "This field is required.",
          idTextField, table
      ))
      {
//        Ask the user's confirmation
        StringBuilder builder = new StringBuilder();
        builder.append("The supplier whose id is ");
        builder.append(inputID);
        builder.append(" has existed in the table.");
        builder.append("\nDo you want to update this supplier?");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, builder.toString(),
            ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> response = alert.showAndWait();
        if (response.isPresent() && response.get() == ButtonType.YES)
        {
//          Create a new supplier and update the row contains the input id
          Supplier tempSupplier = createASupplierFromUserInput(
              idTextField, nameTextField, emailTextField,
              phoneNumberTextField, addressTextField, zipCodeTextField
          );
          updateARow(table, index, tempSupplier);

//        Add supplier's id to the updatedIDs list
          updatedIDs.add(tempSupplier.getSupplierID());
//        Notify the data has changed.
          isDataChanged = true;
        }
//        Reset
        resetButton_Click();
      }
    }
    else
    {
//        The input id has not existed in the table's data,
//        then add a new row to the table
      if (isValidFieldsForAdding(
          table,
          idTextField, idErrorLabel,
          nameTextField, nameErrorLabel,
          emailTextField, emailErrorLabel,
          phoneNumberTextField, phoneNumberErrorLabel,
          addressTextField, addressErrorLabel,
          zipCodeTextField, zipCodeErrorLabel,
          "This field is required"
      ))
      {
        Supplier tempSupplier = createASupplierFromUserInput(
            idTextField, nameTextField, emailTextField,
            phoneNumberTextField, addressTextField, zipCodeTextField
        );
        addANewRow(table, tempSupplier);

//          Add supplier's id to the addedIDs list
        addedIDs.add(tempSupplier.getSupplierID());
//        Notify the data has changed.
        isDataChanged = true;
//        Reset
        resetButton_Click();
      }
    }
  }

//  Helper method
  private Supplier createASupplierFromUserInput(
      TextField idTextField, TextField nameTextField,
      TextField emailTextField, TextField phoneNumberTextField, TextField addressTextField, TextField zipCodeTextField)
  {
    Supplier tempSupplier;
    String tempID = idTextField.getText().trim();
    String tempName = nameTextField.getText().trim();
    String tempEmail = emailTextField.getText().trim() ;
    String tempPhoneNumber = phoneNumberTextField.getText().trim();
    String tempAddress = addressTextField.getText().trim();
    String tempZipCode = zipCodeTextField.getText().trim();

    tempSupplier = new Supplier(tempID, tempName, tempEmail,
        tempPhoneNumber, tempAddress, tempZipCode);

    return tempSupplier;
  }

  @FXML
  private Button resetButton;
  @FXML
  private void resetButton_Click()
  {
//    Clear all text fields
    Clearing.clearTextFields(idTextField, nameTextField, emailTextField,
        phoneNumberTextField, addressTextField, zipCodeTextField);
//    Clear all labels
    Clearing.clearLabels(idErrorLabel, nameErrorLabel, emailErrorLabel,
        phoneNumberErrorLabel, addressErrorLabel, zipCodeErrorLabel);
  }

  @FXML
  private Button saveButton;
  @FXML
  private void saveButton_Click()
  {
    if (isDataChanged)
    {
      saveToDatabase(table, addedIDs, updatedIDs, connection);
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
  private Label idErrorLabel;
  @FXML
  private Label nameErrorLabel;
  @FXML
  private Label emailErrorLabel;
  @FXML
  private Label phoneNumberErrorLabel;
  @FXML
  private Label addressErrorLabel;
  @FXML
  private Label zipCodeErrorLabel;

  //  TextFields
  @FXML
  private TextField idTextField;
  @FXML
  private TextField nameTextField;
  @FXML
  private TextField addressTextField;
  @FXML
  private TextField emailTextField;
  @FXML
  private TextField phoneNumberTextField;
  @FXML
  private TextField zipCodeTextField;

//------------------------------------------------------------------------------------------------------

//  Another class fields
//  Database connection
  private Connection connection;
  //  Declare a variable that hols the data for the table
  ObservableList<Supplier> supplierObservableList;
  //  Declare a list to contain all suppliers' ids from "supplier" table in the database
  List<String> originalListOfIDs = new ArrayList<>();
  //  Declare a flag to notify when the data is changed
  private boolean isDataChanged = false;
  //  Declare two list contain supplier ids
  private List<String> addedIDs = new ArrayList<>();
  private List<String> updatedIDs = new ArrayList<>();

//  ----------------------------------------------------------------------------------------

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
    supplierObservableList = SupplierDAO.getSuppliers(connection);
    table.setItems(supplierObservableList);
//    Set data for columns
    idColumn.setCellValueFactory(
        new PropertyValueFactory<Supplier, String>("supplierID"));
    nameColumn.setCellValueFactory(
        new PropertyValueFactory<Supplier, String>("supplierName"));
    emailColumn.setCellValueFactory(
        new PropertyValueFactory<Supplier, String>("email"));
    phoneNumberColumn.setCellValueFactory(
        new PropertyValueFactory<Supplier, String>("phoneNumber"));
    addressColumn.setCellValueFactory(
        new PropertyValueFactory<Supplier, String>("address"));
    zipCodeColumn.setCellValueFactory(
        new PropertyValueFactory<Supplier, String>("zipCode"));

//    Get all of supplier's ids from "supplier" table in the database and add them to the
    for (Supplier item : supplierObservableList)
    {
      originalListOfIDs.add(item.getSupplierID());
    }
  }

//  ----------------- Belows are helper methods -----------------------------

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
  private void setInformationForFields(
      Supplier selectedSupplier,
      TextField idTextField, TextField nameTextField,
      TextField emailTextField, TextField phoneNumberTextField,
      TextField addressTextField, TextField zipCodeTextField
  )
  {
    idTextField.setText(selectedSupplier.getSupplierID());
    nameTextField.setText(selectedSupplier.getSupplierName());
    emailTextField.setText(selectedSupplier.getEmail());
    phoneNumberTextField.setText(selectedSupplier.getPhoneNumber());
    addressTextField.setText(selectedSupplier.getAddress());
    zipCodeTextField.setText(selectedSupplier.getZipCode());
  }

  //  Helper method
  private void addANewRow(TableView<Supplier> supplierTableView,
                          Supplier tempSupplier)
  {
    supplierTableView.getItems().add(tempSupplier);
  }

  //  Helper method
  private void updateARow(TableView<Supplier> supplierTableView,
                          int index, Supplier tempSupplier)
  {
    supplierTableView.getItems().set(index, tempSupplier);
  }

  //  Helper method
//  This method validates all the text fields on the scene
  private boolean isValidTextFieldsForUpdating(
      TextField nameTextField, Label nameErrorLabel,
      TextField emailTextField, Label emailErrorLabel,
      TextField phoneNumberTextField, Label phoneNumberErrorLabel,
      TextField addressTextField, Label addressErrorLabel,
      TextField zipCodeTextField, Label zipCodeErrorLabel,
      String blankErrorMessage,
      TextField idTextField,
      TableView<Supplier> supplierTableView
  )
  {
//    Validate the name text field:
    if (!TextFieldValidation.isBlank(nameTextField,
        nameErrorLabel, blankErrorMessage))
    {
      nameErrorLabel.setText("");
    }

//    Validate the email text field:
//    Get the existing email addresses
//    and the existing ids
    ArrayList<String> existingEmails = new ArrayList<>();
    ArrayList<String> existingIDs = new ArrayList<>();
    for (Supplier item : supplierTableView.getItems())
    {
      existingEmails.add(item.getEmail());
      existingIDs.add(item.getSupplierID());
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

//    Validate the zip code text field:
    if (!TextFieldValidation.isBlank(zipCodeTextField,
        zipCodeErrorLabel, blankErrorMessage))
    {
      zipCodeErrorLabel.setText("");
    }

//    If all the text fields is valid, return true, otherwise return false
    if (
        nameErrorLabel.getText().equals("")
            && emailErrorLabel.getText().equals("")
            && phoneNumberErrorLabel.getText().equals("")
            && addressErrorLabel.getText().equals("")
            && zipCodeErrorLabel.getText().equals("")
    )
    {
      return true;
    }
    return false;
  }

  //  Helper method
//  This method validates all the fields on the scene
  private boolean isValidFieldsForAdding(
      TableView<Supplier> supplierTableView,
      TextField idTextField, Label idErrorLabel,
      TextField nameTextField, Label nameErrorLabel,
      TextField emailTextField, Label emailErrorLabel,
      TextField phoneNumberTextField, Label phoneNumberErrorLabel,
      TextField addressTextField, Label addressErrorLabel,
      TextField zipCodeTextField, Label zipCodeErrorLabel,
      String blankErrorMessage
  )
  {
//    Validate the id text field:
//    Get the existing IDs
    ArrayList<String> existedIDs = new ArrayList<>();
    for (Supplier item : supplierTableView.getItems())
    {
      existedIDs.add(item.getSupplierID());
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
    if (!TextFieldValidation.isBlank(nameTextField,
        nameErrorLabel, blankErrorMessage))
    {
      nameErrorLabel.setText("");
    }

//    Validate the email text field:
//    Get the existing email addresses
    ArrayList<String> existingEmails = new ArrayList<>();
    for (Supplier item : supplierTableView.getItems())
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
    if (
        idErrorLabel.getText().equals("")
        && nameErrorLabel.getText().equals("")
        && emailErrorLabel.getText().equals("")
        && phoneNumberErrorLabel.getText().equals("")
        && addressErrorLabel.getText().equals("")
        && zipCodeErrorLabel.getText().equals("")
    )
    {
      return true;
    }
    return false;
  }

  private void saveToDatabase(
      TableView<Supplier> supplierTableView,
      List<String> addedIDs,
      List<String> updatedIDs,
      Connection connection
  )
  {
//    Get all suppliers' id in the table
    List<String> idsInTable = new ArrayList<>();
    for (Supplier item : supplierTableView.getItems())
    {
      idsInTable.add(item.getSupplierID());
    }

//    Get the suppliers from the added ids
    List<Supplier> addedSuppliers = new ArrayList<>();
    for (String item : addedIDs)
    {
      int index = indexOfAString(item, idsInTable);
      if (index != -1)
      {
        addedSuppliers.add(supplierTableView.getItems().get(index));
      }
    }
//    Add added suppliers to the database
    for (Supplier item : addedSuppliers)
    {
      SupplierDAO.insertASupplierToDatabase(item, connection);
    }

//    Get the suppliers from the updated ids
    List<Supplier> updatedSuppliers = new ArrayList<>();
    for (String item : updatedIDs)
    {
      int index = indexOfAString(item, idsInTable);
      if (index != -1)
      {
        updatedSuppliers.add(supplierTableView.getItems().get(index));
      }
    }
//    Update the suppliers in the updatedSuppliers list to the database
    for (Supplier item : updatedSuppliers)
    {
      SupplierDAO.updateSupplier(item, connection);
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









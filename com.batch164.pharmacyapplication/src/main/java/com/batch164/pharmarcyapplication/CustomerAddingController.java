package com.batch164.pharmarcyapplication;

import com.batch164.pharmarcyapplication.model.Customer;
import com.batch164.pharmarcyapplication.model.GenderType;
import com.batch164.pharmarcyapplication.utils.TextFieldHandler;
import com.batch164.pharmarcyapplication.utils.validation.EmailTextFieldValidation;
import com.batch164.pharmarcyapplication.utils.validation.IDTextFieldValidation;
import com.batch164.pharmarcyapplication.utils.validation.TextFieldValidation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CustomerAddingController implements Initializable
{

  @FXML
  private Button addButton;
  @FXML
  private Label addressErrorLabel;
  @FXML
  private TextField addressTextField;
  @FXML
  private Label emailErrorLabel;
  @FXML
  private TextField emailTextField;
  @FXML
  private RadioButton femaleRadioButton;
  @FXML
  private Label firstNameErrorLabel;
  @FXML
  private TextField firstNameTextField;
  @FXML
  private ToggleGroup genderToggleGroup;
  @FXML
  private Label idErrorLabel;
  @FXML
  private TextField idTextField;
  @FXML
  private Label lastNameErrorLabel;
  @FXML
  private TextField lastNameTextField;
  @FXML
  private RadioButton maleRadioButton;
  @FXML
  private Label phoneNumberErrorLabel;
  @FXML
  private TextField phoneNumberTextField;
  @FXML
  private Label zipCodeErrorLabel;
  @FXML
  private TextField zipCodeTextField;

  //  Class fields
  Customer2Controller customer2Controller;
  TableView<Customer> customerTableView;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle)
  {
//    Get reference to the controller of the scene "customer-2-view"
//    And get reference to the customerTableView on the scene "customer-2-view".
    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("customer-2-view.fxml"));
    try
    {
      loader.load();
    } catch (IOException e)
    {
      e.printStackTrace();
    }
//    Get reference to the Controller of "customer-2-view"
    customer2Controller = loader.getController();

    //    Get reference to the customerTableView on the scene "customer-2-view
    customerTableView = customer2Controller.getCustomerTableView();
  }


  @FXML
  void addButton_Click(ActionEvent event) throws IOException
  {
//    Switch stage:
//    Get "customer-2-view"
    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("customer-2-view.fxml"));
    Parent root = loader.load();
    Scene customer2Scene = new Scene(root);

//    WHY DO I NEED GET THE REFERENCE AGAIN??
//    Get reference to the Controller of "customer-2-view"
    customer2Controller = loader.getController();
//    Customer2Controller customer2Controller = loader.getController();

//    Get reference to the customerTableView on the scene "customer-2-view
    TableView<Customer> customerTableView = customer2Controller.getCustomerTableView();

////    Create a new Customer object
//    Customer tempCustomer = new Customer("" +
//        "cus100", "NEW", "EMPLOYEE",
//        GenderType.FEMALE, "new@gmail.com",
//        "0908", "123 nct");
//
////    Add the newly created Customer object to the customerTableView
//    customerTableView.getItems().add(tempCustomer);

  //    Validate all the text fields
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

//    Get reference to the primary stage
//    and switch to the "customer-view" scene
      Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      primaryStage.setScene(customer2Scene);
      primaryStage.show();
    }
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






















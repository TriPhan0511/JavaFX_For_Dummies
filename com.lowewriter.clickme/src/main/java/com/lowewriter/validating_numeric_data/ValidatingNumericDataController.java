package com.lowewriter.validating_numeric_data;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ValidatingNumericDataController
{
  @FXML
  TextField nameTextField;
  @FXML
  Label nameErrorLabel;
  @FXML
  TextField ageTextField;
  @FXML
  Label ageErrorLabel;
  @FXML
  TextField dateOfBirthTextField;
  @FXML
  Label dateOfBirthErrorLabel;

  @FXML
  private void okButton_Click()
  {
//    Validate the "name" field (check empty string)
    if (isBlank(nameTextField,
        nameErrorLabel, "Name is required."))
    {
      nameTextField.setText("");
      nameTextField.requestFocus();
    }
    else
    {
      nameErrorLabel.setText("");
    }

//    Validate the "age" field (check empty string and integer)
    if (isBlank(ageTextField,
        ageErrorLabel, "Age is required."))
    {
      ageTextField.setText("");
      ageTextField.requestFocus();
    }
    else if (isInteger(ageTextField,
        ageErrorLabel, "Invalid data. Age should be a number."))
    {
      ageErrorLabel.setText("");
    }
    else
    {
      ageTextField.requestFocus();
    }

//    Validate the "date of birth" field (check empty string and LocalDate)
    if (isBlank(dateOfBirthTextField,
        dateOfBirthErrorLabel, "Date of Birth is required."))
    {
      dateOfBirthTextField.setText("");
      dateOfBirthTextField.requestFocus();
    }
    else if (isDate(dateOfBirthTextField,
        dateOfBirthErrorLabel,
        "Invalid date. The date should be format: yyyy-mm-dd"))
    {
      dateOfBirthErrorLabel.setText("");
    }
    else
    {
      dateOfBirthTextField.requestFocus();
    }

//    Finish
    if (nameErrorLabel.getText().equals("")
        && ageErrorLabel.getText().equals("")
        && dateOfBirthErrorLabel.getText().equals(""))
    {
      StringBuilder builder = new StringBuilder();
      builder.append("\nName: ");
      builder.append(nameTextField.getText().trim());
      builder.append("\nAge: ");
      builder.append(Integer.parseInt(ageTextField.getText().trim()));
      builder.append("\nDate of Birth: ");
      builder.append(LocalDate.parse(dateOfBirthTextField.getText().trim()));

      Alert alert = new Alert(Alert.AlertType.INFORMATION, builder.toString());
      alert.show();
    }

  }

//  Check whether text of a text field is blank or not
  private boolean isBlank(TextField textField,
              Label errorLabel, String errorMessage)
  {
    if (textField.getText().isBlank())
    {
      errorLabel.setText(errorMessage);
      return true;
    }
    return false;
  }

//  Check whether text of a text field is an integer or not
  private boolean isInteger(TextField textField,
              Label errorLabel, String errorMessage)
  {
    try
    {
      Integer.parseInt(textField.getText().trim());
      return true;
    }
    catch (NumberFormatException e)
    {
      errorLabel.setText(errorMessage);
      return false;
    }
  }

  //  Check whether text of a text field is a LocalDate or not
  private boolean isDate(TextField textField,
                         Label errorLabel, String errorMessage)
  {
    try
    {
      LocalDate.parse(textField.getText().trim());
      return true;
    }
    catch (DateTimeException e)
    {
      errorLabel.setText(errorMessage);
      return false;
    }
  }

  private void okButton_Click1()
  {
    String name = nameTextField.getText();
    String ageString = ageTextField.getText();
    String dateOfBirthString = dateOfBirthTextField.getText();

    int age = 0;
    LocalDate dateOfBirth = LocalDate.now();

//    Validate the "name" field
    if (name.isBlank())
    {
      nameErrorLabel.setText("Name is required.");
      nameTextField.setText("");
    }
    else
    {
      nameErrorLabel.setText("");
    }

//    Validate the "age" field
    if (ageString.isBlank())
    {
      ageErrorLabel.setText("Age is required.");
      ageTextField.setText("");
    }
    else
    {
      try
      {
        age = Integer.parseInt(ageString);
        ageErrorLabel.setText("");
      }
      catch (NumberFormatException e)
      {
        ageErrorLabel.setText("Invalid age. Age should be a number.");
      }
    }

//    Validate the "date of birth" field
    if (dateOfBirthString.isBlank())
    {
      dateOfBirthErrorLabel.setText("Date of Birth is required.");
      dateOfBirthTextField.setText("");
    }
    else
    {
      try
      {
        dateOfBirth = LocalDate.parse(dateOfBirthString);
        dateOfBirthErrorLabel.setText("");
      }
      catch (DateTimeParseException e)
      {
        dateOfBirthErrorLabel.setText("Invalid date. The date should be in format: yyyy-mm-dd");
      }
    }

//    Show the information
    if (nameErrorLabel.getText().equals("")
        && ageErrorLabel.getText().equals("")
        && dateOfBirthErrorLabel.getText().equals(""))
    {
      StringBuilder builder = new StringBuilder();
      builder.append("Name: ");
      builder.append(name);
      builder.append("\nAge: ");
      builder.append(age);
      builder.append("\nDate of Birth: ");
      builder.append(dateOfBirth);
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION, builder.toString());
      alert.show();
    }
  }
}





























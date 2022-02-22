package com.batch164.pharmacyapp.utils.validation;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.DateTimeException;
import java.time.LocalDate;

public class TextFieldValidation
{
  //  Check whether a text field is blank or not
  public boolean isBlank(TextField textField,
            Label errorMessageLabel, String errorMessage)
  {
    if (textField.getText().isBlank())
    {
      errorMessageLabel.setText(errorMessage);
      return true;
    }
    else
    {
      return false;
    }
  }

  //  Check whether content of a text field is an integer or not
  public boolean isInteger(TextField textField,
            Label errorMessageLabel, String errorMessage)
  {
    try
    {
      Integer.parseInt(textField.getText().trim());
      return true;
    }
    catch (NumberFormatException e)
    {
      errorMessageLabel.setText(errorMessage);
      return false;
    }
  }

  //  Check whether content of a text field is a double or not
  public boolean isDouble(TextField textField,
            Label errorMessageLabel, String errorMessage)
  {
    try
    {
      Double.parseDouble(textField.getText().trim());
      return true;
    }
    catch (NumberFormatException e)
    {
      errorMessageLabel.setText(errorMessage);
      return false;
    }
  }

//  Check whether content of a text field is a LocalDate object

  public boolean isDate(TextField textField,
            Label errorMessageLabel, String errorMessage)
  {
    try
    {
      LocalDate.parse(textField.getText().trim());
      return true;
    }
    catch (DateTimeException e)
    {
      errorMessageLabel.setText(errorMessage);
      return false;
    }
  }
}






























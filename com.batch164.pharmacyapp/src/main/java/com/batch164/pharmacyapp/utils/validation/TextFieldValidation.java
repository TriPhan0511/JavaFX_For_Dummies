package com.batch164.pharmacyapp.utils.validation;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;

public class TextFieldValidation
{
  //  Check whether a text field is blank or not
  public static boolean isBlank(
      TextField textField,
      Label errorMessageLabel,
      String errorMessage)

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
  public static boolean isInteger(
      TextField textField,
      Label errorMessageLabel,
      String errorMessage)

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
  public static boolean isDouble(
      TextField textField,
      Label errorMessageLabel,
      String errorMessage)
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
  public static boolean isDate(
      TextField textField,
      Label errorMessageLabel,
      String errorMessage)
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

////  Check whether content of a text field is a valid ID
//  public static boolean isValidID(
//      TextField textField,
//      Label errorMessageLabel,
//      String errorMessage)
//  {
////    TODO
//    return true;
//  }

  //  Check whether content of a text field is an existed email or not
  public static boolean isExistedEmail(
      TextField textField,
      Label errorMessageLabel,
      String errorMessage,
      ArrayList<String> existedEmails)
  {
    if (Validation.isExistedEmail(textField.getText().trim(), existedEmails))
    {
      errorMessageLabel.setText(errorMessage);
      return false;
    }
    else
    {
      return true;
    }
  }

//  Check whether content of a text field is a valid email or not
public static boolean isValidEmail(
    TextField textField,
    Label errorMessageLabel,
    String errorMessage)
{
  if (!Validation.isValidEmail(textField.getText().trim()))
  {
    errorMessageLabel.setText(errorMessage);
    return false;
  }
  else
  {
    return true;
  }
}
}






























package com.batch164.pharmarcyapplication.utils.validation;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class IDTextFieldValidation
{
  /**
   * Validate an ID which is input by the user.
   * @param idTextField A TextField control
   *                       which used to get ID from the user.
   * @param idErrorLabel A Label control which
   *                        used to display error message.
   * @param existedIDs An ArrayList which contains String objects
   *                      represent the existing IDs.
   * @return true if the input ID is valid, otherwise, return false.
   */
  public static boolean validate(
      TextField idTextField,
      Label idErrorLabel,
      ArrayList<String> existedIDs)
  {
    if (!TextFieldValidation.isBlank(
        idTextField,
        idErrorLabel,
        "ID is required."
    ))
    {
      if (!TextFieldValidation.isTooLong(
          idTextField,
          idErrorLabel,
          "ID should have less than 10 characters.",
          9
      ))
      {
        if (!isExistedIDTextField(
            idTextField,
            idErrorLabel,
            "This ID exists.",
            existedIDs
        ))
        {
          return true;
        }
      }
    }
    return false;
  }

//  Helper method
  private static boolean isExistedIDTextField(
      TextField idTextField,
      Label idErrorLabel,
      String errorMessage,
      ArrayList<String> existedIDs)
  {
    if (Validation.isExistedItem(idTextField.getText().trim(), existedIDs))
    {
      idErrorLabel.setText(errorMessage);
      return true;
    }
    return false;
  }
}




















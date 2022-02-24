package com.batch164.pharmarcyapplication.utils.validation;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class EmailTextFieldValidation
{
  /**
   * Validate an email address which is input by the user.
   * @param emailTextField A TextField control
   *                       which used to get email address from the user.
   *
   * @param emailErrorLabel A Label control which
   *                        used to display error message.
   * @param existedEmails An ArrayList which contains String objects
   *                      represent the existing emails.
   * @return true if the input email address is valid, otherwise, return false.
   */
  public static boolean validate(
      TextField emailTextField,
      Label emailErrorLabel,
      ArrayList<String> existedEmails)
  {
    if (!TextFieldValidation.isBlank(
        emailTextField,
        emailErrorLabel,
        "Email address is required."
    ))
    {
      if (isValidEmailTextField(
          emailTextField,
          emailErrorLabel,
          "Invalid email address."))
      {
        if (!isExistedEmailTextField(
            emailTextField,
            emailErrorLabel,
            "This email address exists.",
            existedEmails
        ))
        {
          return true;
        }
      }
    }
    return false;
  }

//  -------------- Below are helper methods ---------------------------
  private static boolean isExistedEmailTextField(
      TextField emailTextField,
      Label emailErrorLabel,
      String errorMessage,
      ArrayList<String> existedEmails)
  {
    if (Validation.isExistedItem(emailTextField.getText().trim(), existedEmails))
    {
      emailErrorLabel.setText(errorMessage);
      return true;
    }
    return false;
  }

  private static boolean isValidEmailTextField(
      TextField emailTextField,
      Label emailErrorLabel,
      String errorMessage)
  {
    if (Validation.isValidEmail(emailTextField.getText().trim()))
    {
      return true;
    }
    else
    {
      emailErrorLabel.setText(errorMessage);
      return false;
    }
  }
}

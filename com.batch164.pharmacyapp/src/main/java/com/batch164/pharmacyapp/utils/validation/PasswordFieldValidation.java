package com.batch164.pharmacyapp.utils.validation;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class PasswordFieldValidation
{
  public static boolean areSame(PasswordField field1,
                                PasswordField field2,
                                Label errorLabel,
                                String errorMessage)
  {
    String password1 = field1.getText().trim();
    String password2 = field2.getText().trim();
    if (password1.equals(password2))
    {
      return true;
    }
    else
    {
      errorLabel.setText(errorMessage);
      return false;
    }
  }

  public static boolean areSame2(String tempPassword,
                                PasswordField field,
                                Label errorLabel,
                                String errorMessage)
  {
    String tempPassword2 = field.getText().trim();
    if (tempPassword.equals(tempPassword2))
    {
      return true;
    }
    else
    {
      errorLabel.setText(errorMessage);
      return false;
    }
  }
}

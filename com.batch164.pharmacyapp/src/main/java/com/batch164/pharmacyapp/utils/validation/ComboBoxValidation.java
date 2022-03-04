package com.batch164.pharmacyapp.utils.validation;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class ComboBoxValidation
{
  public static boolean isBlank(
      ComboBox<String> stringComboBox,
      Label errorLabel,
      String errorMessage
  )
  {
    if (stringComboBox.getValue() == null
        || stringComboBox.getValue().equals(""))
    {
      errorLabel.setText(errorMessage);
      return true;
    }
    return false;
  }
}

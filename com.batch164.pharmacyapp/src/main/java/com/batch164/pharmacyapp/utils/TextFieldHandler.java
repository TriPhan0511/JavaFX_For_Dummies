package com.batch164.pharmacyapp.utils;

import javafx.scene.control.TextField;

public class TextFieldHandler
{
  public static void clearTextFields(TextField... textFields)
  {
    for (TextField item : textFields)
    {
      item.clear();
    }
  }
}

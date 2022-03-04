package com.batch164.pharmacyapp.utils;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Clearing
{
  public static void clearTextFields(TextField... textFields)
  {
    for (TextField item : textFields)
    {
      item.clear();
    }
  }

  public static void clearLabels(Label... labels)
  {
    for (Label item : labels)
    {
      item.setText("");
    }
  }
}

package com.lowewriter.getting_input_from_the_user.radiobuttons_sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;

/**
 * This samples illustrates about RadioButton
 */
public class SizeController
{
  @FXML
  RadioButton smallRadioButton;
  @FXML
  RadioButton mediumRadioButton;
  @FXML
  RadioButton largeRadioButton;

  @FXML
  private void okButton_Click()
  {
    String message = "Size: ";
    if (smallRadioButton.isSelected())
    {
      message += "small.";
    }
    if (mediumRadioButton.isSelected())
    {
      message += "medium.";
    }
    if (largeRadioButton.isSelected())
    {
      message += "large.";
    }
    Alert alert = new Alert(Alert.AlertType.INFORMATION, message);
    alert.show();
  }
}

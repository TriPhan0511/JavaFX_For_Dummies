package com.lowewriter.getting_input_from_the_user.checkboxes_sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;

/**
 * This sample demonstrates how to use CheckBox
 */
public class ToppingsController
{
  @FXML
  CheckBox pepperoniCheckBox;
  @FXML
  CheckBox mushroomsCheckBox;
  @FXML
  CheckBox anchoviesCheckBox;

  /**
   * Action event handler to the okButton
   */
  @FXML
  private void okButton_Click()
  {
    String toppings = "";
    toppings = buildToppings(pepperoniCheckBox, toppings);
    toppings = buildToppings(mushroomsCheckBox, toppings);
    toppings = buildToppings(anchoviesCheckBox, toppings);
    if (toppings.equals(""))
    {
      toppings = "You did not choose any toppings.";
    }
    else
    {
      toppings = "Topping:\n" + toppings;
    }
    Alert alert = new Alert(Alert.AlertType.INFORMATION, toppings);
    alert.show();
  }

  private String buildToppings(CheckBox checkBox, String toppings)
  {
    if (checkBox.isSelected())
    {
      toppings += checkBox.getText() + "\n";
    }
    return toppings;
  }

  /**
   * Action event handler for anchoviesCheckBox.
   * This handler responds to the event generated when the use
   * click the anchoviesCheckBox.
   */
  @FXML
  private void anchoviesCheckBox_Click()
  {
    Alert alert = new Alert(Alert.AlertType.WARNING,
        "We don't do anchovies here");
    alert.setTitle("Yuck");
    alert.show();
    anchoviesCheckBox.setSelected(false);
  }
}
































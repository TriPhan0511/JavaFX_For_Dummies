package com.triphan.pizzaorder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class PizzaOrderController
{
  @FXML
  TextField nameTextField;
  @FXML
  TextField phoneNumberTextField;
  @FXML
  TextField addressTextField;
  @FXML
  RadioButton smallRadioButton;
  @FXML
  RadioButton mediumRadioButton;
  @FXML
  RadioButton largeRadioButton;
  @FXML
  RadioButton thinRadioButton;
  @FXML
  RadioButton thickRadioButton;
  @FXML
  CheckBox pepperoniCheckBox;
  @FXML
  CheckBox mushroomsCheckBox;
  @FXML
  CheckBox olivesCheckBox;
  @FXML
  Button okButton;
  @FXML
  Button closeButton;

  @FXML
  private void closeButton_Click(ActionEvent event)
  {
//    Get reference of the primary stage and call the close method on the stage.
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.close();
  }

  @FXML
  private void okButton_Click()
  {
//    Show customer's information
    StringBuilder builder = new StringBuilder();
    builder.append("Your information:");
    builder.append("\n\tName: ");
    builder.append(nameTextField.getText());
    builder.append("\n\tPhone number: ");
    builder.append(phoneNumberTextField.getText());
    builder.append("\n\tAddress: ");
    builder.append(addressTextField.getText());

//    Show the pizza which the customer wants to order
    builder.append("\n\nYour choice:");
    builder.append("\n\tSize: ");
    if (smallRadioButton.isSelected())
    {
      builder.append("small");
    }
    if (mediumRadioButton.isSelected())
    {
      builder.append("medium");
    }
    if (largeRadioButton.isSelected())
    {
      builder.append("large");
    }
    builder.append("\n\tStyle: ");
    if (thinRadioButton.isSelected())
    {
      builder.append("thin");
    }
    if (thickRadioButton.isSelected())
    {
      builder.append("thick");
    }
    builder.append("\n\tToppings: ");
    String toppings = "";
    toppings = buildToppings(pepperoniCheckBox, toppings);
    toppings = buildToppings(mushroomsCheckBox, toppings);
    toppings = buildToppings(olivesCheckBox, toppings);
    if (toppings.equals(""))
    {
      toppings = "You did not choose any toppings.";
    }
    else if (toppings.endsWith(", "))
    {
      toppings = toppings.substring(0, toppings.length() - 2);
    }
    builder.append(toppings);

    Alert alert = new Alert(Alert.AlertType.INFORMATION, builder.toString());
    alert.showAndWait();
  }

  private String buildToppings(CheckBox checkBox, String toppings)
  {
    if (checkBox.isSelected())
    {
      toppings += checkBox.getText();
      toppings += ", ";
    }
    return toppings;
  }

}





































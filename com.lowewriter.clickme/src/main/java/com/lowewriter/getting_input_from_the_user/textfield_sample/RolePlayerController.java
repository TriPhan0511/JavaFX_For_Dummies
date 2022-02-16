package com.lowewriter.getting_input_from_the_user.textfield_sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


/**
 * This sample demonstrates how to use TextField
 */
public class RolePlayerController
{
  @FXML
  TextField characterNameTextField;
  @FXML
  TextField actorNameTextField;
  @FXML
  Button okButton;

  @FXML
  private void okButton_Click()
  {
    String message = "";
    if (characterNameTextField.getText().isBlank())
    {
      message += "Character's name is required.\n";
      characterNameTextField.setText("");
    }
    if (actorNameTextField.getText().isBlank())
    {
      message += "Actor's name is required.";
      actorNameTextField.setText("");
    }

    if (message.equals(""))
    {
      message = "The role of " + characterNameTextField.getText()
          + " will be played by " + actorNameTextField.getText();
    }

    Alert alert = new Alert(Alert.AlertType.INFORMATION, message);
    alert.showAndWait();
  }

//  private void okButton_Click()
//  {
//    if (characterNameTextField.getText().isBlank())
//    {
//      Alert alert = new Alert(
//          Alert.AlertType.WARNING, "Character's name is required.");
//      alert.setTitle("Missing Data");
//      alert.showAndWait();
//      characterNameTextField.setText("");
//      characterNameTextField.requestFocus();
//    }
//    else if (actorNameTextField.getText().isBlank())
//    {
//      Alert alert = new Alert(
//          Alert.AlertType.WARNING, "Actor's name is required.");
//      alert.setTitle("Missing Data");
//      alert.showAndWait();
//      actorNameTextField.setText("");
//      actorNameTextField.requestFocus();
//    }
//    else
//    {
//      Alert alert = new Alert(Alert.AlertType.INFORMATION,
//          "The role of " + characterNameTextField.getText()
//              + " will be played by " + actorNameTextField.getText() + ".");
//      alert.setTitle("Cast");
//      alert.showAndWait();
//    }
//
//  }
}
































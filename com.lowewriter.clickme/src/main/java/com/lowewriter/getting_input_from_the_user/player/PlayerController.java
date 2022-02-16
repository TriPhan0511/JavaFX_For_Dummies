package com.lowewriter.getting_input_from_the_user.player;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PlayerController
{
  @FXML
  TextField characterNameTextField;
  @FXML
  TextField actorNameTextField;
  @FXML
  Label characterErrorLabel;
  @FXML
  Label actorErrorLabel;

  @FXML
  private void okButton_Click()
  {
    if (characterNameTextField.getText().isBlank())
    {
      characterErrorLabel.setText("Character's name is required.");
      characterNameTextField.setText("");
    }
    else
    {
      characterErrorLabel.setText("");
    }
    if (actorNameTextField.getText().isBlank())
    {
      actorErrorLabel.setText("Actor's name is required.");
      actorNameTextField.setText("");
    }
    else
    {
      actorErrorLabel.setText("");
    }

    if (characterErrorLabel.getText().equals("")
        && actorErrorLabel.getText().equals(""))
    {
      String message = characterNameTextField.getText()
          + " will be played by "
          + actorNameTextField.getText() + ".";
      Alert alert = new Alert(Alert.AlertType.INFORMATION, message);
      alert.show();
    }
  }

//  private void okButton_Click2()
//  {
//    String message = "";
//    if (characterNameTextField.getText().isBlank())
//    {
//      message += "The character's name is required.\n";
//    }
//    if (actorNameTextField.getText().isBlank())
//    {
//      message += "The actor's name is required.";
//    }
//    if (message.equals(""))
//    {
//      message = "The " + characterNameTextField.getText()
//          + " will be played by " + actorNameTextField.getText() + ".";
//      Alert alert = new Alert(Alert.AlertType.INFORMATION, message);
//      alert.show();
//    }
//    else
//    {
//      Alert alert = new Alert(Alert.AlertType.WARNING, message);
//      alert.show();
//    }
//  }
}























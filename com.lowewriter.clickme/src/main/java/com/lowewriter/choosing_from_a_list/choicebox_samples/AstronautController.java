package com.lowewriter.choosing_from_a_list.choicebox_samples;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class AstronautController implements Initializable
{
  @FXML
  ChoiceBox<Astronaut> apollo13;
  @FXML
  Button okButton;
  @FXML
  Label messageLabel;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle)
  {
    Astronaut lovell = new Astronaut("Jim", "Lovell");
    Astronaut swigert = new Astronaut("John", "Swigert");
    Astronaut haise = new Astronaut("Fred", "Haise");
    Astronaut mary = new Astronaut("Rose", "Mary");
    Astronaut duff = new Astronaut("Hillary", "Duff");
    apollo13.getItems().addAll(lovell, swigert, haise, mary, duff);
    apollo13.setValue(lovell);

////    Add change listener (way 1) : Add the following lines to the initialize method
//    apollo13.getSelectionModel().selectedItemProperty()
//        .addListener( (v, oldValue, newVale) ->
//            messageLabel.setText(newVale.toString()));
  }

//  Add change listener (way 2):
//  On *.fxml: onMouseReleased="#changeItem"
  @FXML
  private void changeItem()
  {
    apollo13.getSelectionModel().selectedItemProperty().
        addListener((v, oldValue, newValue) ->
            messageLabel.setText(newValue.toString()));
  }

  @FXML
  private void okButton_Click()
  {
    String message = "You choose ";
    message += apollo13.getValue().toString() + ".";
    Alert alert = new Alert(Alert.AlertType.INFORMATION, message);
    alert.show();
  }
}

































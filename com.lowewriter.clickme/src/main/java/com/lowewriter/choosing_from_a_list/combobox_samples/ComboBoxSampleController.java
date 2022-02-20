package com.lowewriter.choosing_from_a_list.combobox_samples;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ComboBoxSampleController implements Initializable
{

  @FXML
  private ComboBox<String> namesComboBox;
  @FXML
  private Button okButton;
  @FXML
  private Label messageLabel;

  @FXML
  private void okButton_Click(ActionEvent event)
  {
    String message = namesComboBox.getItems().contains(namesComboBox.getValue()) ?
        "You chose: " + namesComboBox.getValue()
        : "You chose outside the box. You chose: " + namesComboBox.getValue();
    Alert alert = new Alert(Alert.AlertType.INFORMATION, message);
    alert.show();
  }

  @FXML
  private void namesComboBox_Change()
  {
    if (namesComboBox.getValue().equals("Dopey"))
    {
      Alert alert = new Alert(Alert.AlertType.INFORMATION, "He's my favorite too!");
      alert.setTitle("Good choice");
      alert.show();
    }
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle)
  {
    namesComboBox.getItems().addAll("BashFul", "Doc", "Dopey",
        "Grumpy", "Happy", "Sleepy", "Funny");
  }
}






























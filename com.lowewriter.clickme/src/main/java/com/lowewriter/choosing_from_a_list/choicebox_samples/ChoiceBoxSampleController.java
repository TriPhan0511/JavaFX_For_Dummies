package com.lowewriter.choosing_from_a_list.choicebox_samples;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

// This sample illustrates about the choicebox
public class ChoiceBoxSampleController
{
  @FXML
  private ChoiceBox<String> favoriteChoiceBox;
  @FXML
  private Button okButton;

  public void initialize()
  {
    favoriteChoiceBox.getItems().addAll("Bashful", "Doc",
        "Dopey", "Grumpy", "Happy", "Sleepy", "Sneezy");
  }

  @FXML
  private void okButton_Click()
  {
  }
}

























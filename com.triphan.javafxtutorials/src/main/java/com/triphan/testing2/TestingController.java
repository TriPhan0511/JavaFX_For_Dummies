package com.triphan.testing2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TestingController
{
//    Fields for Click Counter scene
  @FXML
  Label displayLabel1;
  @FXML
  Button clickMeButton;
  @FXML
  Button switchSceneButton1;
  @FXML
  int counter = 0;

  //  Fields for AddSubtract scene
  @FXML
  Label displayLabel2;
  @FXML
  Button addButton, subtractButton, switchSceneButton2;

  @FXML
  protected void clickMeButton_Click()
  {
    counter++;
    if (counter == 1)
    {
      displayLabel1.setText("You have clicked once.");
    }
    else
    {
      displayLabel1.setText("You have clicked " + counter + " times.");
    }
  }

}






















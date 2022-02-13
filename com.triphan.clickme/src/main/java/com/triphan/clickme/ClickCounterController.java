package com.triphan.clickme;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ClickCounterController
{
  //  Class fields for Click-Counter scene
  @FXML
  private Label displayLabel1;
  @FXML
  private Button clickMeButton, switchToScene2Button;
  private int counter1 = 0;

  @FXML
  private void initialize()
  {
    displayLabel1.setText("You have not clicked the button.");
  }

  @FXML
  private void clickMeButton_Click()
  {
    counter1++;
    if (counter1 == 1)
    {
      displayLabel1.setText("You have clicked once.");
    }
    else
    {
      displayLabel1.setText("You have clicked "+counter1+" times.");
    }
  }

  @FXML
  private void switchToScene2Button_Click()
  {

  }
}

//public class ClickCounterController
//{
//  @FXML
//  private Label displayLabel;
//  @FXML
//  private Button clickMeButton;
//  @FXML
//  private Button switchSceneButton;
//  @FXML
//  int counter = 0;
//
//  @FXML
//  private void initialize()
//  {
//    displayLabel.setText("You have not clicked the button.");
//  }
//
////  Event handlers for Click Counter scene
//  @FXML
//  protected void clickMeButton_Click()
//  {
//    counter++;
//    if (counter == 1)
//    {
//      displayLabel.setText("You have clicked once.");
//    }
//    else
//    {
//      displayLabel.setText("You have clicked " + counter + " times.");
//    }
//  }
//
//  @FXML
//  public void switchSceneButton_Click()
//  {
//
//  }
//}


















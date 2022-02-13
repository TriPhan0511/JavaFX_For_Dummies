package com.triphan.clickme;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AddSubtractController
{
  //  Class fields for Add-Subtract scene
  @FXML
  private Label displayLabel2;
  @FXML
  private Button addButton, subtractButton, switchToScene1Button;
  @FXML
  private int counter2 = 0;

  @FXML
  private void initialize()
  {
    displayLabel2.setText(Integer.toString(counter2));
  }

  @FXML
  private void addButton_Click()
  {
    counter2++;
    displayLabel2.setText(Integer.toString(counter2));
  }

  @FXML
  private void subtractButton_Click()
  {
    counter2--;
    displayLabel2.setText(Integer.toString(counter2));
  }

  @FXML
  private void switchToScene1Button_Click()
  {

  }
}

//public class AddSubtractController
//{
//  //  Fields for Add Subtract scene
//  @FXML
//  private Label displayLabel;
//  @FXML
//  private Button addButton;
//  @FXML
//  private Button subtractButton;
//  @FXML
//  private Button switchButton;
//  @FXML
//  private int counter = 0;
//
//  @FXML
//  private void initialize()
//  {
//    displayLabel.setText(Integer.toString(counter));
//  }
//
//  @FXML
//  protected void addButton_Click()
//  {
//    counter++;
//    displayLabel.setText(Integer.toString(counter));
//  }
//
//  @FXML
//  protected void subtractButton_Click()
//  {
//    counter--;
//    displayLabel.setText(Integer.toString(counter));
//  }
//
//}

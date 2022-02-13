package com.triphan.javafxtutorials;

import com.triphan.testing.Greeting;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ClickCounterController
{
  @FXML
  private int counter = 0;

  @FXML
  private Label displayLabel;

  @FXML
  private void initialize()
  {
    displayLabel.setText(Integer.toString(counter));
  }

  @FXML
//  protected void clickMeButton_Click()
//  {
//    Greeting greeting = new Greeting();
//    displayLabel.setText(greeting.sayHello());
//  }
  protected void clickMeButton_Click()
  {
    counter++;
    if (counter == 1)
    {
      displayLabel.setText("You have clicked once.");
    }
    else
    {
      displayLabel.setText("You have clicked " + counter + " times.");
    }
  }
}

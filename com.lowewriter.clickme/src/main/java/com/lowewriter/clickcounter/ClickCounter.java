package com.lowewriter.clickcounter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ClickCounter extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  //  Class fields
  Button clickMeButton;
  Label displayLabel;
  int counter = 0;

  @Override
  public void start(Stage primaryStage)
  {
//    Create a label
    displayLabel = new Label("You have not clicked the button.");

//    Create the button
    clickMeButton = new Button("Click me please!");
    clickMeButton.setOnAction(e -> clickMeButton_Click());

//    Create a BorderPane
    BorderPane root = new BorderPane();
    root.setTop(displayLabel);
    root.setCenter(clickMeButton);


//    Finish
    Scene scene = new Scene(root, 250, 150);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Click Counter");
    primaryStage.show();
  }

  private void clickMeButton_Click()
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
























package com.lowewriter.addsubtract5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// The AddSubtract5 Program with Lambda Expressions
public class AddSubtract5 extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  //  Class fields
  Label displayLabel;
  Button addButton;
  Button subtractButton;
  int counter = 0;

  @Override
  public void start(Stage primaryStage)
  {
//    Create the label
    displayLabel = new Label(Integer.toString(counter));
//    Create the buttons
    addButton = new Button("Add");
    addButton.setOnAction(e -> addButton_Click());
    subtractButton = new Button("Subtract");
    subtractButton.setOnAction(e -> subtractButton_Click());
//    Add the label and the buttons to a HBox pane
    HBox root = new HBox(10, displayLabel, addButton, subtractButton);
    root.setPadding(new Insets(10));
//    Finish
    Scene scene = new Scene(root, 250, 75);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Add/Subtract 5");
    primaryStage.show();
  }

  private void subtractButton_Click()
  {
    counter--;
    displayLabel.setText(Integer.toString(counter));
  }

  private void addButton_Click()
  {
    counter++;
    displayLabel.setText(Integer.toString(counter));
  }
}






































package com.lowewriter.addsubtract1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// Implementing the EventHandler Interface
public class AddSubtract extends Application
    implements EventHandler<ActionEvent>
{
  public static void main(String[] args)
  {
    launch(args);
  }

  //  Class fields
  Button addButton;
  Button subtractButton;
  Label displayLabel;
  int counter = 0;

  @Override
  public void start(Stage primaryStage)
  {
//    Create the label
    displayLabel = new Label(Integer.toString(counter));
//    Create the Add button
    addButton = new Button("Add");
    addButton.setOnAction(this);
//    Create the Subtract button
    subtractButton = new Button("Subtract");
    subtractButton.setOnAction(this);
//    Add the label and the buttons to a HBox pane
    HBox root = new HBox(10, displayLabel, addButton, subtractButton);
//    HBox root = new HBox(10);
//    root.getChildren().addAll(displayLabel, addButton, subtractButton);
    root.setPadding(new Insets(10));

//    Finish
    Scene scene = new Scene(root, 200, 75);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Add/Sub");
    primaryStage.show();
  }

  @Override
  public void handle(ActionEvent e)
  {
    if (e.getSource() == addButton)
    {
      counter++;
    }
    if (e.getSource() == subtractButton)
    {
      counter--;
    }
    displayLabel.setText(Integer.toString(counter));
  }
}



























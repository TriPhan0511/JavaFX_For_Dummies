package com.lowewriter.addsubtract3;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// Handling Events with Anonymous Inner Classes
public class AddSubtract3 extends Application
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
    addButton.setOnAction(new EventHandler<ActionEvent>()
    {
      @Override
      public void handle(ActionEvent e)
      {
        counter++;
        displayLabel.setText(Integer.toString(counter));
      }
    });
    subtractButton = new Button("Subtract");
    subtractButton.setOnAction(new EventHandler<ActionEvent>()
    {
      @Override
      public void handle(ActionEvent e)
      {
        counter--;
        displayLabel.setText(Integer.toString(counter));
      }
    });
//    Add the label and the buttons to a HBox pane
    HBox root = new HBox(10, displayLabel, addButton, subtractButton);
    root.setPadding(new Insets(10));
//    Finish
    Scene scene = new Scene(root, 250, 75);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Add/Subtract 3");
    primaryStage.show();
  }
}




























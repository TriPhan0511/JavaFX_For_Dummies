package com.lowewriter.addsubtract2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// Handling Events with Inner Classes
public class AddSubtract2 extends Application
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
//    Create a ClickHandler instance
    ClickHandler ch = new ClickHandler();
//    Create the label
    displayLabel = new Label(Integer.toString(counter));
//    Create the buttons
    addButton = new Button("Add");
    addButton.setOnAction(ch);
    subtractButton = new Button("Subtract");
    subtractButton.setOnAction(ch);
//    Add the label and the buttons to a HBox pane
    HBox root = new HBox(10, displayLabel, addButton, subtractButton);
    root.setPadding(new Insets(10));
//    Finish
    Scene scene = new Scene(root, 250, 75);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Add/Subtract 2");
    primaryStage.show();
  }

  private class ClickHandler implements EventHandler<ActionEvent>
  {
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
}
















































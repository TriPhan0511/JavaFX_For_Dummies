package com.lowewriter.clickcounteralert;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ClickCounterAlert extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  //  Class field
  int counter = 0;

  @Override
  public void start(Stage primaryStage)
  {
    Button clickMeButton = new Button("Click me please!");
    clickMeButton.setOnAction(e -> clickMeButton_Click());
//    HBox root = new HBox(clickMeButton);
    BorderPane root = new BorderPane();
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
    String message;
    if (counter == 1)
    {
      message = "You have clicked once.";
    }
    else
    {
      message = "You have clicked " + counter + " times.";
    }
    Alert a = new Alert(Alert.AlertType.INFORMATION, message);
    a.showAndWait();
  }
}


































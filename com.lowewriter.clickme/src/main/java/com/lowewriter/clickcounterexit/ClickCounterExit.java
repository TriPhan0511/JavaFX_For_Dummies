package com.lowewriter.clickcounterexit;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class ClickCounterExit extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  //  Class fields
  Stage stage;
  int counter = 0;

  @Override
  public void start(Stage primaryStage)
  {
    stage = primaryStage;

//    Create the Click Me Button
    Button clickMeButton = new Button("Click me please!");
    clickMeButton.setOnAction(e -> clickMeButton_Click());

//    Create the Close Button
    Button closeButton = new Button("Exit");
    closeButton.setOnAction(e -> closeButton());
    Region spacingNode = new Region();

//    Add the buttons to a layout pane
    VBox root = new VBox(10, clickMeButton, closeButton);
    root.setAlignment(Pos.CENTER);

//    Finish
    Scene scene = new Scene(root, 250, 150);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Click Counter Exit");
    primaryStage.setOnCloseRequest(e -> {
      e.consume();
      closeButton();
    });

    primaryStage.show();
  }

  private void closeButton()
  {
    Alert a = new Alert(Alert.AlertType.CONFIRMATION,
        "Are you sure you want to quit?",
        ButtonType.YES, ButtonType.NO);
    Optional<ButtonType> confirm = a.showAndWait();
    if (confirm.isPresent() && confirm.get() == ButtonType.YES)
    {
      stage.close();
    }
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




















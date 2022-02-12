package com.lowewriter.scenesswitcher;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScenesSwitcher extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  //  Class field for stage
  Stage stage;

  //  Class fields for ClickCounter scene
  Label displayLabel1;
  Button clickMeButton;
  Button switchSceneButton1;
  int counter1 = 0;
  Scene clickCounterScene;

  //  Class fields for AddSubtract scene
  Label displayLabel2;
  Button addButton;
  Button subtractButton;
  Button switchSceneButton2;
  int counter2 = 0;
  Scene addSubtractScene;

  @Override
  public void start(Stage primaryStage)
  {
//    Set the stage class field to reference the primary stage
    stage = primaryStage;

//    Create the ClickCounter scene
    displayLabel1 = new Label("You have not clicked the button.");
    clickMeButton = new Button("Click me please!");
    clickMeButton.setOnAction(
        e -> clickMeButton_Click());
    switchSceneButton1 = new Button("Switch!");
    switchSceneButton1.setOnAction(
        e -> switchSceneButton1_Click());
    VBox pane1 = new VBox(10, displayLabel1,
        clickMeButton, switchSceneButton1);
    clickCounterScene = new Scene(pane1, 300, 150);

//    Create the AddSubtract scene
    displayLabel2 = new Label(Integer.toString(counter2));
    addButton = new Button("Add");
    addButton.setOnAction(
        e -> addButton_Click());
    subtractButton = new Button("Subtract");
    subtractButton.setOnAction(
        e -> subtractButton_Click());
    switchSceneButton2 = new Button("Switch!");
    switchSceneButton2.setOnAction(
        e -> switchSceneButton2_Click());
    HBox pane2 = new HBox(10, displayLabel2,
        addButton, subtractButton, switchSceneButton2);
    addSubtractScene = new Scene(pane2, 300,150);

//    Finish
    primaryStage.setScene(clickCounterScene);
    primaryStage.setTitle("Scene Switcher");
    primaryStage.show();
  }

  private void subtractButton_Click()
  {
    counter2--;
    displayLabel2.setText(
        Integer.toString(counter2));
  }

  private void addButton_Click()
  {
    counter2++;
    displayLabel2.setText(
        Integer.toString(counter2));
  }

  private void clickMeButton_Click()
  {
    counter1++;
    if (counter1 == 1)
    {
      displayLabel1.setText("You have clicked once.");
    }
    else
    {
      displayLabel1.setText("You have clicked "
          + counter1 + " times.");
    }
  }

  private void switchSceneButton2_Click()
  {
    stage.setScene(clickCounterScene);
  }

  private void switchSceneButton1_Click()
  {
    stage.setScene(addSubtractScene);
  }
}




























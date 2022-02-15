package com.lowewriter.layoutpane_samples;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BorderPaneSample3 extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage stage)
  {
//    Create the top pane
    Button topButton = new Button("Top");
    topButton.setPrefWidth(450);
    HBox topPane = new HBox(10, topButton);
    topPane.setAlignment(Pos.CENTER);

//    Create the left pane
    Button leftButton = new Button("Left");
    leftButton.setPrefWidth(150);
    leftButton.setPrefHeight(550);
    VBox leftPane = new VBox(10, leftButton);
    leftPane.setAlignment(Pos.CENTER);

//    Create the center pane
    Button centerButton = new Button("Center");
    centerButton.setPrefWidth(150);
    centerButton.setPrefHeight(550);
    VBox centerPane = new VBox(10, centerButton);
    centerPane.setAlignment(Pos.CENTER);

//    Create the right pane
    Button rightButton = new Button("Right");
    rightButton.setPrefWidth(150);
    rightButton.setPrefHeight(550);
    VBox rightPane = new VBox(10, rightButton);
    rightPane.setAlignment(Pos.CENTER);


//    Create the bottom pane
    Button bottomButton = new Button("Bottom");
    bottomButton.setPrefWidth(450);
    HBox bottomPane = new HBox(10, bottomButton);
    bottomPane.setAlignment(Pos.CENTER);

//    Create a BorderPane
    BorderPane root = new BorderPane(centerPane, topPane, rightPane, bottomPane, leftPane);

//    Finish
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.setTitle("BorderPane Sample 3");
    stage.show();
  }
}























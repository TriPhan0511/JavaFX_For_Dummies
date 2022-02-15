package com.lowewriter.layoutpane_samples;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneSample extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage stage)
  {
//    Create five buttons
    Button topButton = new Button("Top");
    Button rightButton = new Button("Right");
    Button bottomButton = new Button("Bottom");
    Button leftButton = new Button("Left");
    Button centerButton = new Button("Center");

//    Create a BorderPane
    BorderPane root = new BorderPane();
//    root.setPrefWidth(600);
//    root.setPrefHeight(400);

    root.setTop(topButton);
    root.setRight(rightButton);
    root.setBottom(bottomButton);
    root.setLeft(leftButton);
    root.setCenter(centerButton);

    BorderPane.setAlignment(topButton, Pos.CENTER);
    BorderPane.setAlignment(rightButton, Pos.CENTER);
    BorderPane.setAlignment(bottomButton, Pos.CENTER);
    BorderPane.setAlignment(leftButton, Pos.CENTER);
    BorderPane.setAlignment(centerButton, Pos.CENTER);

//    Finish
//    Scene scene = new Scene(root);
    Scene scene = new Scene(root, 600, 400);
    stage.setScene(scene);
    stage.setTitle("BorderPane");
    stage.show();
  }
}






























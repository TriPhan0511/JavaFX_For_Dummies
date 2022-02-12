package com.lowewriter.testing;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Testing1 extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage)
  {
    Label helloLabel = new Label("Hello, world");
    helloLabel.setFont(Font.font("Arial", 20));
    helloLabel.setTextFill(Color.ORANGERED);
    BorderPane root = new BorderPane();
    root.setCenter(helloLabel);
//    Finish
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Testing 1");
    primaryStage.setMaximized(true);
    primaryStage.setMinWidth(1000);
    primaryStage.setMinHeight(800);
    primaryStage.show();
  }
}
























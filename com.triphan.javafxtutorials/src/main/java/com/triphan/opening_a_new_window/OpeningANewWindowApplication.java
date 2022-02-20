package com.triphan.opening_a_new_window;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class OpeningANewWindowApplication extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws IOException
  {
    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("opening-a-new-window-view.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);

//    Finish
    primaryStage.setScene(scene);
    primaryStage.setTitle("Opening a new Window");
    primaryStage.setMinWidth(1000);
    primaryStage.setMaxWidth(1000);
    primaryStage.setMinHeight(700);
    primaryStage.setMaxHeight(700);
    primaryStage.show();
  }
}























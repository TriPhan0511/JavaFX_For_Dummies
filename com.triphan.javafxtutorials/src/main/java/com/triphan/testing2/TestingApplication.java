package com.triphan.testing2;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TestingApplication extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws IOException
  {
    FXMLLoader fxmlLoader = new FXMLLoader(
        TestingApplication.class.getResource("click-counter-scene-view.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 300, 150);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Scene Switcher");
    primaryStage.show();
  }
}

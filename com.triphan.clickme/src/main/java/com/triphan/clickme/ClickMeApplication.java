package com.triphan.clickme;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ClickMeApplication extends Application
{
//  @Override
//  public void start(Stage primaryStage) throws IOException
//  {
//    FXMLLoader fxmlLoader = new FXMLLoader(
//        ClickMeApplication.class.getResource("click-counter-view.fxml"));
//    primaryStage.setScene(new Scene(fxmlLoader.load(), 320, 240));
//    primaryStage.setTitle("Scene Switcher");
//    primaryStage.show();
//  }

  @Override
  public void start(Stage primaryStage) throws IOException
  {
    Parent root = FXMLLoader.load(getClass().getResource("click-counter-view.fxml"));
    Scene scene = new Scene(root, 320, 240);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Scene Switcher");
    primaryStage.show();
  }

  public static void main(String[] args)
  {
    launch();
  }
}

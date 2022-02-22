package com.batch164.pharmacyapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class PharmacyApplication extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage)
  {
    try
    {
      FXMLLoader loader = new FXMLLoader(
          getClass().getResource("login-view.fxml"));

//      FXMLLoader loader = new FXMLLoader(
//          getClass().getResource("customer-view.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root);

//      Set scene for the primary stage
      primaryStage.setScene(scene);

//      Fix the dimension of the primary stage
      primaryStage.setMinWidth(1000);
      primaryStage.setMaxWidth(1000);
      primaryStage.setMinHeight(700);
      primaryStage.setMaxHeight(700);

      primaryStage.initStyle(StageStyle.UNDECORATED);
      primaryStage.show();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
package com.batch164.pharmacyapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
      Parent root = loader.load();
      Scene scene = new Scene(root);

      primaryStage.setScene(scene);
      primaryStage.setTitle("Get Well Pharmacy");
      primaryStage.show();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}

package com.triphan.communication_between_controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
  public void start(Stage stage)
  {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("scene3-view.fxml"));
    try
    {
      Parent root = loader.load();
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.setTitle("Communication between Scene3Controller and Scene4Controller");
      stage.show();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}

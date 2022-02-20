package com.triphan.login_form_sample_2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class LoginApplication extends Application
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
      Scene scene = new Scene(root, 520, 400);

//      Finish
      primaryStage.setScene(scene);
      primaryStage.initStyle(StageStyle.UNDECORATED);
      primaryStage.show();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }

  }
}



























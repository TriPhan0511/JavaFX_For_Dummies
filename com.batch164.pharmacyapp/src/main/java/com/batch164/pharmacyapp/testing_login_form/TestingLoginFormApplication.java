package com.batch164.pharmacyapp.testing_login_form;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class TestingLoginFormApplication extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage stage)
  {

    try
    {
      FXMLLoader loader = new FXMLLoader(
          getClass().getResource("login-form-view.fxml"));
      Parent root = loader.load();
      Scene scene = new Scene(root);

//      Finish
      stage.setScene(scene);
      stage.setTitle("Testing Login Form");
      stage.setMinWidth(1000);
      stage.setMaxWidth(1000);
      stage.setMinHeight(700);
      stage.setMaxHeight(700);
      stage.show();
    } catch (IOException e)
    {
      e.printStackTrace();
    }

  }
}



































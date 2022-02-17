package com.triphan.login_form_sample;

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
  public void start(Stage stage) throws IOException
  {
    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("login-view.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);

//    Finish
    stage.setScene(scene);
    stage.setTitle("Login Form Sample");
    stage.setMinWidth(520); // same preferred width of the root
    stage.setMaxWidth(520); // same preferred width of the root
    stage.setMinHeight(400); // same preferred height of the root
    stage.setMaxHeight(400); // same preferred height of the root
    stage.initStyle(StageStyle.UNDECORATED);
    stage.show();
  }
}




























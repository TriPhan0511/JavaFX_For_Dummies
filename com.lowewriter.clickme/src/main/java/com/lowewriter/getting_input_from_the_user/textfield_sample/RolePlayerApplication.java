package com.lowewriter.getting_input_from_the_user.textfield_sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This sample demonstrates how to use TextField
 */
public class RolePlayerApplication extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws IOException
  {
    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("role-player-view.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);

//    Finish
    stage.setScene(scene);
    stage.setTitle("Role Player");
    stage.show();
  }
}



















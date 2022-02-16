package com.lowewriter.getting_input_from_the_user.checkboxes_sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This sample demonstrates how to use CheckBox
 */
public class ToppingsApplication extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws IOException
  {
    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("toppings-view.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);

//    Finish
    stage.setScene(scene);
    stage.setTitle("Toppings");
    stage.show();
  }
}





















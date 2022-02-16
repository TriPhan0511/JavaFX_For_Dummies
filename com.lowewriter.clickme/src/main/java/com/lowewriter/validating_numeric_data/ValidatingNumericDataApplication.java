package com.lowewriter.validating_numeric_data;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ValidatingNumericDataApplication extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws IOException
  {
    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("validating-numeric-data-view.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);

//    Finish
    stage.setScene(scene);
    stage.setTitle("Validating Numeric Data");
    stage.show();
  }
}
























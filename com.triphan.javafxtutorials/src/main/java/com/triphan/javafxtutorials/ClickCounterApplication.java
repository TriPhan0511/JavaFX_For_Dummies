package com.triphan.javafxtutorials;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ClickCounterApplication extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws IOException
  {
    FXMLLoader fxmlLoader = new FXMLLoader(
        ClickCounterApplication.class.getResource("click-counter-view.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 400, 75);
    stage.setScene(scene);
    stage.setTitle("Click Counter");
    stage.show();
  }
}

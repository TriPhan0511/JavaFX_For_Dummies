package com.triphan.scenes_switcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ScenesSwitcherApplication extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws IOException
  {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("scene1-view.fxml"));
    Parent root = loader.load();

//    Finish
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.setTitle("Scenes Switcher");
    stage.show();
  }
}































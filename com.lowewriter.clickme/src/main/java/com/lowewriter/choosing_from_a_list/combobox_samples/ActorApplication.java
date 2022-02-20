package com.lowewriter.choosing_from_a_list.combobox_samples;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ActorApplication extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws IOException
  {
    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("actor-view.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.setTitle("ComboBox Sample (Actor)");
    primaryStage.show();
  }
}

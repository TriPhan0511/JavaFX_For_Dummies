package com.triphan.anchorpane_sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AnchorPaneSampleApplication extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage stage) throws IOException
  {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("anchorpane-sample-view.fxml"));
    Parent root = loader.load();

//    Finish
//    Scene scene = new Scene(root, 550, 250);
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.setTitle("AnchorPane Layout Sample");
    stage.show();
  }
}

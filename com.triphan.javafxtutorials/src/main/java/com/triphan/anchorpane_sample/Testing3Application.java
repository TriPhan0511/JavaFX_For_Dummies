package com.triphan.anchorpane_sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Testing3Application extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage stage)
  {
    AnchorPane root = new AnchorPane();

//    Anchor the label to the lower-lef side of the pane with a 10-pixels offset
    Label greetingLabel = new Label("Hello, world!");
    root.getChildren().add(greetingLabel);
    AnchorPane.setLeftAnchor(greetingLabel, 10.0);
    AnchorPane.setBottomAnchor(greetingLabel, 10.0);

    Label morningLabel = new Label("Good morning!");
    root.getChildren().add(morningLabel);
    AnchorPane.setTopAnchor(morningLabel, 20.0);
    AnchorPane.setRightAnchor(morningLabel, 20.0);

//    Finish
    Scene scene = new Scene(root, 600, 400);
    stage.setScene(scene);
    stage.setTitle("AnchorPane Sample");
    stage.show();
  }
}





























package com.lowewriter.layoutpane_samples;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class AddingSpacesByGrowingNodes_HBox extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage stage)
  {
//    Create three buttons
    Button button1 = new Button("Button One");
    Button button2 = new Button("Button Two");
    Button button3 = new Button("Button Three");

//    Create a spacer node
    Region spacer = new Region();

//    Set the margins
    HBox.setMargin(button1, new Insets(10));
    HBox.setMargin(button2, new Insets(10));
    HBox.setMargin(button3, new Insets(10));

//    HBox.setMargin(spacer, new Insets(0,0,0,-10));

//    Set the Hgrow for the spacer
    HBox.setHgrow(spacer, Priority.ALWAYS);

//    Create a HBox and add the buttons and the spacer node to HBox pane
    HBox root = new HBox(10, button1, button2, spacer, button3);

//    Finish
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.setTitle("Adding Spaces by Growing Nodes");
    stage.show();
  }
}
















































package com.lowewriter.layoutpane_samples;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddingSpacesByGrowingNodes_VBox extends Application
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

//    Create a spacer
    Region spacer = new Region();

//    Create a VBox
    VBox root = new VBox(button1, button2, spacer, button3);

//    Set margins
    VBox.setMargin(button1, new Insets(10));
    VBox.setMargin(button2, new Insets(10));
    VBox.setMargin(button3, new Insets(10));

//    Set VGrow for the spacer
    VBox.setVgrow(spacer, Priority.ALWAYS);

//    Finish
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.setTitle("Adding Spaces By Growing Nodes - VBox");
    stage.show();
  }
}




























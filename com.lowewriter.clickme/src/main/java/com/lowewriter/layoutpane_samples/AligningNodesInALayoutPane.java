package com.lowewriter.layoutpane_samples;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AligningNodesInALayoutPane extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage stage)
  {
//    Create three buttons
    Button button1 = new Button("Number One");
    Button button2 = new Button("Two");
    Button button3 = new Button("The Third Button");

//    Create a VBox pane and add the buttons to the pane
    VBox root = new VBox(10, button1, button2, button3);

//    Set alignment
//    root.setAlignment(Pos.CENTER);
    root.setAlignment(Pos.BOTTOM_RIGHT);

//    Finish
    Scene scene = new Scene(root, 500, 400);
    stage.setScene(scene);
    stage.setTitle("Aligning Nodes In A Layout Pane");
    stage.show();
  }
}






























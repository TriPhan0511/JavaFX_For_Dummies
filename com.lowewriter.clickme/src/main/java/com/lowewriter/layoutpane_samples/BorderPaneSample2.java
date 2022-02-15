package com.lowewriter.layoutpane_samples;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BorderPaneSample2 extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage stage)
  {
//    Create a buttons pane
    Button button1 = new Button("Button One");
    Button button2 = new Button("Button Two");
    Button button3 = new Button("Button Three");
    VBox vBox = new VBox(10, button1, button2, button3);


//    Create a BorderPane and add the vBox to its center
    BorderPane root = new BorderPane();
    root.setCenter(vBox);

//    Finish
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.setTitle("BorderPane Sample 2");
    stage.show();
  }
}





































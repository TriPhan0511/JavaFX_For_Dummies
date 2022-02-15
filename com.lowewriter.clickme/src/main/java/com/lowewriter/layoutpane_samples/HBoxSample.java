package com.lowewriter.layoutpane_samples;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HBoxSample extends Application
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

//    Create a HBox pane
    HBox root = new HBox(10, button1, button2, button3);
    root.setPadding(new Insets(0,10,10,10));

    HBox.setMargin(button1, new Insets(20));

//    Finish
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.setTitle("HBox");
    stage.show();
  }
}




































package com.lowewriter.layoutpane_samples;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FlowPaneSample extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage stage)
  {
//    Create five buttons
    Button button1 = new Button("Button One");
    Button button2 = new Button("Button Two");
    Button button3 = new Button("Button Three");
    Button button4 = new Button("Button Four");
    Button button5 = new Button("Button Five");

//    Create a FlowPane
//    FlowPane root = new FlowPane(10, 10,
//        button1, button2, button3, button4, button5);
//    root.setPadding(new Insets(0, 10, 10, 10));

    FlowPane root = new FlowPane(Orientation.HORIZONTAL,
        10, 10, button1, button2, button3, button4, button5);
    root.setPrefWrapLength(300);

//    Finish
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.setTitle("FlowPane");
    stage.show();
  }
}









































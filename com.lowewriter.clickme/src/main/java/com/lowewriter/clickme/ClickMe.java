package com.lowewriter.clickme;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ClickMe extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  //  Class field
  Button clickMeButton;

  @Override
  public void start(Stage primaryStage)
  {
//    Create the button
    clickMeButton = new Button("Click me please!");
    clickMeButton.setOnAction(e -> clickMeButton_Click());

//    Add the button to a layout pane
    BorderPane pane = new BorderPane();
    pane.setCenter(clickMeButton);
    pane.setBorder(new Border(new BorderStroke(Color.ORANGERED,
        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

//    Add the layout pane to a scene
    Scene scene = new Scene(pane, 300, 250);

//    Finalize and show the stage
    primaryStage.setScene(scene);
    primaryStage.setTitle("The Click Me App");
    primaryStage.show();
  }

  private void clickMeButton_Click()
  {
    if (clickMeButton.getText().equalsIgnoreCase("Click me please!"))
    {
      clickMeButton.setText("You clicked me!");
    }
    else
    {
      clickMeButton.setText("Click me please!");
    }
  }


// DO IT MYSELF
//  //  Class fields
//  Button clickMeButton;
//  boolean isClicked = false;
//
//  @Override
//  public void start(Stage primaryStage)
//  {
////    Initialize the clickMeButton
//    clickMeButton = new Button("Click me please!");
//    clickMeButton.setOnAction(e -> clickMeButton_Click());
//
////    Create a Vbox pane
//    HBox pane = new HBox(clickMeButton);
//    pane.setAlignment(Pos.CENTER);
//    pane.setBorder(new Border(new BorderStroke(Color.ORANGERED,
//                              BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
//
////    Finish
//    Scene scene = new Scene(pane);
//    primaryStage.setScene(scene);
//    primaryStage.setTitle("The Click Me App");
//    primaryStage.setMinWidth(300);
//    primaryStage.setMinHeight(250);
//    primaryStage.show();
//  }
//
//  private void clickMeButton_Click()
//  {
//    if (!isClicked)
//    {
//      clickMeButton.setText("You clicked me!");
//    }
//    else
//    {
//      clickMeButton.setText("Click me please!");
//    }
//    isClicked = !isClicked;
//  }
}

































package com.triphan.testing;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class HelloFX extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  Button sayHelloButton;
  TextField nameTextField;

  @Override
  public void start(Stage primaryStage)
  {
    Label nameLabel = new Label("Your name:");
    nameTextField = new TextField();
    nameTextField.setMinWidth(100);
    HBox namePane = new HBox(10, nameLabel, nameTextField);
    namePane.setPadding(new Insets(10));
    namePane.setBorder(new Border(new BorderStroke(
        Color.GREEN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
//    namePane.setAlignment(Pos.CENTER_RIGHT);
    namePane.setAlignment(Pos.CENTER);

    sayHelloButton = new Button("Say Hello");
    sayHelloButton.setOnAction(e -> sayHelloButton_Click());
    HBox buttonPane = new HBox(10, sayHelloButton);
    buttonPane.setPadding(new Insets(10));
    buttonPane.setBorder(new Border(new BorderStroke(
        Color.BLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
//    buttonPane.setAlignment(Pos.BOTTOM_RIGHT);
    buttonPane.setAlignment(Pos.CENTER);

    VBox rootPane = new VBox(10, namePane, buttonPane);
    rootPane.setBorder(new Border(new BorderStroke(
        Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    rootPane.setAlignment(Pos.CENTER);

//    Finish
    Scene scene = new Scene(rootPane);
    primaryStage.setScene(scene);
    primaryStage.setMinWidth(400);
    primaryStage.setMinHeight(600);
    primaryStage.setTitle("HelloFX");
    primaryStage.show();
  }

  private void sayHelloButton_Click()
  {
    Alert a = new Alert(Alert.AlertType.INFORMATION, "Hello, " + nameTextField.getText());
    a.showAndWait();
    nameTextField.setText("");
    nameTextField.requestFocus();
  }

}































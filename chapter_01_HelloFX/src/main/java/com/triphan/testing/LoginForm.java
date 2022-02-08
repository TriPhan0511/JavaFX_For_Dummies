package com.triphan.testing;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginForm extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  //  Class fields
  TextField idTextField;
  PasswordField passwordField;
  Button loginButton;
  Button resetButton;

  @Override
  public void start(Stage primaryStage)
  {
//    Create the id pane
    Label idLabel = new Label("ID");
    idTextField = new TextField();
    idTextField.setMinWidth(100);

//    Create the password pane
    Label passwordLabel = new Label("Password");
    passwordField = new PasswordField();
    passwordField.setMinWidth(100);

//    Create two buttons
    loginButton = new Button("Login");
    loginButton.setMinWidth(70);
    loginButton.setOnAction(e -> loginButton_Click());
    resetButton = new Button("Reset");
    resetButton.setMinWidth(70);
    resetButton.setOnAction(e -> resetButton_Click());
    HBox buttonPane = new HBox(10, loginButton, resetButton);
    buttonPane.setAlignment(Pos.BOTTOM_RIGHT);

//    Create a grid pane
    GridPane gridPane = new GridPane();
    gridPane.setPadding(new Insets(10));
    gridPane.setVgap(10);
    gridPane.setHgap(10);
    gridPane.setMinWidth(400);
    gridPane.setMaxWidth(500);
    gridPane.addRow(0, idLabel, idTextField);
    gridPane.addRow(1, passwordLabel, passwordField);
    gridPane.add(buttonPane, 1, 2);
//    gridPane.setBorder(new Border(new BorderStroke(
//        Color.BLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

    GridPane.setHalignment(idLabel, HPos.RIGHT);
    GridPane.setHalignment(passwordLabel, HPos.RIGHT);

    ColumnConstraints col1 = new ColumnConstraints();
    col1.setPercentWidth(20);
    ColumnConstraints col2 = new ColumnConstraints();
    col2.setPercentWidth(75);
    gridPane.getColumnConstraints().addAll(col1, col2);

//    Create a root pane
    VBox pane = new VBox(gridPane);
    pane.setAlignment(Pos.CENTER);
//    pane.setBorder(new Border(new BorderStroke(
//        Color.RED, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

//    Finish
    Scene scene = new Scene(pane);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Login Form");
    primaryStage.setMinWidth(400);
    primaryStage.setMinHeight(600);
    primaryStage.show();
  }

  private void resetButton_Click()
  {
  }

  private void loginButton_Click()
  {
  }
}






















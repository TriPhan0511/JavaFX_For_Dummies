package com.triphan.stageandscene;

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
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginForm2 extends Application
{

  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage)
  {
//    Create the labels
    Label greetingLabel =
        new Label("Welcome To The Better Life Pharmacy Application!");
    greetingLabel.setFont(Font.font("Arial", 25));
    greetingLabel.setTextFill(Color.YELLOWGREEN);

    Label idErrorLabel = new Label("ID Error Message");
//    Label idErrorLabel = new Label();
    idErrorLabel.setTextFill(Color.RED);
    Label passwordErrorLabel = new Label("Password Error Message");
//    Label passwordErrorLabel = new Label();
    passwordErrorLabel.setTextFill(Color.RED);

    Label idLabel = new Label("ID");
    Label passwordLabel = new Label("Password");

//    Create the text fields
    TextField idTextField = new TextField();
    PasswordField passwordField = new PasswordField();

//    Create the buttons
    Button resetButton = new Button("Reset");
    resetButton.setMinWidth(75);
    Button loginButton = new Button("Log in");
    loginButton.setMinWidth(75);
    HBox buttonPane = new HBox(10, resetButton, loginButton);
    buttonPane.setAlignment(Pos.BOTTOM_RIGHT);
//    buttonPane.setBorder(new Border(new BorderStroke(Color.YELLOWGREEN,
//        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

//    Create a GridPane
    GridPane grid = new GridPane();
    grid.setMinWidth(400);
    grid.setMaxWidth(400);
    grid.setMinHeight(180);
    grid.setMaxHeight(180);
    grid.setPadding(new Insets(10));
    ColumnConstraints col1 = new ColumnConstraints();
    col1.setPercentWidth(30);
    ColumnConstraints col2 = new ColumnConstraints();
    col2.setPercentWidth(65);
    grid.getColumnConstraints().addAll(col1, col2);
    grid.setVgap(5);
    grid.setHgap(10);
    grid.add(idErrorLabel, 1, 0);
    grid.addRow(1, idLabel, idTextField);
    grid.add(passwordErrorLabel, 1, 2);
    grid.addRow(3, passwordLabel, passwordField);
    grid.add(buttonPane, 1, 4);
    GridPane.setMargin(passwordErrorLabel, new Insets(5,0,0,0));
    GridPane.setMargin(buttonPane, new Insets(10,0,0,0));
    GridPane.setHalignment(idLabel, HPos.RIGHT);
    GridPane.setHalignment(passwordLabel, HPos.RIGHT);
    grid.setBorder(new Border(new BorderStroke(Color.SILVER,
        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

//    Create a root node
    VBox root = new VBox(20, greetingLabel, grid);
    root.setAlignment(Pos.CENTER);

//    Finish
    Scene scene = new Scene(root, 1000, 500);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Login Form 2");
    primaryStage.show();
  }
}




































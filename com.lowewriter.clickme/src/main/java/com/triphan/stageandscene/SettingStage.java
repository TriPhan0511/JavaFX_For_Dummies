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

/**
 * Examining the Stage Class.
 * Use primaryStage.setMinWidth = 1000,
 * primaryStage.setMinHeight = 500
 */
public class SettingStage extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage)
  {
//    Create the labels
    Label greetingLabel = new Label("Welcome To The Better Life Pharmacy Application!");
    greetingLabel.setFont(Font.font("Arial", 25));
    greetingLabel.setTextFill(Color.ORANGE);

    Label idErrorLabel = new Label("ID Error Message");
//    Label idErrorLabel = new Label();
    idErrorLabel.setTextFill(Color.RED);
    Label passwordErrorLabel = new Label("Password Error Message");
//    Label passwordErrorLabel = new Label();
    passwordErrorLabel.setTextFill(Color.RED);

    Label idLabel = new Label("ID:");
    Label passwordLabel = new Label("Password:");
//    Create the text field and the password field
    TextField idTextField = new TextField();
    PasswordField passwordField = new PasswordField();
//    Create the buttons pane
    Button resetButton = new Button("Reset");
    Button loginButton = new Button("Log in");
    HBox buttonPane = new HBox(10, resetButton, loginButton);
    buttonPane.setAlignment(Pos.BOTTOM_RIGHT);
//    buttonPane.setBorder(new Border(new BorderStroke(Color.YELLOWGREEN,
//        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

//    Create a GridPane
    GridPane grid = new GridPane();
//    grid.setBorder(new Border(new BorderStroke(Color.ORANGERED,
//        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    grid.setPadding(new Insets(10));
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setMinWidth(350);
    grid.setMaxWidth(350);
    grid.setMinHeight(120);
    grid.setMaxHeight(120);
    grid.add(idErrorLabel, 1, 0);
    grid.addRow(1, idLabel, idTextField);
    grid.add(passwordErrorLabel,1,2);
    grid.addRow(3, passwordLabel, passwordField);
    grid.add(buttonPane, 1, 4);
    GridPane.setHalignment(idLabel, HPos.RIGHT);
    GridPane.setHalignment(passwordLabel, HPos.RIGHT);
    GridPane.setMargin(buttonPane, new Insets(10, 0,0,0));

    ColumnConstraints col1 = new ColumnConstraints();
    col1.setPercentWidth(30);
    ColumnConstraints col2 = new ColumnConstraints();
    col2.setPercentWidth(65);
    grid.getColumnConstraints().addAll(col1, col2);

    VBox root = new VBox(20, greetingLabel, grid);
    root.setAlignment(Pos.CENTER);

//    Finish
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Login Form");
//    primaryStage.setMaximized(true);
    primaryStage.setMinWidth(1000);
    primaryStage.setMinHeight(500);
    primaryStage.setMaxWidth(1200);
    primaryStage.setMaxHeight(700);
    primaryStage.show();
  }
}


































package com.triphan.searchbar_and_tableview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SearchBarAndTableViewApplication extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws IOException
  {
    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("searchbar_and_tableview-view.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root, 1080, 600);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Search Bar and TableView filter result as you search");
    primaryStage.show();
  }
}

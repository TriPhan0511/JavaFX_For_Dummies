package com.triphan.college;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class ShowStudent extends Application
{
  public static void main(String[] args)
  {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage)
  {
//    Create a ListView
    ListView<Student> studentListView = new ListView<>(getData());

//    Create a pane
    VBox pane = new VBox(10, studentListView);

//    Finish
    Scene scene = new Scene(pane);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Show Students");
    primaryStage.show();
  }

  private ObservableList<Student> getData()
  {
    ObservableList<Student> students = FXCollections.observableArrayList();
    students.add(new Student("001", "Zed", LocalDate.parse("1984-11-05"), "12345"));
    students.add(new Student("002", "Yoo", LocalDate.parse("1984-11-05"), "12345"));
    students.add(new Student("003", "Kelly", LocalDate.parse("1984-11-05"), "12345"));
    students.add(new Student("004", "Fred", LocalDate.parse("1984-11-05"), "12345"));
    students.add(new Student("005", "Harry", LocalDate.parse("1984-11-05"), "12345"));
    return students;
  }
}
































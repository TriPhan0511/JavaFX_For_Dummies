package com.triphan.college;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class ShowStudentDatabase extends Application
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
    primaryStage.setTitle("Show Students - Database");
    primaryStage.show();
  }

  private ObservableList<Student> getData()
  {
    ObservableList<Student> students = FXCollections.observableArrayList();
    String tempStudentID;
    String tempStudentName;
    String tempDateOfBirthString;
    LocalDate tempDateOfBirth;
    String tempPhoneNumber;
    String sql = "SELECT StudentID, StudentName, DateOfBirth, PhoneNumber " +
        "FROM Students";
    try (Connection conn = DatabaseHandler.getConnection();
          PreparedStatement stat = conn.prepareStatement(sql))
    {
      ResultSet result = stat.executeQuery();
      while (result.next())
      {
        tempStudentID = result.getString("StudentID");
        tempStudentName = result.getString("StudentName");
        tempDateOfBirthString = result.getString("DateOfBirth");
        if (tempDateOfBirthString == null)
        {
          tempDateOfBirth = null;
        }
        else
        {
          tempDateOfBirth = LocalDate.parse(tempDateOfBirthString);
        }
        tempPhoneNumber = result.getString("PhoneNumber");
        students.add(new Student(
            tempStudentID, tempStudentName, tempDateOfBirth, tempPhoneNumber));
      }
    }
    catch (SQLException e)
    {
      for (Throwable t : e)
      {
        t.printStackTrace();
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    return students;
  }
}


























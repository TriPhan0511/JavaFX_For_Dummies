package com.triphan.scenes_communication;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene1Controller
{
  @FXML
  Button sendDataButton;

  @FXML
  private void sendDataButton_Click(ActionEvent event) throws IOException
  {
//    Get root and create a new scene
    FXMLLoader loader = new FXMLLoader(getClass().getResource("scene2-view.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);

//    Display something on the scene 2
    Scene2Controller scene2Controller = loader.getController();
    scene2Controller.displayEmployee(getEmployee());
    scene2Controller.setDataForListView(getEmployees());

//    Finish
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
  }

  private Employee getEmployee()
  {
    return new Employee("Kelly Bruce", 60);
  }

  private ObservableList<Employee> getEmployees()
  {
    ObservableList<Employee> employees = FXCollections.observableArrayList();
    employees.add(new Employee("Alex Ferguson", 75));
    employees.add(new Employee("Hillary Duff", 40));
    employees.add(new Employee("Bobby Charlton", 100));
    employees.add(new Employee("Spider Mane", 20));
    employees.add(new Employee("Brad Pitt", 45));
    employees.add(new Employee("Rose Mary", 18));
    return employees;
  }
}



























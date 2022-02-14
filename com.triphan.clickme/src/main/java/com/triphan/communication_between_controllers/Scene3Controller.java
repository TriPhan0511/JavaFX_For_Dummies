package com.triphan.communication_between_controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Scene3Controller
{

  private Stage stage;
  private Scene scene;
  private Parent root;

  public void sendData1(ActionEvent event) throws IOException
  {
    ArrayList<Employee> employees = getData();
    ObservableList<Employee> employeeObservableList =
        FXCollections.observableList(employees);

    FXMLLoader loader = new FXMLLoader(getClass().getResource("scene4-view.fxml"));

    Scene4Controller scene4Controller = loader.getController();
    scene4Controller.setDataForEmployeeListView(employeeObservableList);

    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    root = loader.load();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void sendData2(ActionEvent event) throws IOException
  {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("scene4-view.fxml"));
    root = loader.load();

    ArrayList<Employee> employees = getData();
    ObservableList<Employee> employeeObservableList =
        FXCollections.observableList(employees);

    Scene4Controller scene4Controller = loader.getController();
    scene4Controller.setDataForEmployeeListView(employeeObservableList);

    scene = new Scene(root);
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
  }

  public void sendData(ActionEvent event) throws IOException
  {
//    Get data
    ArrayList<Employee> employees = getData();
    ObservableList<Employee> employeeObservableList =
        FXCollections.observableList(employees);

    FXMLLoader loader = new FXMLLoader(getClass().getResource("scene4-view.fxml"));
    root = loader.load();

    Scene4Controller scene4Controller = loader.getController();
    scene4Controller.setDataForEmployeeListView(employeeObservableList);

    scene = new Scene(root);
    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
  }

  private ArrayList<Employee> getData()
  {
    ArrayList<Employee> employees = new ArrayList<>();
    employees.add(new Employee("Alex Ferguson"));
    employees.add(new Employee("Brad Pit"));
    employees.add(new Employee("Rose Marry"));
    employees.add(new Employee("Hillary Duff"));
    employees.add(new Employee("White Horse"));
    return employees;
  }
}

package com.triphan.communication_between_controllers;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class Scene4Controller
{
  @FXML
  ListView<Employee> employeeListView;

  public void setDataForEmployeeListView(
      ObservableList<Employee> employeeObservableList)
  {
    employeeListView.setItems(employeeObservableList);
  }
}

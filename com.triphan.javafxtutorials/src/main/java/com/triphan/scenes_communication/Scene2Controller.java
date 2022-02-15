package com.triphan.scenes_communication;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class Scene2Controller
{
  @FXML
  Label displayEmployeeLabel;
  @FXML
  ListView<Employee> employeeListView;

  public void displayEmployee(Employee employee)
  {
    displayEmployeeLabel.setText(employee.toString());
  }

  public void setDataForListView(ObservableList<Employee> employees)
  {
    employeeListView.setItems(employees);
  }
}

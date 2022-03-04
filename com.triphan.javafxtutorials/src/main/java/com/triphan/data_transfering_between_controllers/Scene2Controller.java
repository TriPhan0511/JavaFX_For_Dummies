package com.triphan.data_transfering_between_controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Scene2Controller
{
  @FXML
  private Label displayLabel;

  public void displayMessage(String userName)
  {
    displayLabel.setText("Hello, " + userName);
  }

  //  Class field
  private String name;

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
//    Testing
    System.out.println("HERE");
  }

  public void displayMessage2()
  {
    System.out.println("Aloha, " + name);
  }
//  -------------------------------------------------

  //  Another class field
  private Employee employee;

  public Employee getEmployee()
  {
    return employee;
  }

  public void setEmployee(Employee employee)
  {
    this.employee = employee;
  }

  public void displayMessage3()
  {
    displayLabel.setText("Good evening, " + employee.getName());
  }
//  -----------------------------------------------------------------

  @FXML
  private Button talkButton;
  @FXML
  private void talkButton_Click()
  {
    displayLabel.setText("Hello, my name's "
        + employee.getName()
        + ". I am "
        + employee.getAge()
        + " years old."
    );
  }
}




























package com.batch164.pharmacyapp;

import com.batch164.pharmacyapp.model.Employee;
import com.batch164.pharmacyapp.model.MyController;
import com.batch164.pharmacyapp.model.Store;
import com.batch164.pharmacyapp.utils.scenehandler.SceneHandler;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class SupervisorController implements MyController
{

  //  ------- Belows are the common fields and methods for every scene ----------
  @FXML
  private Label welcomeLabel;
  @FXML
  private Label currentStoreLabel;

  private Employee currentUser;
  private Store currentStore;

  @Override
  public void setCurrentUser(Employee currentUser)
  {
    this.currentUser = currentUser;
  }

  @Override
  public void setCurrentStore(Store currentStore)
  {
    this.currentStore = currentStore;
  }

  @Override
  public void displayWelcomeMessage()
  {
    welcomeLabel.setText("Welcome, " + currentUser.getFullName() + " (supervisor)!");
  }

  @Override
  public void displayCurrentStore()
  {
    currentStoreLabel.setText("You are in " + currentStore.getStoreName() + ".");
  }
//  -------------------------------------------------------------------------------------------------

  @FXML
  private Button exitButton;
  @FXML
  private void exitButton_Click(ActionEvent event)
  {
    Stage stage = (Stage) ((Node) event.getSource()).
        getScene().getWindow();
    stage.close();
  }

  @FXML
  private Button logoutButton;
  @FXML
  private void logoutButton_Click(ActionEvent event)
  {
    try
    {
      SceneHandler.switchScene("login-system-view.fxml", event);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  @FXML
  private Button changePassword;
  @FXML
  private void changePassword_Click()
  {
//    TODO
    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Under construction!");
    alert.show();
  }

//  ---------------------------------------------------------------------------------------

  //  ------- Belows are the individual fields and methods for staff scene ----------
  @FXML
  private Button employeeManagementButton;
  @FXML
  private void employeeManagementButton_Click(ActionEvent event) throws IOException
  {
    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("employee-supervisor-view.fxml"));
    SceneHandler.setInformationAndSwitchScene(loader, currentStore, currentUser, event);
  }
}

























package com.batch164.pharmacyapp;

import com.batch164.pharmacyapp.model.Employee;
import com.batch164.pharmacyapp.model.InformationDisplayable;
import com.batch164.pharmacyapp.model.Store;
import com.batch164.pharmacyapp.utils.scenehandler.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ManagerController implements InformationDisplayable
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
    welcomeLabel.setText("Welcome, " + currentUser.getFullName() + " (manager)!");
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
  private void changePassword_Click(ActionEvent event) throws IOException
  {
    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("password-changing-view.fxml"));
    SceneHandler.setInformationAndSwitchScene(loader, currentStore, currentUser, event);
  }

//  ---------------------------------------------------------------------------------------

  //  ------- Belows are the individual fields and methods for staff scene ----------
  @FXML
  private Button employeeManagementButton;
  @FXML
  private void employeeManagementButton_Click(ActionEvent event) throws IOException
  {
    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("employee-manager-view.fxml"));
    SceneHandler.setInformationAndSwitchScene(loader, currentStore, currentUser, event);
  }
}

























package com.batch164.pharmacyapp;

import com.batch164.pharmacyapp.model.Employee;
import com.batch164.pharmacyapp.model.MyController;
import com.batch164.pharmacyapp.model.Store;
import com.batch164.pharmacyapp.utils.scenehandler.SceneHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class StaffController implements MyController
{
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
    welcomeLabel.setText("Welcome, " + currentUser.getFullName() + " (staff)!");
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

//  ------- Belows are the individual fields and methods for this scene ----------
  @FXML
  private Button sellingButton;
  @FXML
  void sellingButton_Click(ActionEvent event)
  {
//    TODO
  }

  @FXML
  private Button customerManagementButton;
  @FXML
  void customerManagementButton_Click(ActionEvent event) throws IOException
  {
    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("customer-view.fxml"));
    SceneHandler.setInformationAndSwitchScene(loader, currentStore, currentUser, event);
  }

  @FXML
  private Button productSearchingButton;
  @FXML
  void productSearchingButton_Click(ActionEvent event) throws IOException
  {
    FXMLLoader loader = new FXMLLoader(
        getClass().getResource("product-searching-view.fxml"));
    SceneHandler.setInformationAndSwitchScene(loader, currentStore, currentUser, event);
  }
}




























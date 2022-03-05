package com.batch164.pharmacyapp.utils.scenehandler;

import com.batch164.pharmacyapp.PharmacyApplication;
import com.batch164.pharmacyapp.model.Employee;
import com.batch164.pharmacyapp.model.MyController;
import com.batch164.pharmacyapp.model.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneHandler
{
  public static void switchScene(String view, ActionEvent event) throws IOException
  {
    FXMLLoader loader = new FXMLLoader(PharmacyApplication.class.getResource(view));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
  }

  public static void setWelcomeLabel(Label welcomeLabel,
                                     Employee currentEmployee,
                                     Store currentStore)
  {
    StringBuilder builder = new StringBuilder();
    builder.append("Welcome ");
    builder.append(currentEmployee.getFullName());
    builder.append("!, You are in the ");
    builder.append(currentStore.getStoreID());

    welcomeLabel.setText(builder.toString());
  }

  public static void setInformationAndSwitchScene(
      FXMLLoader loader, Store currentStore,
      Employee currentUser, ActionEvent event) throws IOException
  {
    Parent root = loader.load();

    MyController controller = loader.getController();
    controller.setCurrentUser(currentUser);
    controller.displayWelcomeMessage();

    controller.setCurrentStore(currentStore);
    controller.displayCurrentStore();


    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
  }

//  public static void setInformationAndSwitchScene(
//      FXMLLoader loader, MyController controller, Store currentStore,
//      Employee currentUser, ActionEvent event) throws IOException
//  {
//    Parent root = loader.load();
//
//    controller = loader.getController();
//    controller.setCurrentUser(currentUser);
//    controller.displayWelcomeMessage();
//
//    controller.setCurrentStore(currentStore);
//    controller.displayCurrentStore();
//
//
//    Scene scene = new Scene(root);
//    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//    stage.setScene(scene);
//  }

}




























package com.batch164.pharmacyapp.utils.scenehandler;

import com.batch164.pharmacyapp.PharmacyApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
}

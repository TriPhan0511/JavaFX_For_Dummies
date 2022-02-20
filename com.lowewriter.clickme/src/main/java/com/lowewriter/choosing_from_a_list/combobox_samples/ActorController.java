package com.lowewriter.choosing_from_a_list.combobox_samples;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ActorController implements Initializable
{

  @FXML
  private ComboBox<Actor> actorComboBox;

  @FXML
  private ComboBox<GenderType> genderComboBox;

  @FXML
  private Button showButton;

  private ObservableList<Actor> actors;
  private ObservableList<Actor> actresses;
  private String chooseActor = "Choose an actor";
  private String chooseActress = "Choose an actress";

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle)
  {
//    Set data for the genderComboBox
    ObservableList<GenderType> genders = FXCollections.observableArrayList();
    genders.addAll(GenderType.MALE, GenderType.FEMALE);
    genderComboBox.setItems(genders);

//    Set default value for the genderComboBox
    genderComboBox.setValue(GenderType.MALE);

//    Create data for the actorComboBox
    actors = FXCollections.observableArrayList();
    actors.addAll(new Actor("Brad", "Pitt"),
        new Actor("Daniel", "Craig"),
        new Actor("Tommy", "Harrison"));
    actresses = FXCollections.observableArrayList();
    actresses.addAll(new Actor("Rose", "Mary"),
        new Actor("Kate", "Winslet"),
        new Actor("Mary", "Harry"));

//    Set default data for the actorComboBox,
//    and set default prompt text for the actorComboBox
    if (genderComboBox.getValue() == GenderType.MALE)
    {
      actorComboBox.setItems(actors);
      actorComboBox.setPromptText("Choose an actor");
    }
    else
    {
      actorComboBox.setItems(actresses);
      actorComboBox.setPromptText("Choose an actress");
    }
  }

  @FXML
  void genderComboBox_Change(ActionEvent event)
  {
    if (genderComboBox.getValue() == GenderType.MALE)
    {
      actorComboBox.setItems(actors);
      actorComboBox.setPromptText(chooseActor);
    }
    else
    {
      actorComboBox.setItems(actresses);
      actorComboBox.setPromptText(chooseActress);
    }
  }

  @FXML
  void showButton_Click(ActionEvent event)
  {
    String message = actorComboBox.getValue() == null ?
        "Please choose an actor or an actress!"
        : "You chose " + actorComboBox.getValue().toString();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message);
        alert.show();
  }
}

















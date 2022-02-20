package com.lowewriter.choosing_from_a_list.choicebox_samples;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class ChoiceBoxSample2Controller implements Initializable
{
  @FXML
  private ChoiceBox<String> animals;

  @FXML
  void getAnimal(MouseEvent event)
  {
    String animal = animals.getSelectionModel().getSelectedItem();
    System.out.println(animal);

    int index = animals.getSelectionModel().getSelectedIndex();
    System.out.println("Index: " + index);
  }

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle)
  {
    animals.getItems().addAll("Dog", "Cat", "Monkey");
  }
}

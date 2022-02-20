package com.lowewriter.choosing_from_a_list.listview_samples;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PizzaController implements Initializable
{
  @FXML
  private ListView<String> tableView;
  @FXML
  private Button okButton;
  @FXML
  private Button deleteButton;

  //  Class field
  ArrayList<String> stringArrayList = new ArrayList<>();

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle)
  {
//    Create data
    stringArrayList.add("0-Sausage");
    stringArrayList.add("1-Pepperoni");
    stringArrayList.add("2-Linguica");
    stringArrayList.add("3-Salame");
    stringArrayList.add("4-Olives");
    stringArrayList.add("5-Mushrooms");
    stringArrayList.add("6-Onions");
    stringArrayList.add("7-Peppers");

//    Set data for the pizzaListView
    tableView.setItems(FXCollections.observableList(stringArrayList));

//    Set multiple selection mode
    tableView.getSelectionModel()
        .setSelectionMode(SelectionMode.MULTIPLE);
  }

  @FXML
  void okButton_Click(ActionEvent event)
  {
    ObservableList<String> selectedItems =
        tableView.getSelectionModel().getSelectedItems();
    StringBuilder builder = new StringBuilder();
    builder.append("You chose:\n");
    for (String item : selectedItems)
    {
      builder.append(item + "\n");
    }

    Alert alert = new Alert(Alert.AlertType.INFORMATION, builder.toString());
    alert.show();
  }

  @FXML
  void deleteButton_Click(ActionEvent event)
  {
//    Get data of the TableView
    ObservableList<String> selectedItems =
        tableView.getSelectionModel().getSelectedItems();
//    Delete all selected items
    tableView.getItems().removeAll(selectedItems);
  }
}


























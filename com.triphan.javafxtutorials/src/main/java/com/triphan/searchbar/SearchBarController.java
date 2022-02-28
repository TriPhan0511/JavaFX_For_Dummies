package com.triphan.searchbar;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class SearchBarController implements Initializable
{

  //  Class fields
  private ArrayList<String> words = new ArrayList<>(
      Arrays.asList("test", "dog", "Human", "Days of our life", "The best day",
          "Friends", "Animal", "Human", "Bear", "Life",
          "This is some text", "Words", "222", "Bird", "Dog", "A few words",
          "Subscribe!", "SoftwareEngineeringStudent", "You got this!!",
          "Super Human", "Super", "Like")
  );

  @FXML
  private ListView<String> listView;

  @FXML
  private TextField searchBar;

  @FXML
  private Button searchButton;

  @Override
  public void initialize(URL url, ResourceBundle resourceBundle)
  {
    listView.getItems().addAll(words);
  }

  @FXML
  private void searchButton_Click(ActionEvent event)
  {
    listView.getItems().clear();
    listView.getItems().addAll(searchList(searchBar.getText(), words));
  }

//  !IMPORTANT
  private List<String> searchList(String searchWords, List<String> listOfStrings)
  {
    List<String> searchWordsArray = Arrays.asList(searchWords.trim().split(" "));
    return listOfStrings.stream().filter(input ->{
      return searchWordsArray.stream().allMatch(word ->
          input.toLowerCase().contains(word.toLowerCase()));
    }).collect(Collectors.toList());
  }

}
































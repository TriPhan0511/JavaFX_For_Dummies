package com.lowewriter.choosing_from_a_list.listview_samples_2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SampleData
{
  public static ObservableList<Person> initializeData()
  {
    ObservableList<Person> data = FXCollections.observableArrayList();
    data.addAll(
        new Person("Kelly", "Bruce", "She is an actress"),
        new Person("Tom", "Hank", "He is an actor"),
        new Person("Alex", "Ferguson", "He is a coach"),
        new Person("David", "Beckham", "He is a soccer player"),
        new Person("Peter", "Pan", "He is a herro")
    );
    return data;
  }
}

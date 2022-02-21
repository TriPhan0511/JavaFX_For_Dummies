package com.lowewriter.working_with_tables.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SampleData
{
  public static ObservableList<Movie> loadData()
  {
    ObservableList<Movie> data =
        FXCollections.observableArrayList();
    data.add(new Movie("It's a wonderful life",
        1946, 14.95));
    data.add(new Movie("Young Frankenstein",
        1974, 16.95));
    data.add(new Movie("Star Wars Episode 4",
        1976, 19.75));
    data.add(new Movie("The Princess Bride",
        1987, 16.95));
    data.add(new Movie("Glory",
        1989, 14.95));
    data.add(new Movie("The Game",
        1997, 14.95));
    data.add(new Movie("Shakespeare in Love",
        1998, 19.95));
    data.add(new Movie("The Invention of Lying",
        2009, 18.95));
    data.add(new Movie("The King's Speech",
        2010, 19.95));
    return data;
  }
}

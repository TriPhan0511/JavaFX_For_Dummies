package com.triphan.master_detail_views_sample.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.Objects;

public class Person
{
  private final StringProperty firstName =
      new SimpleStringProperty(this, "firstname", "");
  private final StringProperty lastname =
      new SimpleStringProperty(this, "lastname", "");
  private final StringProperty notes =
      new SimpleStringProperty(this, "notes", "sample notes");

  public Person()
  {
  }

  public Person(String firstname, String lastname, String notes)
  {
    this.firstName.set(firstname);
    this.lastname.set(lastname);
    this.notes.set(notes);
  }

  public String getFirstName()
  {
    return firstName.get();
  }

  public StringProperty firstNameProperty()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName.set(firstName);
  }

  public String getLastname()
  {
    return lastname.get();
  }

  public StringProperty lastnameProperty()
  {
    return lastname;
  }

  public void setLastname(String lastname)
  {
    this.lastname.set(lastname);
  }

  public String getNotes()
  {
    return notes.get();
  }

  public StringProperty notesProperty()
  {
    return notes;
  }

  public void setNotes(String notes)
  {
    this.notes.set(notes);
  }

  @Override
  public String toString()
  {
    return firstName.get() + " " + lastname.get();
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
    {
      return true;
    }
    if (obj == null || getClass() != obj.getClass())
    {
      return false;
    }
    Person person = (Person) obj;
    return Objects.equals(firstName, person.firstName) &&
        Objects.equals(lastname, person.lastname) &&
        Objects.equals(notes, person.notes);
  }

  @Override
  public int hashCode()
  {
    return Objects.hash(firstName, lastname, notes);
  }
}



























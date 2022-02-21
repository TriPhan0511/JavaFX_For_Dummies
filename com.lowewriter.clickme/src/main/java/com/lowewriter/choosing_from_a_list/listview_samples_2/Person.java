package com.lowewriter.choosing_from_a_list.listview_samples_2;

public class Person
{
  private String firstname;
  private String lastname;
  private String notes;

  public Person()
  {
  }

  public Person(String firstname, String lastname, String notes)
  {
    this.firstname = firstname;
    this.lastname = lastname;
    this.notes = notes;
  }

  public String getFirstname()
  {
    return firstname;
  }

  public void setFirstname(String firstname)
  {
    this.firstname = firstname;
  }

  public String getLastname()
  {
    return lastname;
  }

  public void setLastname(String lastname)
  {
    this.lastname = lastname;
  }

  public String getNotes()
  {
    return notes;
  }

  public void setNotes(String notes)
  {
    this.notes = notes;
  }

  @Override
  public String toString()
  {
    return firstname + " " + lastname;
  }
}




















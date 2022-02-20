package com.lowewriter.choosing_from_a_list.combobox_samples;

public class Actor
{
  private String firstName;
  private String lastName;

  public Actor(String firstName, String lastName)
  {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @Override
  public String toString()
  {
    return firstName + " " + lastName;
  }
}

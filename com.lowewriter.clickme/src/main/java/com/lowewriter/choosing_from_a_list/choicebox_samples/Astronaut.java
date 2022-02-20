package com.lowewriter.choosing_from_a_list.choicebox_samples;

public class Astronaut
{
  private String firstName;
  private String lastName;

  public Astronaut(String firstName, String lastName)
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

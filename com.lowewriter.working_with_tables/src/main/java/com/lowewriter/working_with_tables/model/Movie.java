package com.lowewriter.working_with_tables.model;

public class Movie
{
  private String title;
  private int year;
  private double price;

  public Movie()
  {
    title = "";
    year = 0;
    price = 0.0;
  }

  public Movie(String title, int year, double price)
  {
    this.title = title;
    this.year = year;
    this.price = price;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public int getYear()
  {
    return year;
  }

  public void setYear(int year)
  {
    this.year = year;
  }

  public double getPrice()
  {
    return price;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }
}

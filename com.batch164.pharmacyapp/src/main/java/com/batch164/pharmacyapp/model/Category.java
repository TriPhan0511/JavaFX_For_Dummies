package com.batch164.pharmacyapp.model;

import java.util.ArrayList;

public class Category
{
  private String categoryID;
  private String categoryName;
  private ArrayList<Product> listOfProducts = new ArrayList<>();

  public Category()
  {
  }

  public Category(String categoryID, String categoryName)
  {
    this.categoryID = categoryID;
    this.categoryName = categoryName;
  }

  public String getCategoryID()
  {
    return categoryID;
  }

  public void setCategoryID(String categoryID)
  {
    this.categoryID = categoryID;
  }

  public String getCategoryName()
  {
    return categoryName;
  }

  public void setCategoryName(String categoryName)
  {
    this.categoryName = categoryName;
  }

  public ArrayList<Product> getListOfProducts()
  {
    return listOfProducts;
  }

  public void setListOfProducts(ArrayList<Product> listOfProducts)
  {
    this.listOfProducts = listOfProducts;
  }
}

package com.batch164.pharmarcyapplication.model;

import java.time.LocalDate;

public class Product
{
  private String productID;
  private String productName;
  private double price;
  private LocalDate expirationDate;
  private String unit;
  private Category category;

  public Product() {}

  public Product(String productID, String productName)
  {
    this.productID = productID;
    this.productName = productName;
  }

  public String getProductID()
  {
    return productID;
  }

  public void setProductID(String productID)
  {
    this.productID = productID;
  }

  public String getProductName()
  {
    return productName;
  }

  public void setProductName(String productName)
  {
    this.productName = productName;
  }

  public double getPrice()
  {
    return price;
  }

  public void setPrice(double price)
  {
    this.price = price;
  }

  public LocalDate getExpirationDate()
  {
    return expirationDate;
  }

  public void setExpirationDate(LocalDate expirationDate)
  {
    this.expirationDate = expirationDate;
  }

  public String getUnit()
  {
    return unit;
  }

  public void setUnit(String unit)
  {
    this.unit = unit;
  }

  public Category getCategory()
  {
    return category;
  }

  public void setCategory(Category category)
  {
    this.category = category;
  }
}

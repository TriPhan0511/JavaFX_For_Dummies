package com.triphan.searchbar_and_tableview;

public class Product
{
  private int productID;
  private String brand;
  private String modelNumber;
  private int modelYear;
  private String productName;
  private String description;

  public Product(int productID, String brand, String modelNumber, int modelYear, String productName, String description)
  {
    this.productID = productID;
    this.brand = brand;
    this.modelNumber = modelNumber;
    this.modelYear = modelYear;
    this.productName = productName;
    this.description = description;
  }

  public int getProductID()
  {
    return productID;
  }

  public String getBrand()
  {
    return brand;
  }

  public String getModelNumber()
  {
    return modelNumber;
  }

  public int getModelYear()
  {
    return modelYear;
  }

  public String getProductName()
  {
    return productName;
  }

  public String getDescription()
  {
    return description;
  }

  public void setProductID(int productID)
  {
    this.productID = productID;
  }

  public void setBrand(String brand)
  {
    this.brand = brand;
  }

  public void setModelNumber(String modelNumber)
  {
    this.modelNumber = modelNumber;
  }

  public void setModelYear(int modelYear)
  {
    this.modelYear = modelYear;
  }

  public void setProductName(String productName)
  {
    this.productName = productName;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  @Override
  public String toString()
  {
    StringBuilder builder = new StringBuilder();
    builder.append(productID);
    builder.append("-");
    builder.append(brand);
    builder.append("-");
    builder.append(modelNumber);
    builder.append("-");
    builder.append(modelYear);
    builder.append("-");
    builder.append(productName);
    builder.append("-");
    builder.append(description);
    return builder.toString();
  }


}






















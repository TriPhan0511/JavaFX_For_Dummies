package com.batch164.pharmacyapp.model.composite;

public class CompositeStock
{
  private String storeID;
  private String storeName;
  private String categoryID;
  private String categoryName;
  private String productID;
  private String productName;
  private int quantity;

  public CompositeStock()
  {
  }

  public CompositeStock(String storeID, String storeName, String categoryID, String categoryName, String productID, String productName, int quantity)
  {
    this.storeID = storeID;
    this.storeName = storeName;
    this.categoryID = categoryID;
    this.categoryName = categoryName;
    this.productID = productID;
    this.productName = productName;
    this.quantity = quantity;
  }

  public String getStoreID()
  {
    return storeID;
  }

  public String getStoreName()
  {
    return storeName;
  }

  public String getCategoryID()
  {
    return categoryID;
  }

  public String getCategoryName()
  {
    return categoryName;
  }

  public String getProductID()
  {
    return productID;
  }

  public String getProductName()
  {
    return productName;
  }

  public int getQuantity()
  {
    return quantity;
  }

  public void setStoreID(String storeID)
  {
    this.storeID = storeID;
  }

  public void setStoreName(String storeName)
  {
    this.storeName = storeName;
  }

  public void setCategoryID(String categoryID)
  {
    this.categoryID = categoryID;
  }

  public void setCategoryName(String categoryName)
  {
    this.categoryName = categoryName;
  }

  public void setProductID(String productID)
  {
    this.productID = productID;
  }

  public void setProductName(String productName)
  {
    this.productName = productName;
  }

  public void setQuantity(int quantity)
  {
    this.quantity = quantity;
  }

  @Override
  public String toString()
  {
    StringBuilder builder = new StringBuilder();
    builder.append(storeID);
    builder.append("-");
    builder.append(storeName);
    builder.append("-");
    builder.append(categoryID);
    builder.append("-");
    builder.append(categoryName);
    builder.append("-");
    builder.append(productID);
    builder.append("-");
    builder.append(productName);
    builder.append("-");
    builder.append(quantity);
    return builder.toString();
  }
}

//public class CompositeStock
//{
//  private String storeID;
//  private String storeName;
//  private String productID;
//  private String productName;
//  private int quantity;
//
//  public CompositeStock()
//  {
//  }
//
//  public CompositeStock(String storeID, String storeName, String productID, String productName, int quantity)
//  {
//    this.storeID = storeID;
//    this.storeName = storeName;
//    this.productID = productID;
//    this.productName = productName;
//    this.quantity = quantity;
//  }
//
//  public String getStoreID()
//  {
//    return storeID;
//  }
//
//  public String getStoreName()
//  {
//    return storeName;
//  }
//
//  public String getProductID()
//  {
//    return productID;
//  }
//
//  public String getProductName()
//  {
//    return productName;
//  }
//
//  public int getQuantity()
//  {
//    return quantity;
//  }
//
//  public void setStoreID(String storeID)
//  {
//    this.storeID = storeID;
//  }
//
//  public void setStoreName(String storeName)
//  {
//    this.storeName = storeName;
//  }
//
//  public void setProductID(String productID)
//  {
//    this.productID = productID;
//  }
//
//  public void setProductName(String productName)
//  {
//    this.productName = productName;
//  }
//
//  public void setQuantity(int quantity)
//  {
//    this.quantity = quantity;
//  }
//}

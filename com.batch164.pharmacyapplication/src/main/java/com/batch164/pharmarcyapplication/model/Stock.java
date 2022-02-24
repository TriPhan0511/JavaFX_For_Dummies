package com.batch164.pharmarcyapplication.model;

public class Stock
{
  private Store store;
  private Product product;
  private int quantity;

  public Stock()
  {
  }

  public Stock(Store store, Product product, int quantity)
  {
    this.store = store;
    this.product = product;
    this.quantity = quantity;
  }

  public Store getStore()
  {
    return store;
  }

  public void setStore(Store store)
  {
    this.store = store;
  }

  public Product getProduct()
  {
    return product;
  }

  public void setProduct(Product product)
  {
    this.product = product;
  }

  public int getQuantity()
  {
    return quantity;
  }

  public void setQuantity(int quantity)
  {
    this.quantity = quantity;
  }
}

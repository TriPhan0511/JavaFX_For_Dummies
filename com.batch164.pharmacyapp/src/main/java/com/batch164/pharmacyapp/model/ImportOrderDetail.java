package com.batch164.pharmacyapp.model;

public class ImportOrderDetail
{
  private ImportOrder importOrder;
  private Product product;
  private int quantity;
  private double importPrice;

  public ImportOrderDetail()
  {
  }

  public ImportOrderDetail(ImportOrder importOrder, Product product, int quantity, double importPrice)
  {
    this.importOrder = importOrder;
    this.product = product;
    this.quantity = quantity;
    this.importPrice = importPrice;
  }

  public ImportOrder getImportOrder()
  {
    return importOrder;
  }

  public void setImportOrder(ImportOrder importOrder)
  {
    this.importOrder = importOrder;
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

  public double getImportPrice()
  {
    return importPrice;
  }

  public void setImportPrice(double importPrice)
  {
    this.importPrice = importPrice;
  }
}

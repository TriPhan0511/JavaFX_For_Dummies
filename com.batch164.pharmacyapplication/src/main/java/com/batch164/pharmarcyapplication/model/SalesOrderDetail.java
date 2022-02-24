package com.batch164.pharmarcyapplication.model;

public class SalesOrderDetail
{
  private SalesOrder salesOrder;
  private Product product;
  private int quantity = 0;
  private double discount;

  public SalesOrderDetail()
  {
  }

  public SalesOrderDetail(SalesOrder salesOrder, Product product, int quantity, double discount)
  {
    this.salesOrder = salesOrder;
    this.product = product;
    this.quantity = quantity;
    this.discount = discount;
  }

  public SalesOrder getSalesOrder()
  {
    return salesOrder;
  }

  public void setSalesOrder(SalesOrder salesOrder)
  {
    this.salesOrder = salesOrder;
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

  public double getDiscount()
  {
    return discount;
  }

  public void setDiscount(double discount)
  {
    this.discount = discount;
  }
}

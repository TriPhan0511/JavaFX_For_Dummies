package com.pharmacy_management.pharmacy_manager.mapper;

public class StockDetail {
private String product_id;
private String product_name;
private String unit;
private String price;
private String expiration_date;
private String category_name;
private String quantity;

    public StockDetail(String product_id, String product_name, String unit, String price, String expiration_date, String category_name, String quantity) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.unit = unit;
        this.price = price;
        this.expiration_date = expiration_date;
        this.category_name = category_name;
        this.quantity = quantity;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "StockDetail{" +
                "product_id='" + product_id + '\'' +
                ", product_name='" + product_name + '\'' +
                ", unit='" + unit + '\'' +
                ", price='" + price + '\'' +
                ", expiration_date='" + expiration_date + '\'' +
                ", category_name='" + category_name + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}

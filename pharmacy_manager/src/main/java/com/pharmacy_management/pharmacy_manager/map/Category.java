package com.pharmacy_management.pharmacy_manager.map;

import com.pharmacy_management.pharmacy_manager.DBUtils.DB_DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Category
{
  private String categoryID;
  private String categoryName;
  public Category()
  {
  }

  public Category(String categoryID, String categoryName)
  {
    this.categoryID = categoryID;
    this.categoryName = categoryName;
  }

  public String getCategoryID() {
    return categoryID;
  }

  public void setCategoryID(String categoryID) {
    this.categoryID = categoryID;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  @Override
  public String toString() {
    return "Category{" +
            "categoryID='" + categoryID + '\'' +
            ", categoryName='" + categoryName + '\'' +
            '}';
  }
  public ArrayList<Category> categories() throws SQLException {
    ArrayList<Category> categoryArrayList=new ArrayList<>();
    String sql="select * from category";
    ResultSet resultSet=new DB_DAO().dbUtils(sql);
    while (resultSet.next()){
      categoryID=resultSet.getString("category_id");
      categoryName=resultSet.getString("category_name");
      Category category=new Category(categoryID,categoryName);
      categoryArrayList.add(category);
    }
    return categoryArrayList;
  }

}

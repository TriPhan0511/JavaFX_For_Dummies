package com.pharmacy_management.pharmacy_manager.DBUtils;

import com.pharmacy_management.pharmacy_manager.map.Employee;
import com.pharmacy_management.pharmacy_manager.mapper.StockDetail;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class StoctDetailUtil {
    private static final DB_DAO db = new DB_DAO();
    public ArrayList<StockDetail> showSStockDetail(String store_id) throws SQLException {
        StockDetail stockDetail;
        ArrayList<StockDetail> arrStD = new ArrayList<>();
        Connection con = db.getConn();
        String sql="select product.product_id,product.product_name,unit,price,expiration_date,category.category_name,stock.quantity\n" +
                "from product join stock on product.product_id=stock.product_id \n" +
                "join category on product.category_id=category.category_id\n" +
                "where stock.store_id='" +
                store_id +
                "'";

            Statement statement= con.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                String product_id   =   resultSet.getString("product_id");
                String product_name   =   resultSet.getString("product_name");
                String unit   =   resultSet.getString("unit");
                String price   =   resultSet.getString("price");
                String expiration_date   =   resultSet.getString("expiration_date");
                String category_name   =   resultSet.getString("product_id");
                String quantity   =   resultSet.getString("quantity");
                stockDetail=new StockDetail(product_id,product_name,unit,price,expiration_date,category_name,quantity);
                arrStD.add(stockDetail);
            }
            resultSet.close();
            statement.close();
            con.close();
        return arrStD;
    }
}

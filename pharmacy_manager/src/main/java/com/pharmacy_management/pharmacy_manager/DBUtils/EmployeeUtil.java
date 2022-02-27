package com.pharmacy_management.pharmacy_manager.DBUtils;
import com.pharmacy_management.pharmacy_manager.map.Employee;
import javafx.scene.control.Label;

import java.sql.*;
import java.util.ArrayList;

public class EmployeeUtil {
    private static final DB_DAO db = new DB_DAO();
//DB into employee method
    public void addEmployee(Employee employee, String store, Label lbl){
        String sql="insert into	 employee(employee_id, first_name,last_name,password,gender,email,phone_number,address,store_id)" +
                " values (?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt =null;
        Connection con = db.getConn();
        try {
            pstmt= con.prepareStatement(sql);
            pstmt.setString(1,employee.getId());
            pstmt.setString(2,employee.getFirstName());
            pstmt.setString(3, employee.getLastName());
            pstmt.setString(4,"default");
            pstmt.setString(5,employee.getGender());
            pstmt.setString(6, employee.getEmail());
            pstmt.setString(7, employee.getPhoneNumber());
            pstmt.setString(8, employee.getAddress());
            pstmt.setString(9, store);
            int affRow = pstmt.executeUpdate();
            System.out.println("" + affRow + " row insert into SoresTable successful!");
            if (affRow==1) lbl.setText("SAVE SUCCESSFUL");
            else lbl.setText("SAVE NOT SUCCESSFUL,Please again");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(pstmt!=null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con!=null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public ArrayList<Employee> showEmployee(Label lbl) {
        Employee employee;
        ArrayList<Employee> arrEm = new ArrayList<>();
        Connection con = db.getConn();
        String sql = "select employee_id,first_name,last_name,gender,email,phone_number,address\n" +
                "from employee\n" +
                "where store_id='" +
               lbl.getText().trim()+
                "'";
        Statement stmt = null;
        ResultSet rs  = null;
        try {
            stmt = con.createStatement();
             rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String employee_id = rs.getString("employee_id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String gender = rs.getString("gender");
                String email = rs.getString("email");
                String phone_number = rs.getString("phone_number");
                String address = rs.getString("address");
                employee = new Employee(employee_id, first_name, last_name, gender, email, phone_number, address);
                arrEm.add(employee);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        finally {
            if(rs!=null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt!=null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con!=null) try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return arrEm;
    }

    public void updateEmployee(Employee employee,Label lbl) throws SQLException {
        Connection con = db.getConn();
        Statement statement;
        String sql="update  employee\n" +
                "set first_name = '" +
                employee.getFirstName() +
                "',last_name='" +
                employee.getLastName() +
                "',gender='" +
                employee.getGender() +
                "',email='" +
                employee.getEmail() +
                "',phone_number='" +
                employee.getPhoneNumber() +
                "',address='" +
                employee.getAddress() +
                "'\n" +
                "where employee_id like '" +
                employee.getId() +
                "'";
        statement = con.createStatement();
        statement.executeUpdate(sql);
        int row =statement.executeUpdate(sql);
        if (row==1) lbl.setText("UPDATE SUCCESSFUL");
        else lbl.setText("UPDATE NOT SUCCESSFUL,Please again");
        System.out.println("" + row + " row insert successful");

        statement.close();
        con.close();
    }


}

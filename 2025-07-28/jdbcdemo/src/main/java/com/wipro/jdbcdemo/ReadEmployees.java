package com.wipro.jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class ReadEmployees {
    public static void main(String[] args){
        String jdbcURL="jdbc:mysql://localhost:3306/db2";
        String dbUser="root";
        																															String dbPassword="tiger";
        String sql="SELECT * FROM employee";

        try {
            Connection connection=DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
            Statement statement=connection.createStatement();
            ResultSet res=statement.executeQuery(sql);
            while (res.next()){
                int id=res.getInt("id");
                String name=res.getString("emp_name");
                String department=res.getString("department");
                System.out.println("ID: "+id+", Name: "+name+", Department: "+department);
            }
            res.close();
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error reading employee data: "+e.getMessage());
        }
    }
}

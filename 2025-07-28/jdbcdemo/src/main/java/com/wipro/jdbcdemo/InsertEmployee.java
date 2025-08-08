package com.wipro.jdbcdemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class InsertEmployee {
    public static void main(String[] args){
        String jdbcURL="jdbc:mysql://localhost:3306/db2";
        String dbUser="root";																									String dbPassword="tiger";
        String sql="INSERT INTO employee (emp_name,department) VALUES (?,?)";
        String[][] employees={
                {"Rohan","IT"},
                {"Priya","HR"},
                {"Amit","Finance"},
                {"Neha","Marketing"}
            };
        try {
            Connection connection=DriverManager.getConnection(jdbcURL,dbUser,dbPassword);
            PreparedStatement statement=connection.prepareStatement(sql);
            for (String[] emp:employees) {
                statement.setString(1,emp[0]);
                statement.setString(2,emp[1]);
                statement.executeUpdate();
            }
            System.out.println("All employees inserted successfully!");
            statement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Error inserting employee: "+e.getMessage());
        }
    }
}

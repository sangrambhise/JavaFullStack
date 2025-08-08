package com.wipro.jdbcdemo;
import java.sql.*;

public class EmployeeSalaryCalculator {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db2";
        String username = "root";
        																			String password = "tiger";

        String query = "SELECT AVG(salary) AS average_salary FROM employees WHERE age > 30 AND salary > 50000";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                double averageSalary = resultSet.getDouble("average_salary");
                System.out.println("The average salary of employees older than 30 with a salary greater than 50,000 is: " + averageSalary);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

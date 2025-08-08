package com.wipro.servdemo;
import java.sql.*;
import java.util.Scanner;

public class App {
    private static final String url = "jdbc:mysql://localhost:3306/your_db_name";
    private static final String userId = "your_db_user";
    private static final String password = "your_db_password";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println(" -- Menu ---- ");
            System.out.println("1. Print Data");
            System.out.println("2. Add Data");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            option = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (option) {
                case 1:
                    printData();
                    break;
                case 2:
                    insertData(sc);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 3);

        sc.close();
    }

    private static void printData() {
        try (Connection conn = DriverManager.getConnection(url, userId, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM user")) {

            while (rs.next()) {
                System.out.println("User: " + rs.getString("user_name") + ", Password: " + rs.getString("user_pwd"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertData(Scanner sc) {
        try (Connection conn = DriverManager.getConnection(url, userId, password);
             PreparedStatement ps = conn.prepareStatement("INSERT INTO user(user_name, user_pwd) VALUES (?, ?)")) {

            System.out.print("Enter username: ");
            String username = sc.nextLine();
            System.out.print("Enter password: ");
            String pwd = sc.nextLine();

            ps.setString(1, username);
            ps.setString(2, pwd);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Data inserted successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

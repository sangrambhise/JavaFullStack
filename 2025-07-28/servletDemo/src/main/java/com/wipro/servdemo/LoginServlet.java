package com.wipro.servdemo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login")  
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("username");
        String passWord = req.getParameter("upassword");

        System.out.println("Username: " + uname);
        System.out.println("Password: " + passWord);
        System.out.println(" -- received data -- ");

        boolean isValid = checkCred(uname, passWord);
        if (isValid) {
            resp.getWriter().println("<h1>Login Successful!</h1>");
        } else {
            resp.getWriter().println("<h1>Invalid credentials!</h1>");
        }
    }

    private boolean checkCred(String uName, String password) {
        String url = "jdbc:mysql://localhost:3306/db2"; 
        String userId = "root";  
        String passWord = "tiger"; 

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, userId, passWord);
            String sql = "SELECT * FROM user WHERE user_name = ? AND user_pwd = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, uName);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

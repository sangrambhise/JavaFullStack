package com.wipro.servdemo;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(urlPatterns = "/login")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        String country = req.getParameter("country");

        if (country != null && country.equalsIgnoreCase("cnt1")) {
            chain.doFilter(req, res);
        } else {
            System.out.println(" -- Filter: Country does not match 'cnt1'. Access blocked or redirected.");
            res.getWriter().println("<h1>Access Denied</h1>");
            return; 
        }
    }

    @Override
    public void destroy() {

    }
}

package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HighBorrowersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = getServletContext().getInitParameter("jdbcUrl");
            String user = getServletContext().getInitParameter("jdbcUser");
            String password = getServletContext().getInitParameter("jdbcPassword");

            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT Customer_ID FROM FINANCE WHERE Money_Borrowed > 100000");

            out.println("<html><body>");
            out.println("<h2>Customers Who Borrowed More Than 1 Lakh</h2>");
            out.println("<ul>");
            while (rs.next()) {
                out.println("<li>" + rs.getInt("Customer_ID") + "</li>");
            }
            out.println("</ul>");
            out.println("</body></html>");
        } catch (Exception e) {
            out.println("<html><body>");
            out.println("<h3>Error retrieving high borrowers: " + e.getMessage() + "</h3>");
            out.println("</body></html>");
            e.printStackTrace(out);
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace(out);
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ViewAllRecordsServlet extends GenericServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = getServletContext().getInitParameter("jdbcUrl");
            String user = getServletContext().getInitParameter("jdbcUser");
            String password = getServletContext().getInitParameter("jdbcPassword");

            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM FINANCE");

            out.println("<html><body>");
            out.println("<h2>Finance Records</h2>");
            out.println("<table border='1'><tr><th>Customer_ID</th><th>Money_Borrowed</th><th>Money_Lend_Date</th><th>Repayment_Date</th><th>Interest_Percentage</th></tr>");
            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt("Customer_ID") + "</td><td>" + rs.getDouble("Money_Borrowed") + "</td><td>" + rs.getDate("Money_Lend_Date") + "</td><td>" + rs.getDate("Repayment_Date") + "</td><td>" + rs.getDouble("Interest_Percentage") + "</td></tr>");
            }
            out.println("</table>");
            out.println("</body></html>");
        } catch (Exception e) {
            out.println("<html><body>");
            out.println("<h3>Error retrieving finance records: " + e.getMessage() + "</h3>");
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
}

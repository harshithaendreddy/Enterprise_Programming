package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbcmodel.StudentData;


public class StudentService extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public StudentService() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    /*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Inside StudentService doGet method");
        StudentData studentData = new StudentData();
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();

        try {
            List<Student> students = studentData.getDetails();
            pw.println("<html><body>");
            pw.println("<h2>Student Details</h2>");
            pw.println("<table border='1'><tr><th>Reg No</th><th>Name</th><th>CGPA</th></tr>");
            for (Student student : students) {
                pw.println("<tr><td>" + student.getRegno() + "</td><td>" + student.getName() + "</td><td>" + student.getCgpa() + "</td></tr>");
            }
            pw.println("</table>");
            pw.println("</body></html>");
        } catch (Exception e) {
            pw.println("<html><body>");
            pw.println("<h3>Error retrieving student details: " + e.getMessage() + "</h3>");
            pw.println("</body></html>");
        } finally {
            pw.close();
        }
    }*/
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentData ob = new StudentData();
		response.setContentType("text/html");//output of html will be responded using html
		PrintWriter pw = response.getWriter();//getWriter method is used to return the object of printwriter class
		try {
			pw.print(ob.toString());
		}
		catch(Exception e) {
			pw.print(e.getMessage());
		}
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

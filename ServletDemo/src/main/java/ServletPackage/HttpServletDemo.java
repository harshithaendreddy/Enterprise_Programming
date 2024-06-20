package ServletPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletDemo extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");//output of html will be responded using html
		PrintWriter pw = response.getWriter();//getWriter method is used to return the object of printwriter class
		pw.print("<html>");
		pw.print("<head><title> HttpServlet Demo </title></head>");
		pw.print("<body>");
		pw.print("<h1> Testing on HttpServlet </h1>");
		pw.print("</body>");
		pw.print("</html>");

	}

}

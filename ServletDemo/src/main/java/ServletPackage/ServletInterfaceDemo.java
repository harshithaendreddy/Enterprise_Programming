package ServletPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ServletInterfaceDemo implements Servlet{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");//output of html will be responded using html
		PrintWriter pw = response.getWriter();//getWriter method is used to return the object of printwriter class
		pw.print("<html>");
		pw.print("<head><title> Servlet Interface </title></head>");
		pw.print("<body>");
		pw.print("<h1> Testing on Servlet interface </h1>");
		pw.print("</body>");
		pw.print("</html>");
	}
	
	

}

package section7.jdbcProgram;
import java.sql.*;
import java.util.Scanner;
public class App 
{
    public static void main( String[] args )
    {
    	try {
        Connection con = null;//Need connection object to connect to database
        con = DriverManager.getConnection("jdbc:mysql://localhost","root","harshi");
        //Driver manager class is used to connect to a database
        Statement s = con.createStatement();
        //To create a statement object,to execute queries
        String query1 = "use section7";
        s.execute(query1);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student id:");
        int sid = sc.nextInt();
        System.out.println("Enter student name:");
        String sname = sc.next();
        String query2 = "update student set name='"+sname+"' where id="+sid+"";
        s.execute(query2);
        System.out.println("Given task executed successfully");
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    }
}

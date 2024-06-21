package com.jdbcmodel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentData {
	public List<Student> getDetails() throws Exception{
		Connection con = null;
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/csejdbc","root","harshi");
		Statement s = con.createStatement();
		String query1 = "use csejdbc";
		String query2 = "select * from student";
		s.execute(query1);
		ResultSet rs = s.executeQuery(query2);
		List<Student> L = new ArrayList<Student>();
		while(rs.next()) { //how many times it execute is eaual to no of records
			Student ob = new Student();
			ob.setRegno(rs.getInt(1));
			ob.setName(rs.getString(2));
			ob.setCgpa(rs.getFloat(3));
			L.add(ob);
		}
		rs.close();
		return L;
	}

}

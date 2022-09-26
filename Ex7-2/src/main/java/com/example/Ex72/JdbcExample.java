package com.example.Ex72;
import java.sql.*;
public class JdbcExample {
	public static void main(String[] args) { 
		
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/spring5fs?" +
					"characterEncoding=utf-8&serverTimezone=UTC","spring5","spring5");
			stmt = conn.createStatement();
			String sql = "SELECT * FROM Member"; 
			ResultSet rs = stmt.executeQuery(sql); 
			
			while(rs.next()){
				String email = rs.getString("email");
				String name = rs.getString("name"); 
				System.out.println("Email: " + email + ", Name: " + name);
			}
			rs.close(); 
			stmt.close(); 
			conn.close();
		} catch(SQLException se) { 
			se.printStackTrace(); 
		} 
		catch(Exception e){ 
			e.printStackTrace();
		} finally{
			try{
				if(stmt!=null) stmt.close();
			} catch(SQLException se2){ } 
			try{
				if(conn!=null) conn.close();
			}catch(SQLException se){ se.printStackTrace(); }
		}
	}
}
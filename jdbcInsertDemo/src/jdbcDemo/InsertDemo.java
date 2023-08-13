package jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.SQLException;

public class InsertDemo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_db", "root", "root");

		PreparedStatement ps = con.prepareStatement("Insert into register values('Sameer','sameer@1243','sameer123','M','Mumbai')");
		int i = ps.executeUpdate();
		if(i > 0) 
			System.out.println("success");
		
		else 
			System.out.println("fail");
		
	}
	

}

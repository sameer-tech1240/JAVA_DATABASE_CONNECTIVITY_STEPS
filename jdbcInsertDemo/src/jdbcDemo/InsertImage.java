package jdbcDemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.DatabaseMetaData;

import Jdbc2.ConnectionProvider;

public class InsertImage {
	public static void main(String[] args) throws Exception {
		Connection con = ConnectionProvider.getCon();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter table name: ");

		 try {
			String tableName = scanner.nextLine();
			DatabaseMetaData metaData = (DatabaseMetaData) con.getMetaData();
			ResultSet tableResultSet = metaData.getTables(null, null, tableName, null);

			if (tableResultSet.next()) {
				System.out.println("Table already exists.");
			} else {
				Statement createStatement = con.createStatement();
				String createTableQuery = "CREATE TABLE " + tableName + " (id INT PRIMARY KEY, name VARCHAR(255))";
				createStatement.executeUpdate(createTableQuery);
				System.out.println("Table created: " + tableName);
				createStatement.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Statement statement = con.createStatement();
			statement.executeUpdate("insert into center values(3,'munna')");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

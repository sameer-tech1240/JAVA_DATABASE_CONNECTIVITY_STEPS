package Jdbc2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionProvider {
	static Connection connection = null;
	private ConnectionProvider() {

	}
	public static Connection getCon() {
		if (connection == null)
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println("enter your database name");
				String databaseName = br.readLine();

				String url = "jdbc:mysql://localhost:3306/";
				
				url = url.concat(databaseName);
				Class.forName("com.mysql.cj.jdbc.Driver");

				connection = DriverManager.getConnection(url, "root", "root");
				
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		else {
			return connection;
		}
		return connection;
	}
}

package jdbcDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CrudOperation {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/room_management", "root",
				"root");
		Statement statement = connection.createStatement();
		try {
			String createTableSQL = "CREATE TABLE IF NOT EXISTS study_room (" + "s_id INT(20) PRIMARY KEY, "
					+ "s_name VARCHAR(30) NOT NULL, " + "s_age INT(20) NOT NULL, " + "s_subject VARCHAR(30) NOT NULL, "
					+ "s_address1 VARCHAR(50) NOT NULL, " + "s_address2 VARCHAR(50) NOT NULL, "
					+ "s_mobile_number DECIMAL(10), " + "s_email VARCHAR(20), " + "study_of_hour INT NOT NULL)";
			statement.executeUpdate(createTableSQL);
			statement.executeUpdate(
					"INSERT INTO  study_room VALUES(27,'DILSHAD',20,'java','saki naka','mumbai',8865123787,'dilshad12@gmail.com')");
			statement.executeUpdate(
					"INSERT INTO  study_room VALUES(28,'SARFARAZ',21,'java','kurla','mumbai',8888123787,'s12@gmail.com')");
			statement.executeUpdate("alter table study_room add column study_of_hour int not null");
			statement.executeUpdate(
					"INSERT INTO  study_room VALUES(30,'ATIB ANSARI',23,'basic java','jogeshwari','mumbai',9977123787,'atib12@gmail.com' , 4)");
			statement.executeUpdate("alter table study_room add constraint s_mobile_number unique(s_mobile_number)");

		} catch (Exception e) {
			System.out.println("Handle Exception....");

		} finally {

			PreparedStatement pre = connection.prepareStatement("select * from study_room");
			ResultSet resultSet = pre.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("s_id");
				System.out.println("ID : " + id);

				String name = resultSet.getString("s_name");
				System.out.println("NAME : " + name);

				int age = resultSet.getInt("s_age");
				System.out.println("AGE : " + age);

				String subject = resultSet.getString("s_subject");
				System.out.println("SUBJECT : " + subject);

				String address1 = resultSet.getString("s_address1");
				System.out.println("ADDRESS1 : " + address1);

				String address2 = resultSet.getString("s_address2");
				System.out.println("ADDRESS2 : " + address2);

				long mobile_number = resultSet.getLong("s_mobile_number");
				System.out.println("MOBILE NUMBER : " + mobile_number);

				String email = resultSet.getString("s_email");
				System.out.println("EMAIL : " + email);

				int study_of_hour = resultSet.getInt("study_of_hour");
				System.out.println("STUDY OF HOUR :  " + study_of_hour);

				System.out.println("---------------------------------------------------");

			}

			try {
				List<String> list = new ArrayList<>();
				list.add("select min(study_of_hour) as count from study_room where s_id between 20 and 30");
				list.add("select max(study_of_hour) as count from study_room where s_id between 20 and 30");
				list.add("select sum(study_of_hour) as count from study_room where s_id between 20 and 30");
				list.add("select avg(study_of_hour) as count from study_room where s_id between 20 and 30");
				list.add("select count(study_of_hour) as count from study_room where s_id between 20 and 30");

				int i = 0;

				while (i < 5) {

					pre = connection.prepareStatement(list.get(i));

					resultSet = pre.executeQuery();
					if (resultSet.next()) {
						System.out.println(resultSet.getInt("count"));
					}

					i++;

				}
			}

			catch (Exception e) {
				System.out.println(e);
			}
			/*
			 * ResultSet resultSet2 =
			 * statement.executeQuery("select mac(s_id) from study_room"); ResultSet
			 * resultSet3 = statement.executeQuery("select sum(s_id) from study_room");
			 * ResultSet resultSet4
			 * =statement.executeQuery("select count(s_id) from study_room"); ResultSet
			 * resultSet5 =statement.executeQuery("select avg(s_id) from study_room");
			 * System.out.println(resultSet); System.out.println(resultSet2);
			 * System.out.println(resultSet3); System.out.println(resultSet4);
			 * System.out.println(resultSet5);
			 */
		}
		statement.executeUpdate("update study_room set study_of_hour = 10 where s_id  between 20 and 21");
		statement.executeUpdate("update study_room set study_of_hour = 8 where s_id  between 22 and 23");
		statement.executeUpdate("update study_room set study_of_hour = 6 where s_id  between 24 and 2");
		statement.executeUpdate("update study_room set s_email = 'sarfaraz12@gmail.com' where s_id = 28");
		statement.executeUpdate("update study_room set study_of_hour = 6 where s_id  between 28 and 29");
        
		
	}

}

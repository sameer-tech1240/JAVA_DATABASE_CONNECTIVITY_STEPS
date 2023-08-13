package Jdbc2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InheritMethodInJdbc {

	public static void main(String[] args) throws Exception {
		Connection con = ConnectionProvider.getCon();
		String sql = "Insert into student values(?,?,?,?,?,?)";
		/* 4,'Yasir',15000,'Saki Naka3',400072,'Y' */
		try {

			PreparedStatement prepareStatement = con.prepareStatement(sql);
			prepareStatement.setInt(1, 7);
			prepareStatement.setString(2, "Dilshad");
			prepareStatement.setInt(3, 500);
			prepareStatement.setString(4, "Saki Naka4");
			prepareStatement.setInt(5, 400072);
			prepareStatement.setString(6, "Y");
			int detail = prepareStatement.executeUpdate();
			if (detail > 0) {
				System.out.println("VALUE INSERTED");
			} else {
				System.out.println("VALUE IS NOT INSERTED");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			String sqlfind = "select name from student where id = ? ";
			PreparedStatement statement = con.prepareStatement(sqlfind);
			statement.setInt(1, 2);
			ResultSet result = statement.executeQuery();
			if (result.next()) {

				System.out.println(result.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String sqlUpdate = "update student set name = ? where id = ?";
			PreparedStatement statement = con.prepareStatement(sqlUpdate);
			statement.setString(1, "Shoaib");
			statement.setInt(2, 5);
			statement.executeUpdate();
			System.out.println("Record Update");
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String sqldelete = "delete from student where id = ? ";
			PreparedStatement statement = con.prepareStatement(sqldelete);
			statement.setInt(1, 6);
			statement.executeUpdate();
			System.out.println("Record Deleted Successfull");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
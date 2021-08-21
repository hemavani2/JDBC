package jdbcPractice;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcAddImage {
	public static void main(String[] args) throws SQLException {

		String url = "jdbc:mysql://localhost:3306/University";
		String userName = "hema";
		String password = "mysql@1912";
		//String query = "select * from engineeringstudents;";

		try {
			Connection connection = DriverManager.getConnection(url, userName, password);
			PreparedStatement prepStatement = connection.prepareStatement("insert into imgtable1 values(?,?)");
			prepStatement.setString(1, "Sahasra");

			FileInputStream fis = new FileInputStream("C:\\Users\\hemav\\OneDrive\\Desktop\\Sahasra.jpg");
			prepStatement.setBinaryStream(2, fis, fis.available());
			//prepStatement.setBlob(2, fis);
			System.out.println(prepStatement);
			int i = prepStatement.executeUpdate();
			System.out.println(i + " records affected");
			connection.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}

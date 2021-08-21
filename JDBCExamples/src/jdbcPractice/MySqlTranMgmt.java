package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlTranMgmt {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/University";
		String userName = "hema";
		String password = "mysql@1912";

		try {
			Connection connection = DriverManager.getConnection(url, userName, password);
			connection.setAutoCommit(false);

			Statement statement = connection.createStatement();
			statement.execute("insert into user values(1008, 'Siddharth')");
			statement.execute("insert into user values(1009, 'Avanish')");
			statement.execute("insert into user values(1009, 'Nicky')");
			statement.execute("update user set id = 1010 where name = 'Nicky'");

			connection.commit();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

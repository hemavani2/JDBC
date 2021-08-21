package jdbcPractice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class mySqlStoredProcedure {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/University";
		String userName = "hema";
		String password = "mysql@1912";

		try {
			Connection connection = DriverManager.getConnection(url, userName, password);
			CallableStatement statement = connection.prepareCall("{call myProcedure(?,?)}");
			statement.setInt(1, 1001);
			statement.setString(2, "Hema");
			statement.execute();
			statement.setInt(1, 1002);
			statement.setString(2, "Sindhu");
			statement.execute();
			statement.setInt(1, 1003);
			statement.setString(2, "Siddhu");
			statement.execute();
			statement.setInt(1, 1004);
			statement.setString(2, "Sahasra");
			statement.execute();
			statement.setInt(1, 1005);
			statement.setString(2, "Vani");
			statement.execute();
			statement.setInt(1, 1006);
			statement.setString(2, "Krishna");
			statement.execute();
			statement.setInt(1, 1007);
			statement.setString(2, "Sudheer");
			statement.execute();
			System.out.println("Success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

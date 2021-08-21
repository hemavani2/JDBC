package jdbcPractice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class MySqlFunctionSum {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/University";
		String userName = "hema";
		String password = "mysql@1912";
		
		try {
			Connection connection = DriverManager.getConnection(url, userName, password);
			CallableStatement statement = connection.prepareCall("{? = call sum(?,?)}");
			statement.setInt(2,54);
			statement.setInt(3,45);
			statement.registerOutParameter(1, Types.INTEGER);
			statement.execute();
			
			System.out.println(statement.getInt(1));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

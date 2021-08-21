package jdbcPractice;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class CallStoredProcedureUser {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/University";
		String userName = "hema";
		String password = "mysql@1912";
		
		try {
			Connection connection = DriverManager.getConnection(url, userName, password);
			CallableStatement statement = connection.prepareCall("{call retrieve_user()}");
			ResultSet result = statement.executeQuery();
			
			while (result.next()) {
				System.out.println("ID: "+result.getInt("id") + " | Name: " + result.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

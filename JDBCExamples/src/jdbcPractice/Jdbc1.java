package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc1 {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/University";
		String userName = "hema";
		String password = "mysql@1912";
		String query = "select Student_ID, Department, First_Name, Last_Name, PassOutYear, MIN(UniversityRank) AS Highest from engineeringstudents;";

		try {
			Connection connection = DriverManager.getConnection(url, userName, password);
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);

			while (result.next()) {
				String universityData = "";

				for (int i = 1; i <= 6; i++) {
					universityData += result.getString(i) + "  |  ";
				}
				System.out.println(universityData);
				System.out.println("*************************************************************");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

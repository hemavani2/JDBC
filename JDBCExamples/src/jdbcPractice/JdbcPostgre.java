package jdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.postgresql.util.PSQLException;

public class JdbcPostgre {
	public static void main(String[] args) throws PSQLException {
		String url = "jdbc:postgresql://localhost:5432/University";
		String userName = "postgres";
		String password = "post@1912";
		String query = "select * from student";
		String insert = "insert into student (Name, Department) values('Hema', 'CSE')";

		try {
			Class.forName("org.postgresql.Driver");
			Connection connection = DriverManager.getConnection(url, userName, password);
			Statement statement = connection.createStatement();
			// ResultSet result = statement.executeQuery(query);
			int executeUpdate = statement.executeUpdate(insert);

//			while (result.next()) {
//				String universityData = "";
//
//				for (int i = 1; i <= 2; i++) {
//					universityData += result.getString(i) + "  |  ";
//				}
//				System.out.println(universityData);}
			System.out.println(executeUpdate);
			System.out.println("*************************************************************");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

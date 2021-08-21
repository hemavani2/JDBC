package jdbcPractice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MySqlTranMgmtPreStmt {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/University";
		String userName = "hema";
		String password = "mysql@1912";

		try {
			Connection connection = DriverManager.getConnection(url, userName, password);
			connection.setAutoCommit(false);

			PreparedStatement statement = connection.prepareStatement("insert into user values(?, ?)");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				System.out.println("Enter ID: ");
				String s1 = br.readLine();
				int id = Integer.parseInt(s1);

				System.out.println("Enter Name: ");
				String name = br.readLine();

				statement.setInt(1, id);
				statement.setString(2, name);
				statement.executeUpdate();

				System.out.println("commit/rollback: ");
				String answer = br.readLine();

				if (answer.equals("commit")) {
					connection.commit();
				}

				if (answer.equals("rollback")) {
					connection.rollback();
				}

				System.out.println("Want to add more records y/n");
				String status = br.readLine();

				if (status.equals("n")) {
					break;
				}
			}

			connection.commit();
			System.out.println("Records saved successfully..");
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

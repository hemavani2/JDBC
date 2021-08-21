package jdbcPractice;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class JDBCRowSet {

	public static void main(String[] args) {
		try {
			JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
			rowSet.setUrl("jdbc:mysql://localhost:3306/University");
			rowSet.setUsername("hema");
			rowSet.setPassword("mysql@1912");

			rowSet.setCommand("select * from user");
			rowSet.execute();

			while (rowSet.next()) {
				System.out.println("ID: " + rowSet.getInt(1) + " | Name: " + rowSet.getString(2) + " | ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

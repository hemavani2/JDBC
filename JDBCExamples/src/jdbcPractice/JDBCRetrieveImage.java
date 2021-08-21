package jdbcPractice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCRetrieveImage {

	public static void main(String[] args) {

		try {

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/University", "hema",
					"mysql@1912");
			PreparedStatement ps = connection.prepareStatement("select * from imgtable1");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				// Blob b = rs.getBlob(2);
				InputStream binaryStream = rs.getBinaryStream(2);
				// byte[] barr = b.getBytes(1, (int) b.length());

				FileOutputStream fout = new FileOutputStream(
						new File("C:\\Users\\hemav\\OneDrive\\Desktop\\Sahasra4.jpg"));
				
				byte[] buffer = new byte[8 * 1024];
				int bytesRead;
				while ((bytesRead = binaryStream.read(buffer)) != -1) {
					fout.write(buffer, 0, bytesRead);
				}
				fout.close();
			}
			System.out.println("***************************");
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

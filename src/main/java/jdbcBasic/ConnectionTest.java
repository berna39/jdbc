package jdbcBasic;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {
	public static void main(String[] args) {
		connect();
	}
	
	private static void connect() {
		try {
				Class.forName("org.postgresql.Driver");
				System.out.println("Driver loaded");
				String url = "jdbc:postgresql://localhost:5432/test1";
				String user = "postgres";
				String passwd = "1234";
				Connection conn = DriverManager.getConnection(url, user,passwd);
				System.out.println("Conneted");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}

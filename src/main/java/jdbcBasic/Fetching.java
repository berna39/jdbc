package jdbcBasic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Fetching {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/test1";
			String user = "postgres";
			String passwd = "1234";
			Connection conn = DriverManager.getConnection(url, user,
			passwd);
			
			//Creating statement
			Statement state = conn.createStatement();
			
			//the ResultSet contains the query result
			ResultSet result = state.executeQuery("SELECT * FROM classe");
			//fetching MetaData
			ResultSetMetaData resultMeta = result.getMetaData();
			System.out.println("\n**********************************");
			//display columns
			for(int i = 1; i <= resultMeta.getColumnCount(); i++)
					System.out.print("\t" +
							resultMeta.getColumnName(i).toUpperCase() + "\t *");
				System.out.println("\n**********************************");
			while(result.next()){
				for(int i = 1; i <= resultMeta.getColumnCount(); i++)
					System.out.print("\t" + result.getObject(i).toString() +
							"\t |");
				System.out.println("\n---------------------------------");
			}
				result.close();
				state.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

	}
}

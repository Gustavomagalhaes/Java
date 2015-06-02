import java.sql.*;

public class Connect {

	static String status = "";
	
	public static Connection getConnection() {
		Connection connect = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost/empresa?user=root&password=root";
			connect = DriverManager.getConnection(url);
			status = "Connection Opened";
		} catch (SQLException e) {
			status = e.getMessage();
		} catch (ClassNotFoundException e) {
			status = e.getMessage();
		} catch (Exception e) {
			status = e.getMessage();
		}
		System.out.println(status);
		return connect;
	}
}

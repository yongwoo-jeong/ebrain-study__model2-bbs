package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionCheck {
	String url ="jdbc:mariadb://localhost:3306/eb_bbs2?user=root&password=1224";

	public void connectionTest() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			System.out.println("### connection : " +  connection + " - 연결 성공 ####");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}

}
	}

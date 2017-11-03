package lab_05_Formular;


import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class testingJDBCConn {
	public static void main(String[] args) {
		Connection conn = null;
		
		try {
		    conn =
		       (Connection) DriverManager.getConnection("jdbc:mysql://localhost/world?" +
		                                   "user=Stefan&password=titan24xy");

		    // Do something with the Connection


		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
    }
}

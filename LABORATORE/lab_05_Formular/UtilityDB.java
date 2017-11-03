package lab_05_Formular;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class UtilityDB {
	private static Connection con;
	private static final String Driver = "oracle.jdbc.driver.OracleDriver";
	private static final String ConnectionString = "jdbc:mysql://localhost/world";
	private static final String user = "Stefan";
	private static final String pwd = "titan24xy";

	/**
	 * create Database object
	 */

	/**
	 * 
	 * to load the database base driver
	 * 
	 * @return a database connection
	 * 
	 * @throws SQLException
	 *             throws an exception if an error occurs
	 * 
	 */

	public static Connection loadDriver() throws SQLException {

		try {

			Class.forName(Driver);

		} catch (ClassNotFoundException ex) {

			System.out.println(ex.getMessage());

		}
		con = (Connection) DriverManager.getConnection(ConnectionString, user, pwd);
		return con;

	}

	/**
	 *  to get a result set of a query 42
	 * 
	 * @param query
	 *            custom query 43
	 * @return a result set of custom query 44
	 * @throws SQLException
	 *             throws an exception if an error occurs 45
	 */

	public static ResultSet getResultSet(String query) throws SQLException {

		Connection con = loadDriver();

		ResultSet rs;

		PreparedStatement st = (PreparedStatement) con.prepareStatement(query);

		rs = st.executeQuery();

		return rs;

	}

	/**
	 * 
	 * to run an update query such as update, delete
	 * 
	 * @param query
	 *            custom query
	 * 
	 * @throws SQLException
	 *             throws an exception if an error occurs
	 * 
	 */

	public static void runQuery(String query) throws SQLException {

		Connection con = loadDriver();

		ResultSet rs;

		PreparedStatement st = (PreparedStatement) con.prepareStatement(query);

		st.executeUpdate();

	}

}

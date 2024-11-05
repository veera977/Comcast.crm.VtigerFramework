  package Com.comcast.crm.genaric.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class DatabaseUtility {
	Connection conn;

	public void getConnection(String url, String uesrname, String password) {
		try {
			Driver ref = new Driver();
			DriverManager.registerDriver(ref);

			conn = DriverManager.getConnection(url,uesrname,password);
		} catch (Exception e) {

		}

	}
	public void getConnection() {
		try {
			Driver ref = new Driver();
			DriverManager.registerDriver(ref);

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "root");
		} catch (Exception e) {

		}

	}

	public void closeConnectin() {
		try {
			conn.close();
		} catch (Exception e) {

		}
	}

	public ResultSet executeQuery(String Query) throws SQLException {
		ResultSet result = null;
		try {

			Statement sta = conn.createStatement();
			result = sta.executeQuery(Query);
		} catch (Exception e) {

		}
		return result;

	}
	public int excuteNonSelectQuery(String Query) throws SQLException {
		int result=0;
		try {
		Statement sta = conn.createStatement();
		result = sta.executeUpdate(Query);
		}
		catch(Exception e) {
			
		}
		return result;
		
	}
}


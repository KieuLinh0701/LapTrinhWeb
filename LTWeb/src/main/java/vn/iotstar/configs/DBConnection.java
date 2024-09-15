package vn.iotstar.configs;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import vn.iotstar.models.UserModel;

public class DBConnection {
	private final String serverName = "LAPTOP-D9J937E4";
	private final String dbName = "LTWEB";
	private final String portNumber = "1433";
	private final String instance = "";
	private final String userID = "sa";
	private final String password = "0123456789";

	public Connection getConnection() throws Exception {

		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty()) {
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "; databaseName = " + dbName;

		}
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url, userID, password);

	}

	public static void main(String[] args) {
		try {
			System.out.println(new DBConnection().getConnection());

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}

package datacenter;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnection {
	private String dbDriver;
	private String db;
	private Connection conn;

	public SQLConnection(){
		try {
    		dbDriver = "org.sqlite.JDBC";
    		db = "jdbc:sqlite:racing.db";
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(db);
			Statement stat = conn.createStatement();
		    stat.executeUpdate("CREATE TABLE IF NOT EXISTS data (id INTEGER PRIMARY KEY AUTOINCREMENT, sessionid INTEGER, value NUMERIC, INTEGER timestamp);");
    	} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insert(ConnectData dat, int sessionId) throws SQLException{
		PreparedStatement prepstat = conn.prepareStatement("INSERT INTO data VALUES(?, ?, ?);");
		prepstat.setInt(1, sessionId);
		prepstat.setDouble(2, dat.getValue());
		prepstat.setDate(3, dat.getTimeStamp());
		prepstat.executeUpdate();
	}
	
	public void select(String stmt) throws SQLException{
		PreparedStatement prepstat = conn.prepareStatement(stmt);
		prepstat.executeUpdate();
	}
}

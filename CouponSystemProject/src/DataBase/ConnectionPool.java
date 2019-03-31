package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectionPool {
  static Connection connection;  
	static int max_conection = 0;
	private static ArrayList<Connection> con = new ArrayList<>();

	// singeltone Connection pool
	private static ConnectionPool instance = new ConnectionPool(con);

	private ConnectionPool(ArrayList<Connection> con) {
		setList(con);
	}

	public ConnectionPool getInstance() {
		return instance;
	}

	public ArrayList<Connection> getList() {
		return con;
	}

	public void setList(ArrayList<Connection> list) {
		this.con = con;
	}

	// get connection
	public static void getCon() throws SQLException, WaitNotify {

		connection = DriverManager.getConnection(Database.sql, Database.user, Database.pasword);
        con.add(connection);
		
        

	}

}

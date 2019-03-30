package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectionPool {

	static int max_conection = 1;
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

		Connection connection = DriverManager.getConnection(Database.sql, Database.user, Database.pasword);
		if (con.size() <= max_conection) {
			con.add(connection);
		} else {
			throw new WaitNotify("Please Wait");
		}

	}

}

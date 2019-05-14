package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
	private final int MAX = 10;
	BlockingQueue<Connection> blockingQueue = new LinkedBlockingQueue<Connection>(MAX);
	String sql = "jdbc:mysql://localhost:3306/new?autoReconnect=true&useSSL=false";
	String user = "Talch";
	String pasword = "root";

	private static ConnectionPool instance = new ConnectionPool();

	public static ConnectionPool getInstance() {
		return instance;
	}

	private ConnectionPool() {
		this.instance = instance;
	}

	public Connection getConnection() throws SQLException, InterruptedException {

		blockingQueue.put(DriverManager.getConnection(sql, user, pasword));

		return blockingQueue.poll();
	}

	public synchronized void returnConnection(Connection connection) throws InterruptedException {
		blockingQueue.offer(connection);

	}

}

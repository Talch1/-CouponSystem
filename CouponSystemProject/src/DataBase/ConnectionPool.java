package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
	// Data members
	private final int MAX = 10;

	BlockingQueue<Connection> blockingQueue = new LinkedBlockingQueue<Connection>(MAX);
	String sql = "jdbc:mysql://localhost:3306/new?autoReconnect=true&useSSL=false";
	String user = "Talch";
	String pasword = "root";

	// Singleton
	private static ConnectionPool instance = new ConnectionPool();

	public static ConnectionPool getInstance() {
		return instance;
	}

	private ConnectionPool() {
		this.instance = instance;
	}

	// Get Connection
	public Connection getConnection() throws SQLException, InterruptedException {

		blockingQueue.put(DriverManager.getConnection(sql, user, pasword));

		return blockingQueue.poll();
	}

	// return connection
	public synchronized void returnConnection(Connection connection) throws InterruptedException {
		blockingQueue.offer(connection);

	}

	public void removeAllConnections() {

		synchronized (blockingQueue) {
			while (blockingQueue.size() < MAX) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			for (Connection connection : blockingQueue) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

}

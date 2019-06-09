package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import Exeptions.SizeEx;

public class ConnectionPool {
	// Data members
	private final int MAX = 15;;

	BlockingQueue<Connection> blockingQueue = new LinkedBlockingQueue<Connection>(MAX);
	String sql = "jdbc:mysql://localhost:3306/new?autoReconnect=true&useSSL=false";
	String user = "Talch";
	String pasword = "root";

	// Singleton
	private static ConnectionPool instance = new ConnectionPool();

	// Get instance
	public static ConnectionPool getInstance() {
		return instance;
	}

	// Constructor
	private ConnectionPool() {
		this.instance = instance;
	}

	// Get Connection
	public Connection getConnection() throws SQLException, InterruptedException {

		blockingQueue.put(DriverManager.getConnection(sql, user, pasword));

		return blockingQueue.poll();
	}

	// return connection
	public synchronized void returnConnection(Connection connection) throws InterruptedException, SizeEx {
		if (blockingQueue.size() >13 ) {
throw new SizeEx("full");

		} else {
			blockingQueue.offer(connection);
		}

	}

	// return all connections to blockingQueue
	public void removeAllConnections() {

		synchronized (blockingQueue) {
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

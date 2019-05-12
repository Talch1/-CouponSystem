package DataBase;

public class ConnectionPool {
	String url = "jdbc:mysql://localhost:3306/new?autoReconnect=true&useSSL=false, Talch, root";
	String driver = "com.mysql.jdbc.Driver";
	int maxcon = 30;
	
	public ConnectionPool( int initConnCnt) {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.url = url;
		for (int i = 0; i < maxcon; i++) {
		//	availableConns.addElement(getConnection());
		}
	}

	private Object getConnection() {
		// TODO Auto-generated method stub
		return null;
	}
}

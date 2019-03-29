import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.Predicate;

public class Database {

	String id = "ID bigint  primary key, ";

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName(getDriverData());
		createCupon();
	}

	public static String getDriverData() {
		return "com.mysql.jdbc.Driver";
	}

	public static void createCompany() throws SQLException {
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/new?autoReconnect=true&useSSL=false", "root", "root");
		String sql = "create table Company  (" + "ID bigint  primary key, " + "COMP_NAME varchar(50) , "
				+ "PASSWORD varchar(50) , " + "EMAIL varchar(50)  )";

		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		System.out.println("Created table Company");
		connection.close();
	}

	public static void createCostomer() throws SQLException {
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/new?autoReconnect=true&useSSL=false", "root", "root");
		String sql = "create table Costumer  (" + "ID bigint  primary key, " + "COST_NAME varchar(50) , "
				+ "PASSWORD varchar(50) )";

		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		System.out.println("Created table Costumer");
		connection.close();
	}
	
	public static void createCupon() throws SQLException {
		Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/new?autoReconnect=true&useSSL=false", "root", "root");
		String sql = "create table Coupon  (" + "ID bigint  primary key, " + "TITLE varchar(50) , "
				+ "START_DATA datetime ," 
				+ "END_DATA datetime ,"
				+ "AMOUNT int , " 
				+ "TYPE varchar(50) ,"
				+ "MESSAGE varchar(50) ,"
				+ "PRICE double ,"
				+ "IMAGE varchar(50))";

		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		System.out.println("Created table Coupon");
		connection.close();
	}
}

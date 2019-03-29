import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	
	public static String getDriverData() {
		return "com.mysql.jdbc.Driver";
	}
	public static String getUrl( ) {
		return String.format("jdbc:mysql://localhost:3306/new?autoReconnect=true&useSSL=false"+" " +","+ " "+"root"+ " "+","+ " "+ "root");}

	public static void create(Connection connection) throws SQLException {
		connection = DriverManager.getConnection(getUrl());
String sql = "create table Company  ("
		+ "ID long  primary key, "
		+ "COMP_NAME varchar(50) not , " + "PASSWORDS varchar(50)  " + "EMAIL varchar(50) )";

Statement statement = connection.createStatement();
statement.executeUpdate(sql);
System.out.println("Created table Company");

	}
}

package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	static  String sql = "jdbc:mysql://localhost:3306/new?autoReconnect=true&useSSL=false";
	static  String user = "Talch";
	static  String pasword = "root";

	public static String getDriverData() {
		return "com.mysql.jdbc.Driver";
	}

	public static String getUser() {
		return user;
	}

	public static String getPasword() {
		return pasword;
	}

	// Create all Tables
	public static void createAllTables() throws SQLException {
		createCompany();
		createCustomer();
		createCoupon();
	
	}

	// Create table company
	public static void createCompany() throws SQLException {
		Connection connection = DriverManager.getConnection(sql, user, pasword);
		String sql = "create table Company  (" + "ID bigint  primary key not null, " + "COMP_NAME varchar(50) not null, "
				+ "PASSWORD varchar(50) not null , " + "EMAIL varchar(50) not null  )";

		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		System.out.println("Created table Company");
		connection.close();
	}

	// Create table costumer
	public static void createCustomer() throws SQLException {
		Connection connection = DriverManager.getConnection(sql, user, pasword);
		String sql = "create table Custumer  (" + "ID bigint  primary key not null, " + "CUST_NAME varchar(50) not null, "
				+ "PASSWORD varchar(50) not null )";

		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		System.out.println("Created table Custumer");
		connection.close();
	}

	// Create table coupon
	public static void createCoupon() throws SQLException {
		Connection connection = DriverManager.getConnection(sql, user, pasword);
		String sql = "create table Coupon  (" + "ID bigint primary key not null, " + "TITLE varchar(50) not null , "
				+ "START_DATE datetime not null ," + "END_DATE datetime not null," + "AMOUNT int not null , " + "TYPE varchar(50) not null ,"
				+ "MESSAGE varchar(50) not null ," + "PRICE double not null ," + "IMAGE varchar(50) not null)";

		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		System.out.println("Created table Coupon");
		connection.close();
	}
	
	public static String getSql() {

		return sql;
	}
}

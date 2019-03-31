package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	static final String sql = "jdbc:mysql://localhost:3306/couponsystem?autoReconnect=true&useSSL=false";
	static final String user = "root";
	static final String pasword = "root";

	public static String getDriverData() {
		return "com.mysql.jdbc.Driver";
	}
    //Create all Tables
	public static void createAllTables() throws SQLException {
		createCompany();
		createCostomer();
		createCoupon();
		CreateJoinCostumer_Coupon();
		CreateJoinCompany_Coupon();
	}

	// Create table company
	public static void createCompany() throws SQLException {
		Connection connection = DriverManager.getConnection(sql, user, pasword);
		String sql = "create table Company  (" + "ID bigint  primary key, " + "COMP_NAME varchar(50) , "
				+ "PASSWORD varchar(50) , " + "EMAIL varchar(50)  )";

		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		System.out.println("Created table Company");
		connection.close();
	}

	// Create table costumer
	public static void createCostomer() throws SQLException {
		Connection connection = DriverManager.getConnection(sql, user, pasword);
		String sql = "create table Costumer  (" + "ID bigint  primary key, " + "COST_NAME varchar(50) , "
				+ "PASSWORD varchar(50) )";

		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		System.out.println("Created table Costumer");
		connection.close();
	}

	// Create table coupon
	public static void createCoupon() throws SQLException {
		Connection connection = DriverManager.getConnection(sql, user, pasword);
		String sql = "create table Coupon  (" + "ID bigint  primary key, " + "TITLE varchar(50) , "
				+ "START_DATA datetime ," + "END_DATA datetime ," + "AMOUNT int , " + "TYPE varchar(50) ,"
				+ "MESSAGE varchar(50) ," + "PRICE double ," + "IMAGE varchar(50))";

		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		System.out.println("Created table Coupon");
		connection.close();

	}// Create table costumer coupon

	public static void CreateJoinCostumer_Coupon() throws SQLException {
		Connection connection = DriverManager.getConnection(sql, user, pasword);
		String sql = "create table JOIN_COSTUMER_COUPON  (" + "COST_ID Bigint, "
				+ "COUPON_ID Bigint, primary key(COST_ID,COUPON_ID ))";
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		System.out.println("Created table Costumer_Coupon");
		connection.close();
	}

	// Create table company coupon
	public static void CreateJoinCompany_Coupon() throws SQLException {
		Connection connection = DriverManager.getConnection(sql, user, pasword);
		String sql = "create table JOIN_Company_COUPON  (" + "COMP_ID Bigint, "
				+ "COUPON_ID Bigint, primary key(COMP_ID,COUPON_ID ))";
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		System.out.println("Created table Company_Coupon");
		connection.close();
	}
}
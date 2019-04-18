package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {

	static String sql = "jdbc:mysql://localhost:3306/new?autoReconnect=true&useSSL=false";
	static String user = "Talch";
	static String pasword = "root";

	public static String getDriverData() {
		return "com.mysql.jdbc.Driver";
	}

	public static String getUser() {
		return user;
	}

	public static String getPasword() {
		return pasword;
	}

	public static String getSql() {

		return sql;
	}

	// Create all Tables
	public static void createAllTables() throws SQLException {
		createCustomer();
		createCompany();
		createCoupon();
		createCompanyCoupon();
		createCustomerCoupon();

	}

	// Drop all Tables
	public static void dropAllTables() throws SQLException {
		dropCompany();
		dropCoupon();
		dropCustomer();
		dropCustomerCoupon();
		dropCompanyCoupon();
	}

	// Create table company
	public static void createCompany() throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(sql, user, pasword);
			String sql = "create table if not exists Company  (" + "ID bigint  primary key not null, "
					+ "COMP_NAME varchar(50) not null, " + "PASSWORD varchar(50) not null , "
					+ "EMAIL varchar(50) not null  )";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate(sql);
			System.out.println("Created table Company");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
		}

	}

	// Create table customer
	public static void createCustomer() throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(sql, user, pasword);
			String sql = "create table if not exists  customer  (" + "ID bigint  primary key not null, "
					+ "CUST_NAME varchar(50) not null, " + "PASSWORD varchar(50) not null )";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate(sql);
			System.out.println("Created table Customer");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
		}

	}

	// Create table coupon
	public static void createCoupon() throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(sql, user, pasword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "create table if not exists Coupon  (" + "ID bigint primary key not null, "
				+ "TITLE varchar(50) not null , " + "START_DATE datetime not null ," + "END_DATE datetime not null,"
				+ "AMOUNT int not null , " + "TYPE varchar(50) not null ," + "MESSAGE varchar(50) not null ,"
				+ "PRICE double not null ," + "IMAGE varchar(50) not null)";

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
		}
		System.out.println("Created table Coupon");

	}
// Create CustomerCoupon
	public static void createCustomerCoupon() throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.sql, Database.user, Database.pasword);
		} catch (Exception e) {
			e.printStackTrace();

		}
		String sql = "create table if not exists CustomerCoupon  " + "(Cust_ID Bigint not null, "
				+ "COUPON_ID Bigint NOT NULL, FOREIGN KEY(Cust_ID) REFERENCES customer(ID), FOREIGN KEY(CUST_ID) REFERENCES Coupon(ID) ,"
				+ " PRIMARY KEY (CUST_ID, COUPON_ID) ) ";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
		}
		System.out.println("Created table CostumerCoupon");
	}

	// Create table company coupon
	public static void createCompanyCoupon() throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "create table if not exists CompanyCoupon  " + "(COMP_ID Bigint not null, "
				+ "COUPON_ID Bigint NOT NULL, FOREIGN KEY(COMP_ID) REFERENCES Company(ID), FOREIGN KEY(COUPON_ID) REFERENCES Coupon(ID) ,"
				+ " PRIMARY KEY (COMP_ID, COUPON_ID) ) ";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
		}
		System.out.println("Created table CompanyCoupon");
	}

	// Create table company coupon
	public static void CreateCompanyCoupon() throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "create table if not exists CompanyCoupon  " + "(COMP_ID Bigint not null, "
				+ "COUPON_ID Bigint NOT NULL, FOREIGN KEY(COMP_ID) REFERENCES Company(ID), FOREIGN KEY(COUPON_ID) REFERENCES Coupon(ID) ,"
				+ " PRIMARY KEY (COMP_ID, COUPON_ID) ) ";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);

			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
		}
		System.out.println("Created table CompanyCoupon");
	}

	// Create table CompanyCoupon
	public static void dropCompanyCoupon() throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "drop table if exists  CompanyCoupon";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);

			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
		}
		System.out.println("Table companyCoupon dropet");
	}

	// Drop table CustumerCoupon
	public static void dropCustomerCoupon() throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "drop table if  exists  CustomerCoupon";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);

			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
		}
		System.out.println("Table CustomerCoupon dropet");
	}

	// Drop table Coupon
	public static void dropCoupon() throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "drop table if exists Coupon";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);

			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
		}
		System.out.println("Table Coupon dropet");
	}

	// Drop table Customer
	public static void dropCustomer() throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "drop table if exists  Customer";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);

			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
		}
		System.out.println("Table Customer dropet");
	}

	// Drop table Company
	public static void dropCompany() throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "drop table if exists Company";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);

			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
		}
		System.out.println("Table company dropet");
	}
}

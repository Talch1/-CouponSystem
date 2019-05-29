package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {

	public String getDriverData() {
		return "com.mysql.jdbc.Driver";
	}

	public void createAllTables() throws SQLException, InterruptedException {
		createCustomer();
		createCompany();
		createCoupon();
		createCompanyCoupon();
		createCustomerCoupon();

	}

	// Drop all Tables
	public void dropAllTables() throws SQLException, InterruptedException {
		dropCompany();
		dropCoupon();
		dropCustomer();
		dropCustomerCoupon();
		dropCompanyCoupon();
	}

	// Create table company
	public void createCompany() throws SQLException, InterruptedException {
		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			String sql = "create table if not exists Company  (" + "ID bigint  primary key not null, "
					+ "COMPNAME varchar(50) not null, " + "PASSWORD varchar(50) not null , "
					+ "EMAIL varchar(50) not null  )";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate(sql);
			System.out.println("Created table Company");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}

	}

	// Create table customer
	public void createCustomer() throws SQLException, InterruptedException {
		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			String sql = "create table if not exists  customer  (" + "ID bigint  primary key not null, "
					+ "CUSTNAME varchar(50) not null, " + "PASSWORD varchar(50) not null )";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate(sql);
			System.out.println("Created table Customer");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}

	}

	// Create table coupon
	public void createCoupon() throws SQLException, InterruptedException {
		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();

			String sql = "create table if not exists Coupon  (" + "ID bigint primary key not null, "
					+ "TITLE varchar(50) not null , " + "START_DATE datetime not null ," + "END_DATE datetime not null,"
					+ "AMOUNT int not null , " + "TYPE varchar(50) not null ," + "MESSAGE varchar(50) not null ,"
					+ "PRICE double not null ," + "IMAGE varchar(50) not null)";

			PreparedStatement preparedStatement = null;

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}
		System.out.println("Created table Coupon");

	}

	// Create CustomerCoupon
	public void createCustomerCoupon() throws SQLException, InterruptedException {
		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();

			String sql = "create table if not exists CustomerCoupon  " + "(CUSTID Bigint not null, "
					+ "COUPONID Bigint NOT NULL, FOREIGN KEY(CUSTID) REFERENCES customer(ID), FOREIGN KEY(COUPONID) REFERENCES Coupon(ID) ,"
					+ " PRIMARY KEY (CUSTID, COUPONID) ) ";
			PreparedStatement preparedStatement = null;

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}
		System.out.println("Created table CostumerCoupon");
	}

	// Create table company coupon
	public void createCompanyCoupon() throws SQLException, InterruptedException {
		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();

			String sql = "create table if not exists CompanyCoupon (COMPID Bigint not null, "
					+ "COUPONID Bigint NOT NULL, FOREIGN KEY(COMPID) REFERENCES Company(ID), FOREIGN KEY(COUPONID) REFERENCES Coupon(ID) ,"
					+ " PRIMARY KEY (COMPID, COUPONID) ) ";
			PreparedStatement preparedStatement = null;

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}
		System.out.println("Created table CompanyCoupon");
	}


	// Create table CompanyCoupon
	public void dropCompanyCoupon() throws SQLException, InterruptedException {
		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();

			String sql = "drop table if exists  CompanyCoupon";
			PreparedStatement statement = null;

			statement = connection.prepareStatement(sql);

			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}
		System.out.println("Table companyCoupon dropet");
	}

	// Drop table CustumerCoupon
	public void dropCustomerCoupon() throws SQLException, InterruptedException {
		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();

			String sql = "drop table if  exists  CustomerCoupon";
			PreparedStatement statement = null;

			statement = connection.prepareStatement(sql);

			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}
		System.out.println("Table CustomerCoupon dropet");
	}

	// Drop table Coupon
	public void dropCoupon() throws SQLException, InterruptedException {
		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();

			String sql = "drop table if exists Coupon";
			PreparedStatement statement = null;

			statement = connection.prepareStatement(sql);

			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}
		System.out.println("Table Coupon dropet");
	}

	// Drop table Customer
	public void dropCustomer() throws SQLException, InterruptedException {
		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();

			String sql = "drop table if exists  Customer";
			PreparedStatement statement = null;

			statement = connection.prepareStatement(sql);

			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}
		System.out.println("Table Customer dropet");
	}

	// Drop table Company
	public void dropCompany() throws SQLException, InterruptedException {
		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();

			String sql = "drop table if exists Company";
			PreparedStatement statement = null;

			statement = connection.prepareStatement(sql);

			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}
		System.out.println("Table company dropet");
	}
}

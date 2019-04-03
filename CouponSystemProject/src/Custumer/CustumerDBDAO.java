package Custumer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

import Coupon.Coupon;
import DataBase.Database;

public class CustumerDBDAO implements CustumerDAO {
	public static void createCustumer(long id, String name, String pass) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());

		String query = " insert into custumer (id ,CUST_NAME ,password )" + " values (?, ?, ?)";

		// create the mysql insert preparedstatement
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		preparedStmt.setLong(1, id);
		preparedStmt.setString(2, name);
		preparedStmt.setString(3, pass);

		// execute the preparedstatement
		preparedStmt.execute();
		System.out.println("insreted to Custumer");

		connection.close();

	}

	public static void removeCustumer(long id) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql = "delete from  Custumer where id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setLong(1, id);
		preparedStatement.executeUpdate();
		System.out.println("deleted from Custumer");

	}

	public static void updateCompanyName(String name, long id) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql = "update Custumer set CUST_NAME = ? where id = ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setLong(2, id);
		preparedStatement.executeUpdate();

		System.out.println("COMP_NAME Custumer Updatet");

	}

	public static void updateCompanyPass(String pass, long id) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql = "update Custumer set pass = ? where id = ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, pass);
		preparedStatement.setLong(2, id);
		preparedStatement.executeUpdate();

		System.out.println("Password Custumer Updatet");
	}

	@Override
	public Custumer getCustumer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Coupon> getAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Coupon> getCoupon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean login() {
		// TODO Auto-generated method stub
		return false;
	}

}

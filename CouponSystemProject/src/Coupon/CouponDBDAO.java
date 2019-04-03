package Coupon;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.Collection;

import DataBase.Database;

public class CouponDBDAO implements CouponDAO {

	public static void createCoupon(long id, String title, Date startc, Date endc, int amount, String type,
			String message, double price, String image) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());

		String query = " insert into coupon (id ,title ,START_DATE , END_DATE, amount ,type , message , price, image)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ? ,?)";

		// create the mysql insert preparedstatement
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		preparedStmt.setLong(1, id);
		preparedStmt.setString(2, title);
		preparedStmt.setDate(3, startc);
		preparedStmt.setDate(4, endc);
		preparedStmt.setDouble(5, amount);
		preparedStmt.setString(6, type);
		preparedStmt.setString(7, message);
		preparedStmt.setDouble(8, price);
		preparedStmt.setString(9, image);

		// execute the preparedstatement
		preparedStmt.execute();
		System.out.println("insreted to Coupon");

		connection.close();
	}

	public static void removeCoupon(long id) throws SQLException {
		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql = String.format("delete from  Coupon where id = %d", id);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.executeUpdate();
		System.out.println("deleted from Coupon");

	}

	public static void updateCouponTitle(String title, long id) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql = String.format("update coupon set TITLE = \"%s\" where id = 5 ", title, id);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.executeUpdate();
		System.out.println("Coupon Title Updated");

	}

	public static void updateCouponStart_Date(Date START_DATE, long idCoupon) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql = "update coupon set START_DATE = " + START_DATE + " where id = " + idCoupon;

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.executeUpdate();
		System.out.println("Coupon StartDate Updated");
	}

	public static void updateCouponEnd_Date(Date END_DATE, long idCoupon) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql = "update coupon set End_DATE = " + END_DATE + " where id =  " + idCoupon;

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.executeUpdate();
		System.out.println("Coupon EndDate Updated");
	}

	public static void updateCouponAmount(int amount, long id) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql = String.format("update coupon set amount = \"%d\" where id = %d ", amount, id);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.executeUpdate();
		System.out.println("Coupon Amount Updated");

	}
	public static void updateCouponType(String type, long id) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql = String.format("update coupon set type = \"%s\" where id = 5 ", type, id);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.executeUpdate();
		System.out.println("Coupon type Updated");
	}

	public static void updateCouponMessage(String message, long id) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql = String.format("update coupon set type = \"%s\" where id = 5 ", message, id);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.executeUpdate();
		System.out.println("Coupon type Message");
	}
	@Override
	public Coupon getCustumer() {
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
	public Collection<Coupon> getCouponByType() {
		// TODO Auto-generated method stub
		return null;
	}

}

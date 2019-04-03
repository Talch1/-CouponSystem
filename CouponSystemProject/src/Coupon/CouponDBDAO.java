package Coupon;

import java.awt.Window.Type;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;

import Company.Company;
import DataBase.Database;

public class CouponDBDAO implements CouponDAO {

	public static void createCoupon(long id,String title,Date startc,Date endc,double amount,String type,String message,double price,String image) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());

		String query = " insert into coupon (id ,title ,START_DATE , END_DATE, amount ,type , message , price, image)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ? ,?)";

		// create a sql date object so we can use it in our INSERT statement
		Calendar calendar = Calendar.getInstance();
		java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

		Calendar calendar1 = Calendar.getInstance();
		java.sql.Date endDate = new java.sql.Date(calendar1.getTime().getTime());

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

	public static void updateCoupon() {
		// TODO Auto-generated method stub

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

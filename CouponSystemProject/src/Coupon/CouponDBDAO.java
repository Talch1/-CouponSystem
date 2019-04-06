package Coupon;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.Collection;

import DataBase.Database;

public class CouponDBDAO implements CouponDAO {

	// insert coupon to table
	public static void createCoupon(Coupon coupon) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());

		String query = " insert into coupon (id ,title ,START_DATE , END_DATE, amount ,type , message , price, image)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ? ,?)";

		// create the mysql insert preparedstatement
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		preparedStmt.setLong(1, coupon.getId());
		preparedStmt.setString(2, coupon.getTitle());
		preparedStmt.setDate(3, coupon.getStartDate());
		preparedStmt.setDate(4, coupon.getEndDate());
		preparedStmt.setDouble(5, coupon.getAmount());
		preparedStmt.setObject(6, coupon.getType());
		preparedStmt.setString(7, coupon.getMessage());
		preparedStmt.setDouble(8, coupon.getPrice());
		preparedStmt.setString(9, coupon.getImage());

		// execute the preparedstatement
		preparedStmt.execute();
		System.out.println(" Coupon created");

		connection.close();
	}

	public static void removeCoupon(Coupon coupon) throws SQLException {
		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql = "delete from  Coupon where id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setLong(1, coupon.getId());
		preparedStatement.executeUpdate();
		System.out.println("deleted from Coupon");

	}

	public static void updateCoupon(Coupon coupon) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql = "update coupon set TITLE = ?, START_DATE =  ?,END_DATE = ? ,amount = ?,type = ?,price = ?, image = ?  where id =  ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, coupon.getTitle());
		preparedStatement.setDate(2, coupon.getStartDate());
		preparedStatement.setDate(3, coupon.getEndDate());
		preparedStatement.setInt(4, coupon.getAmount());
		preparedStatement.setObject(5, coupon.getType());
		preparedStatement.setDouble(6, coupon.getPrice());
		preparedStatement.setString(7, coupon.getImage());
		preparedStatement.setLong(8, coupon.getId());

		preparedStatement.executeUpdate();
		System.out.println("Coupon Updated");

	}

	@Override
	public Coupon getCustumer(long id) {
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

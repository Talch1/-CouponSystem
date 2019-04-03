package Coupon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Collection;

import Company.Company;
import DataBase.Database;

public class CouponDBDAO implements CouponDAO {

	@Override
	public void createCoupon() throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());

		String query = " insert into users (id ,title ,startDate , endDate, amount ,type , message , price, image)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ? ,?)";

		// create a sql date object so we can use it in our INSERT statement
		Calendar calendar = Calendar.getInstance();
		java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

		Calendar calendar1 = Calendar.getInstance();
		java.sql.Date endDate = new java.sql.Date(calendar1.getTime().getTime());

		// create the mysql insert preparedstatement
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		preparedStmt.setLong(1, Coupon.getId());
		preparedStmt.setString(2,Coupon.getTitle());
		preparedStmt.setDate(3, Coupon.getStartDate());
		preparedStmt.setDate(4, Coupon.getEndDate());
		preparedStmt.setInt(5, Coupon.getAmount());
		preparedStmt.setString(6, Coupon.getType());
		preparedStmt.setString(7,Coupon.getMessage() );
		preparedStmt.setDouble(8, Coupon.getPrice());
		preparedStmt.setString(9,Coupon.getImage());

		// execute the preparedstatement
		preparedStmt.execute();

		connection.close();
	}

	@Override
	public void removeCoupon() throws SQLException {
		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql = String.format("delete from  Coupon where id = %d",Coupon.getId());
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.executeUpdate();
		System.out.println("deleted from Coupon");


}

	

	@Override
	public void updateCoupon() {
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

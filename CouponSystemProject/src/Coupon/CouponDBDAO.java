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
		String sql = "delete from  Coupon where id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setLong(1, id);
		preparedStatement.executeUpdate();
		System.out.println("deleted from Coupon");

	}

	public static void updateCouponTitle(String title, long id) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql = "update coupon set TITLE = ? where id =  ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, title);
		preparedStatement.setLong(2, id);


		preparedStatement.executeUpdate();
		System.out.println("Coupon Title Updated");

	}

	public static void updateCouponStart_Date(Date START_DATE, long idCoupon) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql = "update coupon set START_DATE =  ?  where id =  ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setDate(1, START_DATE);
		preparedStatement.setLong(2, idCoupon);
		preparedStatement.executeUpdate();
		System.out.println("Coupon StartDate Updated");
	}

	public static void updateCouponEnd_Date(Date END_DATE, long idCoupon) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql = "update coupon set End_DATE = ? where id = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setDate(1, END_DATE);
		preparedStatement.setLong(2, idCoupon);
		preparedStatement.executeUpdate();
		System.out.println("Coupon EndDate Updated");
	}

	public static void updateCouponAmount(int amount, long id) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql = String.format("update coupon set amount = ? where id = ? ");
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, amount);
		preparedStatement.setLong(2, id);
		preparedStatement.executeUpdate();
		System.out.println("Coupon Amount Updated");

	}
	public static void updateCouponType(String type, long id) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql = String.format("update coupon set type = ? where id = ? ");
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, type);
		preparedStatement.setLong(2, id);
		preparedStatement.executeUpdate();
		System.out.println("Coupon type Updated");
	}

	public static void updateCouponMessage(String message, long id) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql ="update coupon set type = ? where id = ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1,message);
		preparedStatement.setLong(2, id);
		preparedStatement.executeUpdate();
		System.out.println("Coupon Message Updated");
	}
		public static void updateCouponPrice(double price, long id) throws SQLException {

			Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
					Database.getPasword());
			String sql ="update coupon set price = ? where id = ? ";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1,price);
			preparedStatement.setLong(2, id);
			preparedStatement.executeUpdate();
			System.out.println("Coupon price Updated");
		}
			public static void updateCoupon(String image, long id) throws SQLException {

				Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
						Database.getPasword());
				String sql ="update coupon set image = ? where id = ? ";
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1,image);
				preparedStatement.setLong(2, id);
				preparedStatement.executeUpdate();
				System.out.println("Coupon image Updated");
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

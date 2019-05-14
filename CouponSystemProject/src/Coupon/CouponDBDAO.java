package Coupon;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import Company.Company;
import DataBase.ConnectionPool;
import DataBase.Database;

public class CouponDBDAO implements CouponDAO {

	// insert coupon to table
	public void createCoupon(Coupon coupon) throws SQLException, InterruptedException {

		Connection connection = null;

		connection = ConnectionPool.getInstance().getConnection();

		String query = " insert into coupon (id ,title ,START_DATE , END_DATE, amount ,type , message , price, image)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ? ,?)";

		PreparedStatement preparedStmt;
		try {
			preparedStmt = connection.prepareStatement(query);

			preparedStmt.setLong(1, coupon.getId());
			preparedStmt.setString(2, coupon.getTitle());
			preparedStmt.setDate(3, (java.sql.Date) coupon.getStartDate());
			preparedStmt.setDate(4, (java.sql.Date) coupon.getEndDate());
			preparedStmt.setDouble(5, coupon.getAmount());
			String type = coupon.getType().toString();

			preparedStmt.setString(6, type);
			preparedStmt.setString(7, coupon.getMessage());
			preparedStmt.setDouble(8, coupon.getPrice());
			preparedStmt.setString(9, coupon.getImage());

			preparedStmt.execute();
			System.out.println(" Coupon created");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}

	}

	public void removeCoupon(Coupon coupon) throws SQLException, InterruptedException {
		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();

			String sql = "delete from  Coupon where id = ?";
			PreparedStatement preparedStatement;

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setLong(1, coupon.getId());
			preparedStatement.executeUpdate();
			System.out.println("deleted from Coupon");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}
	}

	public void deleteExpirdCoup(Date date) throws SQLException, InterruptedException {

		ArrayList<Coupon> list = getAllCoupons();

		for (Coupon coupon : list) {
			if (coupon.getEndDate().before(date)) {
				removeCoupon(coupon);
			}

		}
	}

	public void updateCoupon1(Coupon coupon) throws InterruptedException {
		String sql = "update coupon set TITLE = ?, START_DATE =  ?,END_DATE = ? ,amount = ?,type = ?,price = ?, image = ?  where id =  ?";
		Connection connection = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, coupon.getTitle());
			preparedStatement.setDate(2, (java.sql.Date) coupon.getStartDate());
			preparedStatement.setDate(3, (java.sql.Date) coupon.getEndDate());
			preparedStatement.setInt(4, coupon.getAmount());
			preparedStatement.setObject(5, coupon.getType());
			preparedStatement.setDouble(6, coupon.getPrice());
			preparedStatement.setString(7, coupon.getImage());
			preparedStatement.setLong(8, coupon.getId());

			preparedStatement.executeUpdate();
			System.out.println("Coupon Updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateCoupon(Coupon coupon) throws SQLException, InterruptedException {

		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();

			String sql = "update coupon set END_DATE = ? ,price = ?  where id =  ?";
			PreparedStatement preparedStatement = null;

			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setDate(1, (java.sql.Date) coupon.getEndDate());
			preparedStatement.setDouble(2, coupon.getPrice());
			preparedStatement.setLong(3, coupon.getId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}
		System.out.println("Coupon Updated");

	}

	@Override
	public ArrayList<Coupon> getAllCoupons() throws InterruptedException {
		ArrayList<Coupon> coupons = new ArrayList<>();

		Connection connection = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			Coupon coupon = new Coupon();
			String sql = "SELECT * FROM Coupon ";
			PreparedStatement preparedStatement = null;

			preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet;
			resultSet = preparedStatement.executeQuery(sql);
			resultSet.next();
			while (resultSet.next()) {
				coupon.setId(resultSet.getLong(1));
				coupon.setTitle(resultSet.getString(2));
				coupon.setStartDate(resultSet.getDate(3));
				coupon.setEndDate(resultSet.getDate(4));
				coupon.setAmount(resultSet.getInt(5));
				String returnType = resultSet.getString(6);
				switch (resultSet.getString(6)) {

				case "Food":
					coupon.setType(CouponType.FOOD);
					break;

				case "RESTURANS":
					coupon.setType(CouponType.RESTURANS);
					break;

				case "ELECTRICITY":
					coupon.setType(CouponType.ELECTRICITY);
					break;

				case "HEALTH":
					coupon.setType(CouponType.HEALTH);
					break;

				case "SPORTS":
					coupon.setType(CouponType.SPORTS);
					break;

				case "CAMPING":
					coupon.setType(CouponType.CAMPING);
					break;

				case "TRAVELLING":
					coupon.setType(CouponType.TRAVELLING);
					break;
				default:
					break;
				}
				coupon.setMessage(resultSet.getString(7));
				coupon.setPrice(resultSet.getDouble(8));
				coupon.setImage(resultSet.getString(9));

				coupons.add(coupon);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}

		return coupons;
	}

	public Coupon getCoupon(long id) throws SQLException, InterruptedException {

		Connection connection = null;
		Coupon coupon = new Coupon();

		connection = ConnectionPool.getInstance().getConnection();

		String sql = "SELECT * FROM coupon WHERE ID = " + id;

		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(sql);

			ResultSet rs = preparedStatement.executeQuery(sql);

			while (rs.next()) {
				coupon.setId(rs.getLong(1));
				coupon.setTitle(rs.getString(2));
				coupon.setStartDate(rs.getDate(3));
				coupon.setEndDate(rs.getDate(4));
				coupon.setAmount(rs.getInt(5));
				String returnType = rs.getString(6);
				switch (rs.getString(6)) {

				case "Food":
					coupon.setType(CouponType.FOOD);
					break;

				case "RESTURANS":
					coupon.setType(CouponType.RESTURANS);
					break;

				case "ELECTRICITY":
					coupon.setType(CouponType.ELECTRICITY);
					break;

				case "HEALTH":
					coupon.setType(CouponType.HEALTH);
					break;

				case "SPORTS":
					coupon.setType(CouponType.SPORTS);
					break;

				case "CAMPING":
					coupon.setType(CouponType.CAMPING);
					break;

				case "TRAVELLING":
					coupon.setType(CouponType.TRAVELLING);
					break;
				default:
					break;
				}
				coupon.setMessage(rs.getString(7));
				coupon.setPrice(rs.getDouble(8));
				coupon.setImage(rs.getString(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}
		return coupon;
	}

	public Collection<Coupon> getCouponByType(CouponType type) throws SQLException, InterruptedException {

		Coupon coupon = new Coupon();
		Connection connection = null;

		connection = ConnectionPool.getInstance().getConnection();

		ArrayList<Coupon> coupons = new ArrayList<>();
		String sql = "SELECT * FROM coupon WHERE Type = " + type;

		try {
			PreparedStatement preparedStatement = null;

			preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet;
			resultSet = preparedStatement.executeQuery(sql);
			resultSet.next();
			while (resultSet.next()) {
				coupon.setId(resultSet.getLong(1));
				coupon.setTitle(resultSet.getString(2));
				coupon.setStartDate(resultSet.getDate(3));
				coupon.setEndDate(resultSet.getDate(4));
				coupon.setAmount(resultSet.getInt(5));
				String returnType = resultSet.getString(6);
				switch (resultSet.getString(6)) {

				case "Food":
					coupon.setType(CouponType.FOOD);
					break;

				case "RESTURANS":
					coupon.setType(CouponType.RESTURANS);
					break;

				case "ELECTRICITY":
					coupon.setType(CouponType.ELECTRICITY);
					break;

				case "HEALTH":
					coupon.setType(CouponType.HEALTH);
					break;

				case "SPORTS":
					coupon.setType(CouponType.SPORTS);
					break;

				case "CAMPING":
					coupon.setType(CouponType.CAMPING);
					break;

				case "TRAVELLING":
					coupon.setType(CouponType.TRAVELLING);
					break;
				default:
					break;
				}
				coupon.setMessage(resultSet.getString(7));
				coupon.setPrice(resultSet.getDouble(8));
				coupon.setImage(resultSet.getString(9));

				coupons.add(coupon);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}

		return coupons;
	}

}

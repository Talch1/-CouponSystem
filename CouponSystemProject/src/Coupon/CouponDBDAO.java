package Coupon;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import Company.Company;
import DataBase.Database;

public class CouponDBDAO implements CouponDAO {

	// insert coupon to table
	public static void createCoupon(Coupon coupon) throws SQLException {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String query = " insert into coupon (id ,title ,START_DATE , END_DATE, amount ,type , message , price, image)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ? ,?)";

		// create the mysql insert preparedstatement
		PreparedStatement preparedStmt;
		try {
			preparedStmt = connection.prepareStatement(query);

			preparedStmt.setLong(1, coupon.getId());
			preparedStmt.setString(2, coupon.getTitle());
			preparedStmt.setDate(3, (Date) coupon.getStartDate());
			preparedStmt.setDate(4, (Date) coupon.getEndDate());
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
			connection.close();
		}

	}

	public static void removeCoupon(Coupon coupon) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "delete from  Coupon where id = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setLong(1, coupon.getId());
			preparedStatement.executeUpdate();
			System.out.println("deleted from Coupon");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	public static void updateCoupon(Coupon coupon) throws SQLException {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
		}
		String sql = "update coupon set TITLE = ?, START_DATE =  ?,END_DATE = ? ,amount = ?,type = ?,price = ?, image = ?  where id =  ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		preparedStatement.setString(1, coupon.getTitle());
		preparedStatement.setDate(2, (Date) coupon.getStartDate());
		preparedStatement.setDate(3, (Date) coupon.getEndDate());
		preparedStatement.setDouble(4, coupon.getAmount());
		String type = coupon.getType().toString();

		preparedStatement.setString(5, type);
		preparedStatement.setString(6, coupon.getMessage());
		preparedStatement.setDouble(7, coupon.getPrice());
		preparedStatement.setString(8, coupon.getImage());
		preparedStatement.setLong(9, coupon.getId());

		try {
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Coupon Updated");

	}

	@Override
	public Collection<Coupon> getAllCoupons() throws SQLException {
		ArrayList<Coupon> coupons = new ArrayList<>();

		Connection connection = null;

		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Coupon coupon = new Coupon();
		String sql = "SELECT * FROM Coupon ";
		PreparedStatement preparedStatement = null;
		try {
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

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			connection.close();
		}

		return coupons;
	}

	public Coupon getCoupon(int id) throws SQLException {

		Connection connection = null;
		Coupon coupon = new Coupon();
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
			connection.close();
		}
		return coupon;
	}

	public Collection<Coupon> getCouponByType(CouponType type) throws SQLException {

		Coupon coupon = new Coupon();
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Coupon> coupons = new ArrayList<>();
		String sql = "SELECT * FROM coupon WHERE Type = " + type;

		try {
		PreparedStatement	preparedStatement = null;

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
			connection.close();
		}

		return coupons;
	}


}

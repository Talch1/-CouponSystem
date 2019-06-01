package Coupon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Company.Company;
import Company.CompanyDBDAO;

import java.sql.Date;
import DataBase.ConnectionPool;
import Exeptions.ExistEx;

public class CouponDBDAO implements CouponDAO {

	// create Coupon(insert to Coupon)
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
			preparedStmt.setDate(3, coupon.getStartDate());
			preparedStmt.setDate(4, coupon.getEndDate());
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

	// remove Coupon(delete from Coupon)
	public void removeCoupon(Coupon coupon) throws SQLException, InterruptedException, ExistEx {


		CouponDBDAO cDbdao = new CouponDBDAO();
		ArrayList<Coupon> coupons = cDbdao.getAllCoupons();
		boolean chek = false;
		for (Coupon coupon1 : coupons) {
			if (coupon1.getId() == coupon.getId()) {
				chek = true;
			}
		}
		if (chek == false) {
			throw new ExistEx("Coupon doesn't exist");
		}
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

	public void deleteExpirdCoup(Date date) throws SQLException, InterruptedException, ExistEx {

		ArrayList<Coupon> list = getAllCoupons();

		for (Coupon coupon : list) {
			if (coupon.getEndDate().before(date)) {
				removeCoupon(coupon);
			}

		}
	}

	// update Coupon(all Coupon data members)
	public void updateCoupon1(Coupon coupon) throws InterruptedException, ExistEx {
		


		CouponDBDAO cDbdao = new CouponDBDAO();
		ArrayList<Coupon> coupons = cDbdao.getAllCoupons();
		boolean chek = false;
		for (Coupon coupon1 : coupons) {
			if (coupon1.getId() == coupon.getId()) {
				chek = true;
			}
		}
		if (chek == false) {
			throw new ExistEx("Coupon doesn't exist");
		}
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

	// update Coupon(update End date and price)
	public void updateCoupon(Coupon coupon) throws SQLException, InterruptedException, ExistEx {

		CouponDBDAO cDbdao = new CouponDBDAO();
		ArrayList<Coupon> coupons = cDbdao.getAllCoupons();
		boolean chek = false;
		for (Coupon coupon1 : coupons) {
			if (coupon1.getId() == coupon.getId()) {
				chek = true;
			}
		}
		if (chek == false) {
			throw new ExistEx("Coupon doesn't exist");
		}
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

	// get All Coupons
	@Override
	public ArrayList<Coupon> getAllCoupons() throws InterruptedException {
		ArrayList<Coupon> coupons = new ArrayList<>();

		Connection connection = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			String sql = "SELECT * FROM Coupon ";
			PreparedStatement preparedStatement = null;

			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = null;
			resultSet = preparedStatement.executeQuery();
	
			while (resultSet.next()) {
				Coupon coupon = new Coupon();
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
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}

		return coupons;
	}

	// get Coupon By Id
	public Coupon getCoupon(long id) throws SQLException, InterruptedException {

		Connection connection = null;
		Coupon coupon = new Coupon();

		connection = ConnectionPool.getInstance().getConnection();

		String sql = "SELECT * FROM coupon WHERE ID = ?";

		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setLong(1, id);
			preparedStatement.execute();
			ResultSet rs = preparedStatement.executeQuery();

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

	// get Coupon by Type
	@Override
	public ArrayList<Coupon> getCouponByType(CouponType type) throws SQLException, InterruptedException {

		
		Connection connection = null;

		connection = ConnectionPool.getInstance().getConnection();

		ArrayList<Coupon> coupons = new ArrayList<>();
		String sql = "SELECT * FROM coupon WHERE Type = ?";

		try {
			PreparedStatement preparedStatement = null;

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, type.name());
			ResultSet resultSet;
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Coupon coupon = new Coupon();
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

	public ArrayList<Coupon> getCouponByPrice(double price) throws SQLException, InterruptedException {

		Coupon coupon = new Coupon();
		Connection connection = null;

		connection = ConnectionPool.getInstance().getConnection();

		ArrayList<Coupon> coupons = new ArrayList<>();
		String sql = "SELECT * FROM coupon WHERE Price = ?";

		try {
			PreparedStatement preparedStatement = null;

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDouble(1, price);
			ResultSet resultSet;
			resultSet = preparedStatement.executeQuery();
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

	public ArrayList<Coupon> getCouponByDate(Date date) throws SQLException, InterruptedException {

		Coupon coupon = new Coupon();
		Connection connection = null;

		connection = ConnectionPool.getInstance().getConnection();

		ArrayList<Coupon> coupons = new ArrayList<>();
		String sql = "SELECT * FROM coupon WHERE End_date < ?";

		try {
			PreparedStatement preparedStatement = null;

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDate(1, date);
			ResultSet resultSet;
			resultSet = preparedStatement.executeQuery();
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

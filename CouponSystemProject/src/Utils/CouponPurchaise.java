package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Coupon.Coupon;
import Coupon.CouponDBDAO;
import Coupon.CouponType;
import CustomerCoupon.CustomerCouponDBDAO;
import DataBase.ConnectionPool;
import DataBase.Database;

public class CouponPurchaise {
	

	
	public static ArrayList<CustomerCouponDBDAO> getAllCustumerCoupons() throws SQLException, InterruptedException {
		Connection connection = null;
		ArrayList<CustomerCouponDBDAO> list = new ArrayList<>();

		try {
			connection = ConnectionPool.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CustomerCouponDBDAO custumerCouponDBDAO = new CustomerCouponDBDAO();
		PreparedStatement preparedStatement = null;
		String sql = "SELECT * FROM CustomerCoupon ";
		try {
			preparedStatement = connection.prepareStatement(sql);

			ResultSet rs = preparedStatement.executeQuery(sql);
			while (rs.next()) {

				custumerCouponDBDAO.setCust_id(rs.getLong(1));
				custumerCouponDBDAO.setCoupon_id(rs.getLong(2));
				list.add(custumerCouponDBDAO);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);

		}

		return list;

	}

	public static ArrayList<Coupon> getAllpurchoiseCoupons() throws SQLException, InterruptedException {
		CouponDBDAO coupon = new CouponDBDAO();
		ArrayList<Coupon> list = new ArrayList<>();
		for (CustomerCouponDBDAO coupons : getAllCustumerCoupons()) {
			list.add(coupon.getCoupon(coupons.getCoupon_id()));

		}

		return list;

	}

	public static ArrayList<Coupon> getAllPurchaiseCouponByPrice(double price) throws SQLException, InterruptedException {
		ArrayList<Coupon> alloupons = new ArrayList<>();
		ArrayList<Coupon> byprice = new ArrayList<>();
		alloupons = getAllpurchoiseCoupons();
		for (Coupon coupon : alloupons) {
			if (coupon.getPrice() == price) {
				byprice.add(coupon);
			}
		}
		return byprice;

	}

	public static ArrayList<Coupon> getAllPurchaiseCouponByType(CouponType type) throws SQLException, InterruptedException {
		ArrayList<Coupon> alloupons = new ArrayList<>();
		ArrayList<Coupon> bytype = new ArrayList<>();
		alloupons = getAllpurchoiseCoupons();
		for (Coupon coupon : alloupons) {
			if (coupon.getType() == type) {
				bytype.add(coupon);
			}
		}
		return bytype;

	}
	
	
	public static void deletefromCustcoup(long id) throws SQLException, InterruptedException {
		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = String.format("delete from  CustomerCoupon where cust_id = ?");
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setLong(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);

		}
		System.out.println("Deleted from CustomerCoupon");

	}
		
	
}
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
import CustumerCoupon.CustumerCouponDBDAO;
import DataBase.Database;

public class CouponPurchaise {

	public static ArrayList<CustumerCouponDBDAO> getAllCustumerCoupons() throws SQLException {
		Connection connection = null;
		ArrayList<CustumerCouponDBDAO> list = new ArrayList<>();

		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CustumerCouponDBDAO custumerCouponDBDAO = new CustumerCouponDBDAO();
		PreparedStatement preparedStatement = null;
		String sql = "SELECT * FROM CustumerCoupon ";
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
			connection.close();
		}

		return list;

	}

	public static ArrayList<Coupon> getAllpurchoiseCoupons() throws SQLException {
		CouponDBDAO coupon = new CouponDBDAO();
		ArrayList<Coupon> list = new ArrayList<>();
		for (CustumerCouponDBDAO coupons : getAllCustumerCoupons()) {
			list.add(coupon.getCoupon(coupons.getCoupon_id()));

		}

		return list;

	}

	public static ArrayList<Coupon> getAllPurchaiseCouponByPrice(double price) throws SQLException {
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

	public static ArrayList<Coupon> getAllPurchaiseCouponByType(CouponType type) throws SQLException {
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
}
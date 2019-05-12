package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import CompanyCoupon.CompanyCouponDBDAO;
import Coupon.Coupon;
import Coupon.CouponDBDAO;
import DataBase.Database;

public class CompCoup {
	public static ArrayList<CompanyCouponDBDAO> getAllCompanyCoupon() throws SQLException {
		ArrayList<CompanyCouponDBDAO> companyCouponDBDAOs = new ArrayList<>();
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CompanyCouponDBDAO companyCouponDBDAO = new CompanyCouponDBDAO();
		PreparedStatement preparedStatement;
		try {

			String sql = "SELECT * FROM CompanyCoupon ";

			preparedStatement = connection.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery(sql);
			while (rs.next()) {

				companyCouponDBDAO.setComp_id(rs.getLong(1));
				companyCouponDBDAO.setCoupon_id(rs.getLong(2));
				companyCouponDBDAOs.add(companyCouponDBDAO);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return companyCouponDBDAOs;
	}

	public static ArrayList<Long> getCouponsId() {

		ArrayList<Long> ids = new ArrayList<>();
		ArrayList<CompanyCouponDBDAO> companyCouponDBDAOs = new ArrayList<>();

		for (CompanyCouponDBDAO companyCouponDBDAO : companyCouponDBDAOs) {
			ids.add(companyCouponDBDAO.getCoupon_id());
		}

		return ids;

	}

	public static ArrayList<Coupon> allCouponsOfCompany() throws SQLException {
		CouponDBDAO coupon = new CouponDBDAO();
		ArrayList<Coupon> allCoupons = new ArrayList<>();
		ArrayList<Long> ids = new ArrayList<>();
		for (Long long1 : ids) {
			allCoupons.add(coupon.getCoupon(long1));
		}
		return allCoupons;

	}
	public static void deletefromCompcoup(long id) throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = String.format("delete from  CompanyCoupon where comp_id = ?");
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setLong(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
		}
		System.out.println("Deleted from CompanyCoupon");

}
}

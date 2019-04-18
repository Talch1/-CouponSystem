package CompanyCoupon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Coupon.Coupon;
import DataBase.Database;

public class CompanyCouponDBDAO implements CompanyCouponDAO {

	private long comp_id;
	private long coupon_id;

	public long getComp_id() {
		return comp_id;
	}

	public void setComp_id(long comp_id) {
		this.comp_id = comp_id;
	}

	public long getCoupon_id() {
		return coupon_id;
	}

	public void setCoupon_id(long coupon_id) {
		this.coupon_id = coupon_id;
	}

		public static void removeJoinCompanyCoupon(Coupon coupon) {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "delete from CompanyCoupon where COUPON_ID = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			preparedStatement.setLong(1, coupon.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("deleted from table CompanyCoupon");

	}

	public static CompanyCouponDBDAO getJoinCompany_Coupon(int id) {

		Connection connection = null;

		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CompanyCouponDBDAO companyCouponDBDAO = new CompanyCouponDBDAO();
		Statement stm;
		try {
			stm = connection.createStatement();

			String sql = "SELECT * FROM CompanyCoupon WHERE COUPON_ID = " + id;
			ResultSet rs = stm.executeQuery(sql);
			rs.next();

			companyCouponDBDAO.setComp_id(rs.getLong(1));
			companyCouponDBDAO.setCoupon_id(rs.getLong(2));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return companyCouponDBDAO;

	}

	@Override
	public String toString() {
		return "CompanyCouponDBDAO [comp_id=" + comp_id + ", coupon_id=" + coupon_id + "]";
	}

}

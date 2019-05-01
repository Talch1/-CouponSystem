package CustumerCoupon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Coupon.Coupon;
import Coupon.CouponDBDAO;
import DataBase.Database;

public class CustumerCouponDBDAO implements CustumerCouponDAO {

	private long cust_id;
	private long coupon_id;

	public long getCust_id() {
		return cust_id;
	}

	public void setCust_id(long cust_id) {
		this.cust_id = cust_id;
	}

	public long getCoupon_id() {
		return coupon_id;
	}

	public void setCoupon_id(long coupon_id) {
		this.coupon_id = coupon_id;
	}

	public static void removeCustumerCoupon(Coupon coupon) throws SQLException {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "delete from  CustumerCoupon where COUPON_ID = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setLong(1, coupon.getId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
		}
		System.out.println("deleted from table CustumerCoupon");

	}

	public static ArrayList<CustumerCouponDBDAO> getCustumerCoupon(long l) throws SQLException {
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
		String sql = "SELECT * FROM CustumerCoupon WHERE CUST_ID = " + l;
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
	
		
		
	}

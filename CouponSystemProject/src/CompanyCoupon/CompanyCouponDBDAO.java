package CompanyCoupon;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import Coupon.Coupon;
import DataBase.ConnectionPool;

public class CompanyCouponDBDAO implements CompanyCouponDAO {

	// Data members
	private long comp_id;
	private long coupon_id;

	// Getters Setters
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

	// remove Company Coupon(company delete coupon)
	@Override
	public void removeCompanyCoupon(Coupon coupon) throws InterruptedException {

		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "delete from CompanyCoupon where COUPON_ID = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setLong(1, coupon.getId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}
		System.out.println("Dfeleted from table CompanyCoupon");

	}

	// Get coupon in Companys by id
	@Override
	public CompanyCouponDBDAO getCompanyCoupon(int id) throws InterruptedException, SQLException {

		Connection connection = null;

		connection = ConnectionPool.getInstance().getConnection();

		CompanyCouponDBDAO companyCouponDBDAO = new CompanyCouponDBDAO();
		PreparedStatement preparedStatement;

		String sql = "SELECT * FROM CompanyCoupon WHERE COUPON_ID = " + id;

		try {
			preparedStatement = connection.prepareStatement(sql);

			ResultSet rs = preparedStatement.executeQuery(sql);
			rs.next();

			companyCouponDBDAO.setComp_id(rs.getLong(1));
			companyCouponDBDAO.setCoupon_id(rs.getLong(2));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}
		return companyCouponDBDAO;

	}

	// get all coupons in Companys
	@Override
	public ArrayList<CompanyCouponDBDAO> getAllCompanyCoupon() throws SQLException, InterruptedException {
		ArrayList<CompanyCouponDBDAO> companyCouponDBDAOs = new ArrayList<>();
		Connection connection = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();
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
			ConnectionPool.getInstance().returnConnection(connection);

		}
		return companyCouponDBDAOs;
	}

   
    //delete all coupons of company
	@Override
	public void deletefromCompcoupByCompID(long id) throws SQLException, InterruptedException {
		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "delete from  CompanyCoupon where comp_id = ?";
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
		System.out.println("Deleted from CompanyCoupon");

	}
//ToString
	@Override
	public String toString() {
		return "CompanyCouponDBDAO [comp_id=" + comp_id + ", coupon_id=" + coupon_id + "]";
	}

}

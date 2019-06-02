package CompanyCoupon;

import java.awt.List;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import Coupon.Coupon;
import Coupon.CouponDBDAO;
import DataBase.ConnectionPool;
import Exeptions.DateProblem;
import Exeptions.ExistEx;

public class CompanyCouponDBDAO implements CompanyCouponDAO {

	// Data members
	private long compId;
	private long couponId;

	// Getters Setters
	public long getCompId() {
		return compId;
	}

	public void setCompId(long compId) {
		this.compId = compId;
	}

	public long getCouponId() {
		return couponId;
	}

	public void setCouponId(long couponId) {
		this.couponId = couponId;
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
		String sql = "delete from CompanyCoupon where COUPONID = ?";
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
	public ArrayList<CompanyCouponDBDAO> getCompanyCoupon(long compid) throws InterruptedException, SQLException {
		ArrayList<CompanyCouponDBDAO> list = new ArrayList<>();
		Connection connection = null;

		connection = ConnectionPool.getInstance().getConnection();

		PreparedStatement preparedStatement;

		String sql = "SELECT * FROM CompanyCoupon WHERE COMPID = ? ";

		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setLong(1, compid);
			preparedStatement.execute();
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				CompanyCouponDBDAO companyCouponDBDAO = new CompanyCouponDBDAO();
				companyCouponDBDAO.setCompId(rs.getLong(1));
				companyCouponDBDAO.setCouponId(rs.getLong(2));
				list.add(companyCouponDBDAO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}
		return list;

	}

	public ArrayList<CompanyCouponDAO> getCompanyCoupon() throws InterruptedException, SQLException {
		ArrayList<CompanyCouponDAO> list = new ArrayList<>();
		Connection connection = null;

		connection = ConnectionPool.getInstance().getConnection();

		CompanyCouponDBDAO companyCouponDBDAO = new CompanyCouponDBDAO();
		PreparedStatement preparedStatement;

		String sql = "SELECT * FROM CompanyCoupon  ";

		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				companyCouponDBDAO.setCompId(rs.getLong(1));
				companyCouponDBDAO.setCouponId(rs.getLong(2));
				list.add(companyCouponDBDAO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}
		return list;

	}

	// get all coupons in Company
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

				companyCouponDBDAO.setCompId(rs.getLong(1));
				companyCouponDBDAO.setCouponId(rs.getLong(2));
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

	// Company delete all Coupons
	@Override
	public void deletefromCompcoupByCompID(long id) throws SQLException, InterruptedException {
		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "delete from  CompanyCoupon where COMPID = ?";
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

	// ToString
	@Override
	public String toString() {
		return "CompanyCouponDBDAO [compId=" + compId + ", couponId=" + couponId + "]";
	}

	public void companyCreateCoupon(long compId, long coupId) throws SQLException, InterruptedException {

		Connection connection = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			String query = "insert into CompanyCoupon (COMPID , COUPONID) values (?, ?)";

			PreparedStatement preparedStmt = null;

			preparedStmt = connection.prepareStatement(query);

			preparedStmt.setLong(1, compId);
			preparedStmt.setLong(2, coupId);
			preparedStmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}
		System.out.println("CompanyCoupon created");
	}

	public static ArrayList<Long> getInCompanycouponCouponsId() {

		ArrayList<Long> ids = new ArrayList<>();
		ArrayList<CompanyCouponDBDAO> companyCouponDBDAOs = new ArrayList<>();

		for (CompanyCouponDBDAO companyCouponDBDAO : companyCouponDBDAOs) {
			ids.add(companyCouponDBDAO.getCouponId());
		}

		return ids;

	}

	public ArrayList<Coupon> allCouponsOfCompany() throws SQLException, InterruptedException, DateProblem, ExistEx {
		CouponDBDAO coupon = new CouponDBDAO();
		ArrayList<Coupon> allCoupons = new ArrayList<>();
		ArrayList<Long> ids = new ArrayList<>();
		for (Long long1 : ids) {
			allCoupons.add(coupon.getCoupon(long1));
		}
		return allCoupons;

	}

}

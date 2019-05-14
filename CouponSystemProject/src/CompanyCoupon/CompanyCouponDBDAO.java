package CompanyCoupon;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import Coupon.Coupon;
import Coupon.CouponDBDAO;
import DataBase.ConnectionPool;


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

	public void insert(long custId, long coupId) throws SQLException, InterruptedException {

		Connection connection = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			String query = " insert into CustomerCoupon (CUST_ID , COUPON_ID) values (?, ?)";

			PreparedStatement preparedStmt = null;

			preparedStmt = connection.prepareStatement(query);

			preparedStmt.setLong(1, custId);
			preparedStmt.setLong(2, coupId);
			preparedStmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}
	}

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

	public ArrayList<Long> getInCompanycouponCouponsId() {

		ArrayList<Long> ids = new ArrayList<>();
		ArrayList<CompanyCouponDBDAO> companyCouponDBDAOs = new ArrayList<>();

		for (CompanyCouponDBDAO companyCouponDBDAO : companyCouponDBDAOs) {
			ids.add(companyCouponDBDAO.getCoupon_id());
		}

		return ids;

	}

	public ArrayList<Coupon> allCouponsOfCompany() throws SQLException, InterruptedException {
		CouponDBDAO coupon = new CouponDBDAO();
		ArrayList<Coupon> allCoupons = new ArrayList<>();
		ArrayList<Long> ids = new ArrayList<>();
		for (Long long1 : ids) {
			allCoupons.add(coupon.getCoupon(long1));
		}
		return allCoupons;

	}

	public void deletefromCompcoup(long id) throws SQLException, InterruptedException {
		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
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
			ConnectionPool.getInstance().returnConnection(connection);

		}
		System.out.println("Deleted from CompanyCoupon");

	}

	@Override
	public String toString() {
		return "CompanyCouponDBDAO [comp_id=" + comp_id + ", coupon_id=" + coupon_id + "]";
	}

}

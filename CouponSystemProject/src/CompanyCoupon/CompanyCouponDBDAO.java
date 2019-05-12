package CompanyCoupon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Coupon.Coupon;
import DataBase.ConnectionPool;
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

	public static void removeCompanyCoupon(Coupon coupon) throws InterruptedException {

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
		}finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}
		System.out.println("Dfeleted from table CompanyCoupon");

	}

	public static CompanyCouponDBDAO getCompanyCoupon(int id) throws InterruptedException, SQLException {

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
			}finally {
				ConnectionPool.getInstance().returnConnection(connection);
			}
		return companyCouponDBDAO;
		
	}

	public void insert(long custId, long coupId) throws SQLException, InterruptedException {

		Connection connection = null;

		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());

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

	@Override
	public String toString() {
		return "CompanyCouponDBDAO [comp_id=" + comp_id + ", coupon_id=" + coupon_id + "]";
	}

}

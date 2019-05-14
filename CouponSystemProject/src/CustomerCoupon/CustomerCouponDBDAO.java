package CustomerCoupon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Coupon.Coupon;
import Coupon.CouponDBDAO;
import DataBase.ConnectionPool;
import DataBase.Database;

public class CustomerCouponDBDAO implements CustomerCouponDAO {

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

	public  void removeCustomerCoupon(Coupon coupon) throws SQLException, InterruptedException {

		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "delete from  CustomerCoupon where COUPON_ID = ?";
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
		System.out.println("deleted from table CustomerCoupon");

	}

	public ArrayList<CustomerCouponDBDAO> getCustomerCoupon(long l) throws SQLException, InterruptedException {
		Connection connection = null;
		ArrayList<CustomerCouponDBDAO> list = new ArrayList<>();

		try {
			connection = ConnectionPool.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CustomerCouponDBDAO customerCouponDBDAO = new CustomerCouponDBDAO();
		PreparedStatement preparedStatement = null;
		String sql = "SELECT * FROM CustomerCoupon WHERE CUST_ID = " + l;
		try {
			preparedStatement = connection.prepareStatement(sql);

			ResultSet rs = preparedStatement.executeQuery(sql);
			while (rs.next()) {

				customerCouponDBDAO.setCust_id(rs.getLong(1));
				customerCouponDBDAO.setCoupon_id(rs.getLong(2));
				list.add(customerCouponDBDAO);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}
		return list;
	}
}

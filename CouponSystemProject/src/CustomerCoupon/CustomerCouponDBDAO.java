package CustomerCoupon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Coupon.Coupon;
import Coupon.CouponDBDAO;
import Coupon.CouponType;
import Customer.Customer;
import DataBase.ConnectionPool;
import Exeptions.CouponException;

public class CustomerCouponDBDAO implements CustomerCouponDAO {

	// Data members
	private long custId;
	private long couponId;

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public long getCouponId() {
		return couponId;
	}

	public void setCouponId(long couponId) {
		this.couponId = couponId;
	}

	// Company Delete Coupon
	@Override
	public void removeCustomerCoupon(Coupon coupon) throws SQLException, InterruptedException {

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

	// Company create Coupon
	@Override
	public void insert(long custId, long coupId) throws SQLException, InterruptedException {

		Connection connection = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();

			String query = "insert into CustomerCoupon (CUSTID , COUPONID) values (?, ?)";

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

	public void buyCoupon(Coupon coupon, Customer custmer) throws CouponException, SQLException, InterruptedException {

		Connection con = null;
		con = ConnectionPool.getInstance().getConnection();
		String pre1 = "INSERT INTO CustomerCoupon VALUES(?,?)";
		String pre2 = "UPDATE Coupon SET amount = ? WHERE ID = ?";
		try (PreparedStatement pstmt1 = con.prepareStatement(pre1);
				PreparedStatement pstm2 = con.prepareStatement(pre2)) {
			con.setAutoCommit(false);
			pstmt1.setLong(1, custmer.getId());
			pstmt1.setLong(2, coupon.getId());
			pstmt1.executeUpdate();
			coupon.setAmount(coupon.getAmount() - 1);
			pstm2.setInt(1, coupon.getAmount());
			pstm2.setLong(2, coupon.getId());
			pstm2.executeUpdate();
			con.commit();
			con.setAutoCommit(true);
		} catch (SQLException e) {
			System.out.println("hereeeeeeeeeeee");
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getSQLState());
			try {
			con.rollback();
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
	System.out.println(e1.getSQLState());
				throw new CouponException("database error");
			}
			throw new CouponException("cannot buy coupon");
			
		}finally {
			ConnectionPool.getInstance().returnConnection(con);
		}
	}

	// Get table all Purchase Coupons By Customers ID
	@Override
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
		String sql = "SELECT * FROM CustomerCoupon WHERE CUSTID = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setLong(1, l);
			preparedStatement.execute();
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {

				customerCouponDBDAO.setCustId(rs.getLong(1));
				customerCouponDBDAO.setCouponId(rs.getLong(2));
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

	// Get All Porches Coupons by Customers
	@Override
	public ArrayList<CustomerCouponDBDAO> getAllCustomerCoupons() throws InterruptedException, SQLException {
		Connection connection = null;
		ArrayList<CustomerCouponDBDAO> list = new ArrayList<>();
		connection = ConnectionPool.getInstance().getConnection();

		CustomerCouponDBDAO customerCouponDBDAO = new CustomerCouponDBDAO();
		PreparedStatement preparedStatement = null;
		String sql = "SELECT * FROM CustomerCoupon ";
		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.execute();
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {

				customerCouponDBDAO.setCustId(rs.getLong(1));
				customerCouponDBDAO.setCouponId(rs.getLong(2));
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

	// Get all customers and they coupons
	@Override
	public ArrayList<CustomerCouponDBDAO> getAllCustumerCoupons() throws SQLException, InterruptedException {
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

				custumerCouponDBDAO.setCustId(rs.getLong(1));
				custumerCouponDBDAO.setCouponId(rs.getLong(2));
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

	// get all purchased Coupons
	public ArrayList<Coupon> getAllpurchoiseCoupons() throws InterruptedException, SQLException {
		ArrayList<CustomerCouponDBDAO> list = new ArrayList<>();
		CustomerCouponDBDAO customerCouponDBDAO = new CustomerCouponDBDAO();
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		ArrayList<Coupon> coupons = new ArrayList<Coupon>();

		list = customerCouponDBDAO.getAllCustomerCoupons();
		for (int i = 0; i < list.size(); i++) {
			coupons.add(couponDBDAO.getCoupon(list.get(i).getCouponId()));

		}
		return coupons;
	}

	// Get all purchased coupons by price
	public ArrayList<Coupon> getAllPurchaiseCouponByPrice(double price) throws SQLException, InterruptedException {
		ArrayList<Coupon> alloupons = new ArrayList<>();
		ArrayList<Coupon> byprice = new ArrayList<>();
		alloupons = getAllpurchoiseCoupons();
		for (Coupon coupon : alloupons) {
			if (coupon.getPrice() < price) {
				byprice.add(coupon);
			}
		}
		return byprice;

	}

	// Get all purchased coupons by type
	public ArrayList<Coupon> getAllPurchaiseCouponByType(CouponType type) throws SQLException, InterruptedException {
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

	// Delete from custCoup by Customer Id
	public void deletefromCustcoupByCustID(long id) throws SQLException, InterruptedException {
		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = String.format("delete from  CustomerCoupon where custId = ?");
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

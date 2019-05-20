package Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import Coupon.Coupon;
import Coupon.CouponDBDAO;
import CustomerCoupon.CustomerCouponDBDAO;
import DataBase.ConnectionPool;


public class CustomerDBDAO implements CustomerDAO {
	// create Customer(insert to Customer)
	@Override
	public void createCustomer(Customer customer) throws SQLException, InterruptedException {

		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		String query = " insert into customer (id ,CUST_NAME ,password )" + " values (?, ?, ?)";

		PreparedStatement preparedStmt;
		try {
			preparedStmt = connection.prepareStatement(query);

			preparedStmt.setLong(1, customer.getId());
			preparedStmt.setString(2, customer.getCustName());
			preparedStmt.setString(3, customer.getPassword());

			preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			ConnectionPool.getInstance().returnConnection(connection);

		}
		System.out.println("customer Created");

	}

	// delete Customer (delete from Customer)
	@Override
	public void removeCustomer(Customer customer) throws SQLException, InterruptedException {

		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql = "delete from  customer where id = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setLong(1, customer.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			ConnectionPool.getInstance().returnConnection(connection);
		}
		System.out.println("deleted from customer");

	}

	// update Customer(update Customer)
	@Override
	public void updateCustomer(Customer customer) throws SQLException, InterruptedException {

		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "update customer set password = ? , set CUST_NAME = ?  where id = ? ";
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, customer.getPassword());
			preparedStatement.setString(2, customer.getCustName());
			preparedStatement.setLong(3, customer.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			ConnectionPool.getInstance().returnConnection(connection);

		}
		System.out.println("customer Updatet");

	}

	// get Customer By Id
	@Override
	public Customer getCustomer(long id) throws SQLException, InterruptedException {
		Customer customer = new Customer();
		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "SELECT * FROM customer WHERE ID= ?";
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setLong(1, id);
			preparedStatement.execute();
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				customer.setId(rs.getLong(1));
				customer.setCustName(rs.getString(2));
				customer.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			ConnectionPool.getInstance().returnConnection(connection);

		}

		return customer;
	}

	// get All Customers
	@Override
	public ArrayList<Customer> getAllCustomer() throws SQLException, InterruptedException {

		ArrayList<Customer> customers = new ArrayList<>();

		Connection connection = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Customer customer = new Customer();
		String sql = "SELECT * FROM customer ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet rs;
			rs = preparedStatement.executeQuery(sql);

			while (rs.next()) {

				customer.setId(rs.getLong(1));
				customer.setCustName(rs.getString(2));
				customer.setPassword(rs.getString(3));
				customers.add(customer);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {

			ConnectionPool.getInstance().returnConnection(connection);

		}

		return customers;
	}

	// get All Coupons by Customer
	@Override
	public Collection<Coupon> getCoupons(Customer customer) throws SQLException, InterruptedException {

		CustomerCouponDBDAO customerCouponDBDAO = new CustomerCouponDBDAO();
		CouponDBDAO couponDBDAO = new CouponDBDAO();

		ArrayList<CustomerCouponDBDAO> list = new ArrayList<>();
		ArrayList<Coupon> coupons = new ArrayList<>();

		list = customerCouponDBDAO.getAllCustomerCoupons();
		for (CustomerCouponDBDAO custCouponDBDAO : list) {
			if (customer.getId() == custCouponDBDAO.getCust_id()) {

				coupons.add(couponDBDAO.getCoupon(customer.getId()));
			}
		}
		return coupons;

	}

	// Login to Customer
	@Override
	public boolean login(String custName, String password) throws InterruptedException {

		Customer customer = new Customer();
		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		String sql = "SELECT * FROM customer WHERE CUST_NAME = ? and  password = ?";
		PreparedStatement preparedStatement = null;

		try {

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, custName);
			preparedStatement.setString(2, password);
			preparedStatement.execute();
			ResultSet rs = preparedStatement.executeQuery(sql);

			while (rs.next()) {

				customer.setId(rs.getLong(1));
				customer.setCustName(rs.getString(2));
				customer.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			ConnectionPool.getInstance().returnConnection(connection);

		}

		if (customer.getId() == 0) {
			return false;
		} else
			return true;

	}
}

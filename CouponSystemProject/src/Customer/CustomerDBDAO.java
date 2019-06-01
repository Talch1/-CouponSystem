package Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import Coupon.Coupon;
import Coupon.CouponDBDAO;
import CustomerCoupon.CustomerCouponDBDAO;
import DataBase.ConnectionPool;
import Exeptions.DateProblem;
import Exeptions.ExistEx;

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

		String query = " insert into customer (id ,CUSTNAME ,password )" + " values (?, ?, ?)";

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
	public void removeCustomer(Customer customer) throws SQLException, InterruptedException, ExistEx {
		CustomerDBDAO customerDBDAO = new CustomerDBDAO();
		ArrayList<Customer> customers = customerDBDAO.getAllCustomer();
		boolean chek = false;
		for (Customer customer2 : customers) {
			if (customer2.getId() == customer.getId()) {
              chek = true;
			}
		}
		if (chek== false) {
			throw new ExistEx("Customer doesn't exist");
		}
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
	public void updateCustomer(Customer customer) throws SQLException, InterruptedException, ExistEx {
		CustomerDBDAO customerDBDAO = new CustomerDBDAO();
		ArrayList<Customer> customers = customerDBDAO.getAllCustomer();
		boolean chek = false;
		for (Customer customer2 : customers) {
			if (customer2.getId() == customer.getId()) {
              chek = true;
			}
		}
		if (chek== false) {
			throw new ExistEx("Customer doesn't exist");
		}
		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "update customer set password = ?  where id = ? ";
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, customer.getPassword());
			preparedStatement.setLong(2, customer.getId());
			preparedStatement.execute();
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

		String sql = "SELECT * FROM customer ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet rs;
			rs = preparedStatement.executeQuery(sql);

			while (rs.next()) {
				Customer customer = new Customer();
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
	public ArrayList<Coupon> getCoupons(Customer customer) throws SQLException, InterruptedException, DateProblem {
		CustomerCouponDBDAO customerCouponDBDAO = new CustomerCouponDBDAO();
		ArrayList<CustomerCouponDBDAO> list = customerCouponDBDAO.getCustomerCouponByCustId(customer.getId());

		CouponDBDAO couponDBDAO = new CouponDBDAO();
		ArrayList<Coupon> coupons = new ArrayList<Coupon>();
		for (int i = 0; i < list.size(); i++) {
			coupons.add(couponDBDAO.getCoupon(list.get(i).getCouponId()));
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
		String sql = "SELECT * FROM customer WHERE CUSTNAME = ? and  password = ?";
		PreparedStatement preparedStatement = null;

		try {

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, custName);
			preparedStatement.setString(2, password);
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

		if (customer.getId() == 0) {
			return false;
		} else
			return true;

	}
}

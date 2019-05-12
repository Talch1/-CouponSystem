package Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import Company.Company;
import Coupon.Coupon;
import DataBase.Database;

public class CustomerDBDAO implements CustomerDAO {
	public static void createCustomer(Customer customer) throws SQLException {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
			
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
			connection.close();
		}
		System.out.println("customer Created");

	}

	public static void removeCustomer(Customer customer) throws SQLException {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
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
		}
		System.out.println("deleted from customer");

	}

	public static void updateCompanyName(Customer customer) throws SQLException {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
		}
		String sql = "update customer set password = ? where id = ? ";
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(sql);

			
			preparedStatement.setString(1, customer.getPassword());
			preparedStatement.setLong(2, customer.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("customer Updatet");

	}

	public Customer getCustomer(long id) throws SQLException {
		Customer customer = new Customer();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		String sql = "SELECT * FROM customer WHERE ID=" + id;
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(sql);

			ResultSet rs = preparedStatement.executeQuery(sql);
	
			while (rs.next()) {

				customer.setId(rs.getLong(1));
				customer.setCustName(rs.getString(2));
				customer.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.close();
		}

		return customer;
	}

	@Override
	public Collection<Customer> getAllCustomer() throws SQLException {
	

			ArrayList<Customer> customers = new ArrayList<>();

			Connection connection = null;

			try {
				connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
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
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				connection.close();
			}

		return customers;
	}

	@Override
	public Collection<Coupon> getCoupons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean login(String custName, String pasword) {

		Customer customer = new Customer();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		String sql = "SELECT * FROM customer WHERE CUST_NAME = " + "'"+custName + "'"  + " and  password = " + "'" +pasword+ "'";
		PreparedStatement preparedStatement = null;

		try {

			preparedStatement = connection.prepareStatement(sql);

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

			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (customer.getId() == 0) {
			return false;
		} else
			return true;

	}
}

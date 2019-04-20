package Custumer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import Company.Company;
import Coupon.Coupon;
import DataBase.Database;

public class CustumerDBDAO implements CustumerDAO {
	public static void createCustumer(Custumer custumer) throws SQLException {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		String query = " insert into customer (id ,CUST_NAME ,password )" + " values (?, ?, ?)";

		// create the mysql insert preparedstatement
		PreparedStatement preparedStmt;
		try {
			preparedStmt = connection.prepareStatement(query);

			preparedStmt.setLong(1, custumer.getId());
			preparedStmt.setString(2, custumer.getCustName());
			preparedStmt.setString(3, custumer.getPassword());

			// execute the preparedstatement
			preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
		}
		System.out.println("Custumer Created");

	}

	public static void removeCustumer(Custumer custumer) throws SQLException {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
		}
		String sql = "delete from  Custumer where id = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setLong(1, custumer.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("deleted from Custumer");

	}

	public static void updateCompanyName(Custumer custumer) throws SQLException {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
		}
		String sql = "update Custumer set CUST_NAME = ?, password = ? where id = ? ";
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, custumer.getCustName());
			preparedStatement.setString(2, custumer.getPassword());
			preparedStatement.setLong(3, custumer.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Custumer Updatet");

	}

	@Override
	public Custumer getCustumer(long id) throws SQLException {
		Custumer custumer = new Custumer();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		String sql = "SELECT * FROM coupon WHERE ID=" + id;
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(sql);

			ResultSet rs = preparedStatement.executeQuery(sql);
	
			while (rs.next()) {

				custumer.setId(rs.getLong(1));
				custumer.setCustName(rs.getString(2));
				custumer.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.close();
		}

		return custumer;
	}

	@Override
	public Collection<Company> getAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Coupon> getCoupons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean login(String custName, String pasword) {

		Custumer custumer = new Custumer();
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
			rs.next();
			while (rs.next()) {

				custumer.setId(rs.getLong(1));
				custumer.setCustName(rs.getString(2));
				custumer.setPassword(rs.getString(3));
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

		if (custumer.getId() == 0) {
			return false;
		} else
			return true;

	}
}

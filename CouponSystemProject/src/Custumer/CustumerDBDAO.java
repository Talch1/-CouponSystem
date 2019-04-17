package Custumer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import Coupon.Coupon;
import DataBase.Database;

public class CustumerDBDAO implements CustumerDAO {
	public static void createCustumer(Custumer custumer) throws SQLException  {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
					Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.close();
		}

		String query = " insert into custumer (id ,CUST_NAME ,password )" + " values (?, ?, ?)";

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
		}
		System.out.println("Custumer Created");

		

	}

	public static void removeCustumer(Custumer custumer) throws SQLException  {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
					Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.close();
		}
		String sql = "delete from  Custumer where id = ?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setLong(1,custumer.getId() );
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
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
					Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.close();
		}
		String sql = "update Custumer set CUST_NAME = ?, password = ? where id = ? ";
		PreparedStatement preparedStatement;
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
	public Custumer getCustumer(long id) throws SQLException  {
		Custumer custumer = new Custumer();
		Connection connection = null;
		try {
			 connection = DriverManager.getConnection(Database.getSql(),Database.getUser(),Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.close();
		}
		String sql = "SELECT * FROM coupon WHERE ID=" + id;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		preparedStatement = connection.prepareStatement(sql);
		
		
		ResultSet rs = preparedStatement.executeQuery(sql);
		 try {
			long custumerId = resultSet.getLong(1);
			String custName = resultSet.getString(2);
			String password = resultSet.getString(3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return custumer;
	}

	@Override
	public Collection<Coupon> getAllCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Coupon> getCoupon() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean login() {
		// TODO Auto-generated method stub
		return false;
	}

}

package Custumer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

import Coupon.Coupon;
import DataBase.Database;

public class CustumerDBDAO implements CustumerDAO {
	public static void createCustumer(Custumer custumer) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());

		String query = " insert into custumer (id ,CUST_NAME ,password )" + " values (?, ?, ?)";

		// create the mysql insert preparedstatement
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		preparedStmt.setLong(1, custumer.getId());
		preparedStmt.setString(2, custumer.getCustName());
		preparedStmt.setString(3, custumer.getPassword());

		// execute the preparedstatement
		preparedStmt.execute();
		System.out.println("Custumer Created");

		connection.close();

	}

	public static void removeCustumer(Custumer custumer) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql = "delete from  Custumer where id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setLong(1,custumer.getId() );
		preparedStatement.executeUpdate();
		System.out.println("deleted from Custumer");

	}

	public static void updateCompanyName(Custumer custumer) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql = "update Custumer set CUST_NAME = ?, password = ? where id = ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, custumer.getCustName());
		preparedStatement.setString(2, custumer.getPassword());
		preparedStatement.setLong(3, custumer.getId());
		preparedStatement.executeUpdate();

		System.out.println("Custumer Updatet");

	}

	@Override
	public Custumer getCustumer(long id) {
		// TODO Auto-generated method stub
		return null;
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

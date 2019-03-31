package Custumer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

import Coupon.Coupon;
import DataBase.Database;

public class CustumerDBDAO implements CustumerDAO {

	@Override
	public void createCustumer() throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());

		String query = " insert into users (id ,compName ,password , eamil)" + " values (?, ?, ?)";

		// create the mysql insert preparedstatement
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		preparedStmt.setLong(1, 1);
		preparedStmt.setString(2, "Vasya");
		preparedStmt.setString(3, "passsss");

		// execute the preparedstatement
		preparedStmt.execute();

		connection.close();

	}

	@Override
	public void removeCustumer() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCustumer() {
		// TODO Auto-generated method stub

	}

	@Override
	public Custumer getCustumer() {
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

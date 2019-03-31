package Company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

import Coupon.Coupon;
import DataBase.Database;


public class CompanyDBDAO implements CompanyDAO {
	// create table company
	@Override
	public void createCompany() throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());

		String query = " insert into users (id ,compName ,password , eamil)" + " values (?, ?, ?, ?)";

		// create the mysql insert preparedstatement
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		preparedStmt.setLong(1, 1);
		preparedStmt.setString(2, "Roshen");
		preparedStmt.setString(3, "pass");
		preparedStmt.setString(4, "Roshen@gmail.com");

		// execute the preparedstatement
		preparedStmt.execute();

		connection.close();

	}

	@Override
	public void removeCompany() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCompany() {
		// TODO Auto-generated method stub

	}

	@Override
	public Company getCompany() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Company> getAllCompany() {
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

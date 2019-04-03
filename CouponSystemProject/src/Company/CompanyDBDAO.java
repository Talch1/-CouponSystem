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
	public static void createCompany() throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());

		String query = " insert into company (id ,COMP_NAME ,password , email)" + " values (?, ?, ?, ?)";

		// create the mysql insert preparedstatement
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		preparedStmt.setLong(1, Company.getId());
		preparedStmt.setString(2, Company.getCompName());
		preparedStmt.setString(3, Company.getPassword());
		preparedStmt.setString(4, Company.getEamil());

		// execute the preparedstatement
		preparedStmt.execute();

		System.out.printf("added to Company");
		connection.close();

	}

	public void removeCompany() throws SQLException {
		
			Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
					Database.getPasword());
			String sql = String.format("delete from  Company where id = %d",Company.getId());
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			System.out.println("deleted from Company");


	}

	public void updateCompany() {
		// TODO Auto-generated method stub

	}

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

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
	public static void createCompany( Company company) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());

		String query = " insert into company (id ,COMP_NAME ,password , email)" + " values (?, ?, ?, ?)";

		// create the mysql insert preparedstatement
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		preparedStmt.setLong(1, company.getId());
		preparedStmt.setString(2, company.getCompName());
		preparedStmt.setString(3, company.getPassword());
		preparedStmt.setString(4, company.getEamil());

		// execute the preparedstatement
		preparedStmt.execute();

		System.out.printf("Added to Company");
		connection.close();

	}
	// remove table company
	public static void removeCompany(Company company) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql = String.format("delete from  Company where id = ?");
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setLong(1,company.getId());
		preparedStatement.executeUpdate();
		System.out.println("Deleted from Company");

	}

	public static void updateCompany(Company company) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql = String.format("update company set PASSWORD = %s , EMAIL =' %s', COMP_NAME = '%s' where ID =  %d",company.getPassword(), company.getEamil() ,company.getCompName() ,company.getId());
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.execute(sql);
		System.out.println(" Company Updatet");
		connection.close();
	}

	
	
	public Company getCompany(long id) {
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

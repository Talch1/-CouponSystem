package Company;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

import Coupon.Coupon;
import DataBase.Database;

public class CompanyDBDAO implements CompanyDAO {
	// create table company
	public static void createCompany(long id, String name, String passs, String email) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());

		String query = " insert into company (id ,COMP_NAME ,password , email)" + " values (?, ?, ?, ?)";

		// create the mysql insert preparedstatement
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		preparedStmt.setLong(1, id);
		preparedStmt.setString(2, name);
		preparedStmt.setString(3, passs);
		preparedStmt.setString(4, email);

		// execute the preparedstatement
		preparedStmt.execute();

		System.out.printf("added to Company");
		connection.close();

	}

	public static void removeCompany(long id) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql = String.format("delete from  Company where id = ?");
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setLong(1, id);
		preparedStatement.executeUpdate();
		System.out.println("deleted from Company");

	}

	public static void updateCompanyName(String name,long id) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql = "update company set COMP_NAME =  ?  where id =  ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setLong(2, id);
		preparedStatement.executeUpdate();
		System.out.println("Company name Updated");
	}
	public static void updateCompanyPass(String pass, long id) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql = "update company set PASSWORD = ? where id = ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, pass);
		preparedStatement.setLong(2, id);
		preparedStatement.executeUpdate();
		System.out.println("Password Company Updatet");
		connection.close();
	}

	public static void updateCompanyEmail(String email, long id) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql = "update company set EMAIL = ? where id = ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, email);
		preparedStatement.setLong(2, id);
		preparedStatement.executeUpdate();
		System.out.println("Email Company Updatet");
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

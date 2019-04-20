
package Company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.sql.Statement;

import javax.swing.SpinnerListModel;

import Coupon.Coupon;
import DataBase.Database;

public class CompanyDBDAO implements CompanyDAO {
	// create table company
	public static void createCompany(Company company) throws SQLException {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		String query = " insert into company (id ,COMP_NAME ,password , email)" + " values (?, ?, ?, ?)";

		// create the mysql insert preparedstatement
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = connection.prepareStatement(query);

			preparedStmt.setLong(1, company.getId());

			preparedStmt.setString(2, company.getCompName());
			preparedStmt.setString(3, company.getPassword());
			preparedStmt.setString(4, company.getEmail());

			// execute the preparedstatement
			preparedStmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.close();
		}
		System.out.printf("Added to Company");

	}

	// remove table company
	public static void removeCompany(Company company) throws SQLException {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		String sql = String.format("delete from  Company where id = ?");
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setLong(1, company.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.close();
		}
		System.out.println("Deleted from Company");

	}

	public static void updateCompany(Company company) throws SQLException {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		String sql = "update company set PASSWORD = ? , EMAIL = ?, COMP_NAME = ?  where ID =  ?";

		PreparedStatement preparedStatement = null;
		preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setString(1, company.getCompName());
		preparedStatement.setString(2, company.getPassword());
		preparedStatement.setString(3, company.getEmail());
		preparedStatement.setLong(4, company.getId());

		try {
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			connection.close();
		}
		System.out.println("Company Updatet");

	}

	public Company getCompany(long id) throws SQLException {
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Company company = new Company();
		String sql = "SELECT * FROM  Company WHERE ID=" + id ;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet;
			resultSet = preparedStatement.executeQuery(sql);
			
			while (resultSet.next()) {
				company.setId(resultSet.getLong(1));
				company.setPassword(resultSet.getString(2));
				company.setEmail(resultSet.getString(3));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			connection.close();
		}
		return company;

	}

	@Override
	public Collection<Company> getAllCompany() throws SQLException {

		ArrayList<Company> companies = new ArrayList<>();

		Connection connection = null;

		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Company company = new Company();
		String sql = "SELECT * FROM Company ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet;
			resultSet = preparedStatement.executeQuery(sql);
			resultSet.next();
			while (resultSet.next()) {
				company.setId(resultSet.getLong(1));
				company.setPassword(resultSet.getString(2));
				company.setEmail(resultSet.getString(3));
				companies.add(company);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			connection.close();
		}

		return companies;
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

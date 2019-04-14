package Company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.sql.Statement;


import javax.swing.SpinnerListModel;


import Coupon.Coupon;
import DataBase.Database;

public class CompanyDBDAO implements CompanyDAO {
	// create table company
	public static void createCompany( Company company)  {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
					Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String query = " insert into company (id ,COMP_NAME ,password , email)" + " values (?, ?, ?, ?)";

		// create the mysql insert preparedstatement
		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = connection.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			preparedStmt.setLong(1, company.getId());
		
		preparedStmt.setString(2, company.getCompName());
		preparedStmt.setString(3, company.getPassword());
		preparedStmt.setString(4, company.getEamil());

		// execute the preparedstatement
		preparedStmt.execute();

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.printf("Added to Company");
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// remove table company
	public static void removeCompany(Company company)  {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
					Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
		String sql = String.format("delete from  Company where id = ?");
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.setLong(1,company.getId());
		preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Deleted from Company");

	}

	public static void updateCompany(Company company){

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
					Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = String.format("update company set PASSWORD = %s , EMAIL =' %s', COMP_NAME = '%s' where ID =  %d",company.getPassword(), company.getEamil() ,company.getCompName() ,company.getId());
	PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
		
		preparedStatement.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" Company Updatet");
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	public Company getCompany(long id) {


		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
					Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			Company company = new Company();

			try {
			Statement	statement = connection.createStatement();
	
			String sql = "SELECT * FROM Company WHERE ID=" + id;
			ResultSet resultSet;
			resultSet = statement.executeQuery(sql);
			resultSet.next();
			
			company.setId(resultSet.getLong(1));
			company.setPassword(resultSet.getString(2));
			company.setEamil(resultSet.getString(3));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return company;
		
		
		
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

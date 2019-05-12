
package Company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import Coupon.Coupon;
import Coupon.CouponDBDAO;
import DataBase.ConnectionPool;
import DataBase.Database;
import Utils.CompCoup;

public class CompanyDBDAO implements CompanyDAO {
	CouponDBDAO couponDBDAO = new CouponDBDAO();
	CompCoup compCoup = new CompCoup();

	// create table company
	public void createCompany(Company company) throws SQLException, InterruptedException {

		Connection connection = null;

		connection = ConnectionPool.getInstance().getConnection();
		

		String query = " insert into company (id ,COMP_NAME ,password , email)" + " values (?, ?, ?, ?)";

		PreparedStatement preparedStmt = null;
		try {
			preparedStmt = connection.prepareStatement(query);

			preparedStmt.setLong(1, company.getId());

			preparedStmt.setString(2, company.getCompName());
			preparedStmt.setString(3, company.getPassword());
			preparedStmt.setString(4, company.getEmail());

			preparedStmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}
		System.out.printf("Inserted to Company");

	}

	// remove table company
	public void removeCompany(Company company) throws SQLException, InterruptedException {

		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
		
		String sql = String.format("delete from  Company where id = ?");
		PreparedStatement preparedStatement = null;
		
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setLong(1, company.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}
		System.out.println("Deleted from Company");

	}

	public void updateCompany(Company company) throws SQLException, InterruptedException {

		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();

			String sql = "update company set PASSWORD = ? , EMAIL = ? where ID =  ?";

			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, company.getPassword());
			preparedStatement.setString(2, company.getEmail());
			preparedStatement.setLong(3, company.getId());

			preparedStatement = connection.prepareStatement(sql);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}
		System.out.println("Company Updatet");

	}

	public Company getCompany(long id) throws SQLException, InterruptedException {
		Connection connection = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Company company = new Company();
		String sql = "SELECT * FROM  Company WHERE ID= ?";
		try {
			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setLong(1, id);
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
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}
		return company;

	}

	@Override
	public Collection<Company> getAllCompany() throws SQLException, InterruptedException {

		ArrayList<Company> companies = new ArrayList<>();

		Connection connection = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();
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

			while (resultSet.next()) {
				company.setId(resultSet.getLong(1));
				company.setCompName(resultSet.getString(2));
				company.setPassword(resultSet.getString(3));
				company.setEmail(resultSet.getString(4));
				companies.add(company);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}

		return companies;
	}

	@Override
	public Collection<Coupon> getCoupons() throws SQLException, InterruptedException {
		return compCoup.allCouponsOfCompany();
	}

	@Override
	public boolean login(String compname, String pass) throws InterruptedException {
		Company company = new Company();
		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
		String sql = "SELECT * FROM company WHERE COMP_NAME = ? and  password = ?";

		PreparedStatement preparedStatement = null;

		try {

			preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, compname);
            preparedStatement.setString(2, pass);
			ResultSet rs = preparedStatement.executeQuery(sql);

			while (rs.next()) {

				company.setId(rs.getLong(1));
				company.setCompName(rs.getString(2));
				company.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			ConnectionPool.getInstance().returnConnection(connection);
		}
		if (company.getId() == 0) {
			return false;
		} else
			return true;
	}

}


package Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import CompanyCoupon.CompanyCouponDBDAO;
import Coupon.Coupon;
import Coupon.CouponDBDAO;
import Customer.Customer;
import Customer.CustomerDBDAO;
import DataBase.ConnectionPool;
import Exeptions.DateProblem;
import Exeptions.ExistEx;

public class CompanyDBDAO implements CompanyDAO {

	// createCompany(insert to company)
	@Override
	public void createCompany(Company company) throws SQLException, InterruptedException{
		
		Connection connection = null;

		connection = ConnectionPool.getInstance().getConnection();

		String query = " insert into company (id ,COMPNAME ,password , email)" + " values (?, ?, ?, ?)";

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

	// removeCompany(delete from company)
	@Override
	public void removeCompany(Company company) throws SQLException, InterruptedException, ExistEx {
		CompanyDBDAO companyDBDAO = new CompanyDBDAO();
		ArrayList<Company> companies = companyDBDAO.getAllCompany();
		boolean chek = false;
		for (Company comp : companies) {
			if (company.getId() == comp.getId()) {
              chek = true;
			}
		}
		if (chek== false) {
			throw new ExistEx("Company doesn't exist");
		}
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

	// updateCompany(update company)
	@Override
	public void updateCompany(Company company) throws SQLException, InterruptedException, ExistEx {
		CompanyDBDAO companyDBDAO = new CompanyDBDAO();
		ArrayList<Company> companies = companyDBDAO.getAllCompany();
		boolean chek = false;
		for (Company comp : companies) {
			if (company.getId() == comp.getId()) {
              chek = true;
			}
		}
		if (chek== false) {
			throw new ExistEx("Company doesn't exist");
		}
		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();

			String sql = "update company set PASSWORD = ? , EMAIL = ? where ID =  ?";

			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, company.getPassword());
			preparedStatement.setString(2, company.getEmail());
			preparedStatement.setLong(3, company.getId());

			preparedStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}
		System.out.println("Company Updatet");

	}

	// getCompany when id is
	@Override
	public Company getCompany(long id) throws SQLException, InterruptedException {
		Connection connection = null;

		connection = ConnectionPool.getInstance().getConnection();

		Company company = new Company();
		String sql = "SELECT * FROM  Company WHERE ID= ?";
		try {
			PreparedStatement preparedStatement = null;
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setLong(1, id);
			preparedStatement.execute();
			ResultSet resultSet;
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				company.setId(resultSet.getLong(1));
				company.setCompName(resultSet.getString(2));
				company.setPassword(resultSet.getString(3));
				company.setEmail(resultSet.getString(4));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			ConnectionPool.getInstance().returnConnection(connection);
		}
		return company;

	}

	// get all companys to Arraylist
	@Override
	public ArrayList<Company> getAllCompany() throws SQLException, InterruptedException {

		ArrayList<Company> companies = new ArrayList<>();

		Connection connection = null;

		try {
			connection = ConnectionPool.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql = "SELECT * FROM Company ";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			ResultSet resultSet;
			resultSet = preparedStatement.executeQuery(sql);

			while (resultSet.next()) {
				Company company = new Company();
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

	// get all coupons of this company
	@Override
	public ArrayList<Coupon> getCoupons(Company company) throws SQLException, InterruptedException, DateProblem {
		CompanyCouponDBDAO compCoup = new CompanyCouponDBDAO();
		CouponDBDAO couponDBDAO = new CouponDBDAO();

		ArrayList<CompanyCouponDBDAO> list = new ArrayList<>();
		ArrayList<Coupon> coupons = new ArrayList<>();

		list = compCoup.getAllCompanyCoupon();
		for (CompanyCouponDBDAO companyCouponDBDAO : list) {
			if (company.getId() == companyCouponDBDAO.getCompId()) {

				coupons.add(couponDBDAO.getCoupon(company.getId()));
			}
		}
		return coupons;

	}

	// login to Company
	@Override
	public boolean login(String compname, String pass) throws InterruptedException {
		Company company = new Company();
		Connection connection = null;
		try {
			connection = ConnectionPool.getInstance().getConnection();
		} catch (SQLException e) {

			e.printStackTrace();

		}

		String sql = "SELECT * FROM company WHERE COMPNAME = ? and  password = ?";

		PreparedStatement preparedStatement = null;

		try {

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, compname);
			preparedStatement.setString(2, pass);
			ResultSet rs = preparedStatement.executeQuery();

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

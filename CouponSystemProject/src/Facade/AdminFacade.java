package Facade;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import Company.Company;
import Company.CompanyDBDAO;
import Coupon.Coupon;
import Coupon.CouponDBDAO;
import Coupon.CouponType;
import Customer.Customer;
import Customer.CustomerDBDAO;
import DataBase.ClientType;
import Exeptions.*;

public class AdminFacade implements CouponClientFasade {
	 static CompanyDBDAO companyDBDAO = new CompanyDBDAO();
	 static CustomerDBDAO customerDBDAO = new CustomerDBDAO();

	public static void createCompany(Company company) throws SQLException, InterruptedException {
		
		///!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				companyDBDAO.createCompany(company);
			
		
	}

	public static void removeCompany(Company company) throws SQLException, InterruptedException {
		try {
			companyDBDAO.removeCompany(company);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Utils.CompCoup.deletefromCompcoup(company.getId());

	}

	public static void updateCompany(Company company) throws InterruptedException {
		try {
			companyDBDAO.updateCompany(company);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Company getCompany(int id) throws SQLException, InterruptedException {

		return companyDBDAO.getCompany(id);

	}

	public static Collection<Company> getAllCompanyes() throws SQLException, InterruptedException {

		return companyDBDAO.getAllCompany();

	}

	public static void createCustomer(Customer cust) throws SQLException, InterruptedException {
		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
				customerDBDAO.createCustomer(cust);
			
		}


	public static void removeCustomer(Customer cust) throws SQLException, InterruptedException {

		customerDBDAO.removeCustomer(cust);
		Utils.CouponPurchaise.deletefromCustcoup(cust.getId());

	}

	public static void updateCustomer(Customer cust) throws SQLException, InterruptedException {
		customerDBDAO.updateCompanyName(cust);
	}

	public static Customer getCustomer(int id) {

		return getCustomer(id);

	}

	public static Collection<Company> getAllCustomers() {
		return getAllCustomers();

	}

	public CouponClientFasade login(String name, String password, ClientType c) {
		if ((name.equals("admin")) && (password.equals("1234"))) {
			AdminFacade adminFacade = new AdminFacade();
			return adminFacade;
		}
		return null;
	}

}
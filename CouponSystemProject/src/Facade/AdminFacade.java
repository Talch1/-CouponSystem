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
import Utils.CompCoup;
import Utils.CouponPurchaise;

public class AdminFacade implements CouponClientFasade {
	


	public static void createCompany(Company company) throws SQLException, InterruptedException {
		CompanyDBDAO companyDBDAO = new CompanyDBDAO();
		/// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		companyDBDAO.createCompany(company);

	}

	public static void removeCompany(Company company) throws SQLException, InterruptedException {
		CompanyDBDAO companyDBDAO = new CompanyDBDAO();
		CompCoup compCoup = new CompCoup();
		try {
			companyDBDAO.removeCompany(company);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		compCoup.deletefromCompcoup(company.getId());

	}

	public static void updateCompany(Company company) throws InterruptedException {
		CompanyDBDAO companyDBDAO = new CompanyDBDAO();
		try {
			companyDBDAO.updateCompany(company);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Company getCompany(int id) throws SQLException, InterruptedException {
		CompanyDBDAO companyDBDAO = new CompanyDBDAO();
		return companyDBDAO.getCompany(id);

	}

	public static Collection<Company> getAllCompanyes() throws SQLException, InterruptedException {
		CompanyDBDAO companyDBDAO = new CompanyDBDAO();
		return companyDBDAO.getAllCompany();

	}

	public static void createCustomer(Customer cust) throws SQLException, InterruptedException {
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		CustomerDBDAO customerDBDAO = new CustomerDBDAO();
		CustomerDBDAO.createCustomer(cust);

	}

	public static void removeCustomer(Customer cust) throws SQLException, InterruptedException {
		CouponPurchaise couponPurchaise = new CouponPurchaise();
		CustomerDBDAO customerDBDAO = new CustomerDBDAO();
		customerDBDAO.removeCustomer(cust);
		couponPurchaise.deletefromCustcoup(cust.getId());

	}

	public static void updateCustomer(Customer cust) throws SQLException, InterruptedException {
		CustomerDBDAO customerDBDAO = new CustomerDBDAO();
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
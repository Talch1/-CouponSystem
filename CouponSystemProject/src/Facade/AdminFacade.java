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

	public static void createCompany(Company company) throws SQLException {
		for (Company comp : companyDBDAO.getAllCompany()) {
			if (comp.getCompName() == company.getCompName()) {
				return;
			} else {
				companyDBDAO.createCompany(company);
			}
		}
	}

	public static void removeCompany(Company company) throws SQLException {
		try {
			companyDBDAO.removeCompany(company);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Utils.CompCoup.deletefromCompcoup(company.getId());

	}

	public static void updateCompany(Company company) {
		try {
			companyDBDAO.updateCompany(company);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Company getCompany(int id) throws SQLException {

		return companyDBDAO.getCompany(id);

	}

	public static Collection<Company> getAllCompanyes() throws SQLException {

		return companyDBDAO.getAllCompany();

	}

	public static void createCustomer(Customer cust) throws SQLException {
		for (Customer customer : customerDBDAO.getAllCustomer()) {
			if (customer.getCustName() == cust.getCustName()) {
				return;
			} else {
				customerDBDAO.createCustomer(cust);
			}
		}
	}

	public static void removeCustomer(Customer cust) throws SQLException {

		customerDBDAO.removeCustomer(cust);
		Utils.CouponPurchaise.deletefromCustcoup(cust.getId());

	}

	public static void updateCustomer(Customer cust) throws SQLException {
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
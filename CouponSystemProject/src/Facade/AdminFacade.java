package Facade;
import DataBase.ClientType;
import java.sql.SQLException;
import java.util.ArrayList;
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
	
	ClientType clientType = ClientType.Admin;

	public AdminFacade() {
		
	}


	public AdminFacade(ClientType clientType) {
		super();
		this.clientType = clientType;
	}

	
	public void createCompany(Company company) throws SQLException, InterruptedException {
		CompanyDBDAO companyDBDAO = new CompanyDBDAO();
		/// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		companyDBDAO.createCompany(company);

	}

	public void removeCompany(Company company) throws SQLException, InterruptedException {
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

	public void updateCompany(Company company) throws InterruptedException {
		CompanyDBDAO companyDBDAO = new CompanyDBDAO();
		try {
			companyDBDAO.updateCompany(company);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Company getCompany(int id) throws SQLException, InterruptedException {
		CompanyDBDAO companyDBDAO = new CompanyDBDAO();
		return companyDBDAO.getCompany(id);

	}

	public Collection<Company> getAllCompanyes() throws SQLException, InterruptedException {
		CompanyDBDAO companyDBDAO = new CompanyDBDAO();
		return companyDBDAO.getAllCompany();

	}

	public void createCustomer(Customer cust) throws SQLException, InterruptedException {
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		CustomerDBDAO customerDBDAO = new CustomerDBDAO();
		customerDBDAO.createCustomer(cust);

	}

	public void removeCustomer(Customer cust) throws SQLException, InterruptedException {
		CouponPurchaise couponPurchaise = new CouponPurchaise();
		CustomerDBDAO customerDBDAO = new CustomerDBDAO();
		customerDBDAO.removeCustomer(cust);
		couponPurchaise.deletefromCustcoup(cust.getId());

	}

	public void updateCustomer(Customer cust) throws SQLException, InterruptedException {
		CustomerDBDAO customerDBDAO = new CustomerDBDAO();
		customerDBDAO.updateCustomer(cust);
	}

	public Customer getCustomer(int id) throws SQLException, InterruptedException {
		CustomerDBDAO customerDBDAO = new CustomerDBDAO();
		return customerDBDAO.getCustomer(id);

	}

	public Collection<Customer> getAllCustomers() throws SQLException, InterruptedException {
		CustomerDBDAO customerDBDAO = new CustomerDBDAO();
		ArrayList<Customer> list = customerDBDAO.getAllCustomer();
		return list;

	}

	public CouponClientFasade login(String name, String password, ClientType c) {
		if ((name.equals("admin")) && (password.equals("1234"))) {
			AdminFacade adminFacade = new AdminFacade();
			return adminFacade;
		}
		return null;
	}

}
package Facade;

import DataBase.ClientType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import Company.Company;
import Company.CompanyDBDAO;
import CompanyCoupon.CompanyCouponDBDAO;
import Customer.Customer;
import Customer.CustomerDBDAO;
import CustomerCoupon.CustomerCouponDBDAO;
import Exeptions.*;

public class AdminFacade implements CouponClientFasade {

	// Data mmbers
	ClientType clientType = ClientType.Admin;

	public AdminFacade() {

	}

	// Constructor
	public AdminFacade(ClientType clientType) {

		this.clientType = clientType;
	}

	// insert Company to Table
	public void createCompany(Company company) throws SQLException, InterruptedException {
		CompanyDBDAO companyDBDAO = new CompanyDBDAO();
		ArrayList<Company> allComp = new ArrayList<>();
         allComp = companyDBDAO.getAllCompany();
         boolean chek = false;
		
         for (Company company2 : allComp) {
			if (company.getCompName().equals(company2.getCompName())) {
				chek = true;
			}
		}
		
		if (chek = true) {
			System.out.print("exist");
		} else {
			companyDBDAO.createCompany(company);
		}
	}

	// delete Company from table
	public void removeCompany(Company company) throws SQLException, InterruptedException {
		CompanyDBDAO companyDBDAO = new CompanyDBDAO();
		CompanyCouponDBDAO companyCouponDBDAO = new CompanyCouponDBDAO();
		try {
			companyDBDAO.removeCompany(company);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		companyCouponDBDAO.deletefromCompcoup(company.getId());

	}

	// update Company
	public void updateCompany(Company company) throws InterruptedException {
		CompanyDBDAO companyDBDAO = new CompanyDBDAO();
		try {
			companyDBDAO.updateCompany(company);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// get Company By Id
	public Company getCompany(int id) throws SQLException, InterruptedException {
		CompanyDBDAO companyDBDAO = new CompanyDBDAO();
		return companyDBDAO.getCompany(id);

	}

	// get All Company's
	public Collection<Company> getAllCompanyes() throws SQLException, InterruptedException {
		CompanyDBDAO companyDBDAO = new CompanyDBDAO();
		return companyDBDAO.getAllCompany();

	}

	// insert to Customer Table
	public void createCustomer(Customer cust) throws SQLException, InterruptedException {

		boolean chek = false;
		CustomerDBDAO customerDBDAO = new CustomerDBDAO();
		ArrayList<Customer> allCust = new ArrayList<>();
		allCust = customerDBDAO.getAllCustomer();
		for (Customer customer : allCust) {
			if (customer.getCustName().equals(cust.getCustName())) {
				chek = true;
			}
		}
		if (chek == true) {
			System.out.print("exist");
		} else {
			customerDBDAO.createCustomer(cust);
		}

	}

	// delete from Customer Table
	public void removeCustomer(Customer cust) throws SQLException, InterruptedException {
		CustomerCouponDBDAO customerCouponDBDAO = new CustomerCouponDBDAO();
		CustomerDBDAO customerDBDAO = new CustomerDBDAO();
		customerDBDAO.removeCustomer(cust);
		customerCouponDBDAO.deletefromCustcoup(cust.getId());

	}

	// update Customer
	public void updateCustomer(Customer cust) throws SQLException, InterruptedException {
		CustomerDBDAO customerDBDAO = new CustomerDBDAO();
		customerDBDAO.updateCustomer(cust);
	}

	// get Customer By ID
	public Customer getCustomer(int id) throws SQLException, InterruptedException {
		CustomerDBDAO customerDBDAO = new CustomerDBDAO();
		return customerDBDAO.getCustomer(id);

	}

	// get All Customers
	public Collection<Customer> getAllCustomers() throws SQLException, InterruptedException {
		CustomerDBDAO customerDBDAO = new CustomerDBDAO();
		ArrayList<Customer> list = customerDBDAO.getAllCustomer();
		return list;

	}

	// Login to AdminFacade
	public CouponClientFasade login(String name, String password, ClientType c) {
		if ((name.equals("admin")) && (password.equals("1234"))) {
			AdminFacade adminFacade = new AdminFacade();
			return adminFacade;
		}
		return null;
	}

}
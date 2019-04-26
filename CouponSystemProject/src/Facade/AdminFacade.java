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
import Custumer.Custumer;
import Custumer.CustumerDBDAO;

public class AdminFacade implements CouponClientFasade {

	static CompanyDBDAO companyDBDAO = new CompanyDBDAO();
	static CustumerDBDAO custumerDBDAO = new CustumerDBDAO();

	public static void createCompany(Company company) throws SQLException {
for (Company comp : companyDBDAO.getAllCompany()) {
	if (comp.getCompName()== company.getCompName()) {
		return;
	}else {
		companyDBDAO.createCompany(company);
	}
}
	}

	public static void removeCompany(Company company) {
		try {
			companyDBDAO.removeCompany(company);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
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

	public static void createCustumer(Custumer cust) throws SQLException {
		for (Custumer custumer : custumerDBDAO.getAllCustomer()) {
			if (custumer.getCustName()== cust.getCustName()) {
				return;
			}else {
				custumerDBDAO.createCustumer(cust);
			}
		}
	}
	public static void removeCustumer(Custumer cust) throws SQLException {

		custumerDBDAO.removeCustumer(cust);
		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

	}

	public static void updateCustumer(Custumer cust) throws SQLException {
		custumerDBDAO.updateCompanyName(cust);
	}

	public static Custumer getCustumer(int id) {
		
		return getCustumer(id);

	}

	public static Collection<Company> getAllCustumers() {
		return getAllCustumers();

	}

	public static boolean login(String name, String password, String clientType) {
		String username = "admin";
		String pass = "1234";
		if( (name== username) && (pass == password)) {
			return true;
		}else {
			return false;
		}
	}

}
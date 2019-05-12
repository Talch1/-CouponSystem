package DataBase;

import java.sql.SQLException;

import Company.Company;
import Company.CompanyDBDAO;
import Coupon.Coupon;
import Coupon.CouponDBDAO;
import Coupon.CouponType;
import Customer.Customer;
import Customer.CustomerDBDAO;
import Exeptions.LoginEx;
import Facade.AdminFacade;
import Facade.CompanyFacade;
import Facade.CustomerFacade;

public class Test {

	public static void main(String[] args) throws SQLException {
		Company company = new Company(252, "pepsi", "1+1", "pppkkk", null);
		Customer cust = new Customer(553,"kolya","vvv",null);

		// Database.createAllTables();

		// Database.dropAllTables();

		// AdminFacade.createCompany(company);

		// AdminFacade.createCustomer(cust);

		// AdminFacade.removeCompany(company);

		// AdminFacade.removeCustomer(cust);

		// AdminFacade.updateCompany(company);  ?????????????????

		// AdminFacade.updateCustomer(cust);

		// AdminFacade.getCompany(id);

		// AdminFacade.getCustomer(id);

		// AdminFacade.getAllCompanyes();

		// AdminFacade.getAllCustomers();

		// AdminFacade.login(name, password, clientFasade);

		// CompanyFacade.createCoupon(coupon);

		// CompanyFacade.removeCoupon(coupon);

		// CompanyFacade.updateCoupon(coupon);

		// CompanyFacade.getAllCoupons();

		// CompanyFacade.getCoupon(id);

		// CompanyFacade.getCouponByType(type);

		// CompanyFacade.login(name, password, clientFasade);

		// CustomerFacade.purchaseCoupon(coupon, customer);

		// CustomerFacade.getAllPurchisedCouponsByPrice(price);

		// CustomerFacade.getAllPurchisedCouponsByType(type);

		// CustomerFacade.getAllPurchoisedCoupons();

		// CustomerFacade.login(name, password, clientFasade);

	}

}

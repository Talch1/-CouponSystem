package DataBase;

import java.sql.SQLException;
import java.util.Date;

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

	public static void main(String[] args) throws SQLException, InterruptedException {
		Date date = new Date(11-12-2015);
		CouponType couponType = CouponType.CAMPING;
	//	Company company = new Company(162, "fanta", "11", "ppk", null);
	//	Customer cust = new Customer(553, "kolya", "vvv", null);
		Coupon coupon = new Coupon(1,"1+1",date,date,6,couponType,"gggg",
				6.3, "hgf");
         

       // CouponSystem.getInstanse().database.createAllTables();
		
		// AdminFacade.createCompany(company);

		// AdminFacade.createCustomer(cust);

		// AdminFacade.removeCompany(company);

		// AdminFacade.removeCustomer(cust);

		// AdminFacade.updateCompany(company);

		// AdminFacade.updateCustomer(cust);

	    // System.out.println( AdminFacade.getCompany(55));

		// System.out.println(AdminFacade.getCustomer(2));

		// System.out.println( AdminFacade.getAllCompanyes());

		// System.out.println(AdminFacade.getAllCustomers()); 

	//AdminFacade.login(name, password, clientFasade);

		 CompanyFacade.createCoupon(coupon);

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

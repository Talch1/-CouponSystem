package DataBase;

import java.sql.SQLException;
import java.sql.Date;

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
		AdminFacade adminFacade = new AdminFacade();
		CompanyFacade companyFacade = new CompanyFacade();
		Date date = new Date(11 - 12 - 2015);
		CouponType couponType = CouponType.CAMPING;
		// Company company = new Company(162, "fanta", "11", "ppk", null);
		 Customer cust = new Customer(553, "kolya", "vvv", null);
		Coupon coupon = new Coupon(8888, "paa", date, date, 5, couponType, "jjj", 5.2, "http");
		CustomerFacade customerFacade = new CustomerFacade();

		//CouponSystem.getInstanse().database.createAllTables();

		// adminFacade.createCompany(company);

		// adminFacade.createCustomer(cust);

		// adminFacade.removeCompany(company);

		// adminFacade.removeCustomer(cust);

		// adminFacade.updateCompany(company);

		// adminFacade.updateCustomer(cust);

		// System.out.println(adminFacade.getCompany(55));

		// System.out.println(adminFacade.getCustomer(2));

		// System.out.println(adminFacade.getAllCompanyes());

		// System.out.println(adminFacade.getAllCustomers());

		//companyFacade.createCoupon(coupon);

		// companyFacade.removeCoupon(coupon);

		// companyFacade.updateCoupon(coupon);

		// System.out.println(companyFacade.getAllCoupons());

		// System.out.println(companyFacade.getCoupon(8888));

		//System.out.println(companyFacade.getCouponByType(couponType));

		//customerFacade.purchaseCoupon(coupon, cust);
	//	!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

		// System.out.println(customerFacade.getAllPurchisedCouponsByPrice(9.6)); 
		 
           
		//System.out.println( customerFacade.getAllPurchisedCouponsByType(null));

		//System.out.println(customerFacade.getAllPurchoisedCoupons());

	

	}

}

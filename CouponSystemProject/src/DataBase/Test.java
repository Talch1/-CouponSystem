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
import Exeptions.ExistEx;
import Exeptions.LoginEx;
import Facade.AdminFacade;
import Facade.CompanyFacade;
import Facade.CustomerFacade;

public class Test {

	public static void main(String[] args) throws SQLException, InterruptedException, LoginEx, ExistEx {
	
	AdminFacade adminFacade = (AdminFacade) CouponSystem.getInstanse().login("Admin", "1234", ClientType.Admin);

	//	CompanyFacade companyFacade = (CompanyFacade) CouponSystem.getInstanse().login("fanta","11", ClientType.Company);
		Date date = new Date(11 - 12 - 2015);
		CouponType couponType = CouponType.CAMPING;
        // CouponSystem.getInstanse().database.createAllTables();
		Customer cust = new Customer(553, "kolya", "vvv", null);
		Coupon coupon = new Coupon(8888, "paa", date, date, 5, couponType, "jjj", 5.2, "http");
	CustomerFacade customerFacade = (CustomerFacade) CouponSystem.getInstanse().login("kolya","vvv", ClientType.Customer);
		Company comp = new Company(162, "fnta", "111", "ppk", null);
		//adminFacade.createCompany(comp);

		 //adminFacade.createCustomer(cust);

		// adminFacade.removeCompany(company);

		// adminFacade.removeCustomer(cust);

		// adminFacade.updateCompany(company);

		// adminFacade.updateCustomer(cust);

		// System.out.println(adminFacade.getCompany(55));

		// System.out.println(adminFacade.getCustomer(2));

		// System.out.println(adminFacade.getAllCompanyes());

		// System.out.println(adminFacade.getAllCustomers());

		// companyFacade.createCoupon(coupon, comp);

		// companyFacade.removeCoupon(coupon);

		// companyFacade.updateCoupon(coupon);

		// System.out.println(companyFacade.getAllCoupons());

		// System.out.println(companyFacade.getCoupon(8888));

		// System.out.println(companyFacade.getCouponByType(couponType));

	customerFacade.purchaseCoupon(coupon, cust);
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

		//System.out.println(customerFacade.getAllPurchisedCouponsByPrice(9.6));

		// System.out.println( customerFacade.getAllPurchisedCouponsByType(null));

		// System.out.println(customerFacade.getAllPurchoisedCoupons());

	//	CouponSystem.getInstanse().shutdown();

	}

}

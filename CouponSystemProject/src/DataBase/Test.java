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
import CustomerCoupon.CustomerCouponDBDAO;
import Exeptions.CouponException;
import Exeptions.DateProblem;
import Exeptions.ExistEx;
import Exeptions.LoginEx;
import Facade.AdminFacade;
import Facade.CompanyFacade;
import Facade.CustomerFacade;

public class Test {

	public static void main(String[] args)
			throws SQLException, InterruptedException, LoginEx, ExistEx, CouponException, DateProblem {

		// CouponSystem.getInstanse().database.createAllTables();

		CouponSystem.getInstanse().start();

		AdminFacade adminFacade = (AdminFacade) CouponSystem.getInstanse().login("Admin", "1234", ClientType.Admin);

		CompanyFacade companyFacade = (CompanyFacade) CouponSystem.getInstanse().login("GetTAXY", "taxy",
				ClientType.Company);

		CustomerFacade customerFacade = (CustomerFacade) CouponSystem.getInstanse().login("kolya", "999",
				ClientType.Customer);

		Date date = new Date(System.currentTimeMillis());

		Date date1 = new Date(System.currentTimeMillis() +(1000*24*5*60*60));

		CouponType couponType = CouponType.FOOD;

		Customer cust = new Customer(553, "kolya", "999", null);

		Coupon coupon = new Coupon(255, "woow", date, date1, 5, couponType, " for club card", 15.5,
				"http:googleimage");

		// Company comp = new Company(112,"Coca-cola", "sweet", "pepsi@gmail.com",
		// null);
		Company comp = new Company(15, "rakevetIsrael", "Travel whis us", "rakevet@gmail.com", null);
		 adminFacade.createCompany(comp);

		// adminFacade.createCustomer(cust);

		// adminFacade.removeCompany(comp);

		// adminFacade.removeCustomer(cust);

		// adminFacade.updateCompany(comp);

		// adminFacade.updateCustomer(cust);

		// System.out.println(adminFacade.getCompany(3));

		// System.out.println(adminFacade.getCustomer(553));

		// System.out.println(adminFacade.getAllCompanyes());

		// System.out.println(adminFacade.getAllCustomers());

		// companyFacade.createCoupon(coupon, comp);

		// companyFacade.removeCoupon(coupon);

		// companyFacade.updateCoupon(coupon);

		// System.out.println(companyFacade.getAllCoupons(comp));

		// System.out.println(companyFacade.getCoupon(632));

		// System.out.println(companyFacade.getCouponByType(couponType));

		// customerFacade.buyCoupon(255,cust);

		// System.out.println(customerFacade.getAllPurchisedCouponsByPrice(3.6, cust));

		// System.out.println( customerFacade.getAllPurchisedCouponsByType(couponType,
		// cust));

		// System.out.println(customerFacade.getAllPurchoisedCoupons(cust));

		// CouponSystem.getInstanse().shutdown();

		CouponDBDAO couponDBDAO = new CouponDBDAO();
		couponDBDAO.getCouponByDate(date1);
	}

}

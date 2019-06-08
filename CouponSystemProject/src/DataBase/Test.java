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

		deleteAlltables();
		
		createAlltables();
		
		start();
		runAsAdmin();
		
		
	}

	/*
	 * 
	 * 
	 * CompanyFacade companyFacade = (CompanyFacade)
	 * CouponSystem.getInstanse().login("GetTAXY", "taxy", ClientType.Company);
	 * 
	 * CustomerFacade customerFacade = (CustomerFacade)
	 * CouponSystem.getInstanse().login("kolya", "999", ClientType.Customer);
	 * 
	 * Date date = new Date(System.currentTimeMillis());
	 * 
	 * Date date1 = new Date(System.currentTimeMillis() +(1000*24*5*60*60));
	 * 
	 * CouponType couponType = CouponType.FOOD;
	 * 
	 * Customer cust = new Customer(553, "kolya", "999", null);
	 * 
	 * Coupon coupon = new Coupon(255, "woow", date, date1, 5, couponType,
	 * " for club card", 15.5, "http:googleimage");
	 * 
	 * // // null);
	 * 
	 * 
	 * // companyFacade.createCoupon(coupon, comp);
	 * 
	 * // companyFacade.removeCoupon(coupon);
	 * 
	 * // companyFacade.updateCoupon(coupon);
	 * 
	 * // System.out.println(companyFacade.getAllCoupons(comp));
	 * 
	 * // System.out.println(companyFacade.getCoupon(632));
	 * 
	 * // System.out.println(companyFacade.getCouponByType(couponType));
	 * 
	 * // customerFacade.buyCoupon(255,cust);
	 * 
	 * // System.out.println(customerFacade.getAllPurchisedCouponsByPrice(3.6,
	 * cust));
	 * 
	 * // System.out.println(
	 * customerFacade.getAllPurchisedCouponsByType(couponType, // cust));
	 * 
	 * // System.out.println(customerFacade.getAllPurchoisedCoupons(cust));
	 * 
	 * // CouponSystem.getInstanse().shutdown();
	 * 
	 * CouponDBDAO couponDBDAO = new CouponDBDAO();
	 * couponDBDAO.getCouponByDate(date1); }
	 */
	private static void start() {
		CouponSystem.getInstanse().start();
	}

	private static void createAlltables() throws SQLException, InterruptedException {
		CouponSystem.getInstanse().createAllTables();
	}

	public static void deleteAlltables() throws SQLException, InterruptedException {
		CouponSystem.getInstanse().database.dropAllTables();

	}

	private static void runAsAdmin() throws LoginEx, InterruptedException, SQLException, ExistEx {

		String name = "Admin";
		String password = "1234";
		AdminFacade adminFacade = (AdminFacade) CouponSystem.getInstanse().login("Admin", "1234", ClientType.Admin);

		Company comp = new Company(1, "Coca-cola", "coka", "cola@gmail.com", null);
		Company comp1 = new Company(2, "Hunday", "motor", "hunday@gmail.com", null);
		Company comp2 = new Company(3, "Canon", "photo", "canon@gmail.com", null);


		adminFacade.createCompany(comp);
		adminFacade.createCompany(comp1);
		adminFacade.createCompany(comp2);

		Customer cust = new Customer(1, "Moshe", "msh", null);
		Customer cust1 = new Customer(2, "Maks", "bbb", null);
		Customer cust2 = new Customer(3, "Rob", "god", null);
System.out.println("g");
		adminFacade.createCustomer(cust);
		adminFacade.createCustomer(cust1);
		adminFacade.createCustomer(cust2);

		adminFacade.removeCompany(comp);

		adminFacade.removeCustomer(cust);
		
		cust1 = new Customer(2, "Vasya", "rrr", null);
		adminFacade.updateCompany(comp);

		comp2 = new Company(3, "Canon", "takephoto", "canon1234@gmail.com", null);
		adminFacade.updateCustomer(cust);

		System.out.println(adminFacade.getCompany(2));

		System.out.println(adminFacade.getCustomer(3));

		System.out.println(adminFacade.getAllCompanyes());

		System.out.println(adminFacade.getAllCustomers());

	}
}

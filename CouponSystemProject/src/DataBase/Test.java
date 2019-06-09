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
import Exeptions.SizeEx;
import Facade.AdminFacade;
import Facade.CompanyFacade;
import Facade.CustomerFacade;

public class Test {

	public static void main(String[] args)
			throws SQLException, InterruptedException, LoginEx, ExistEx, CouponException, DateProblem, SizeEx {

		start();

		deleteAlltables();

		createAlltables();

		runAsAdmin();

		runAsCompany();
		
		runAsCustomer();
 
		
		CouponSystem.getInstanse().shutdown();
	}

	private static void start() {
		CouponSystem.getInstanse().start();
		System.out.println("start");
	}

	private static void createAlltables() throws SQLException, InterruptedException, SizeEx {
		CouponSystem.getInstanse().createAllTables();
	}

	public static void deleteAlltables() throws SQLException, InterruptedException, SizeEx {
		CouponSystem.getInstanse().database.dropAllTables();

	}

	private static void runAsAdmin() throws LoginEx, InterruptedException, SQLException, ExistEx, SizeEx {

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

		adminFacade.createCustomer(cust);
		adminFacade.createCustomer(cust1);
		adminFacade.createCustomer(cust2);

		adminFacade.removeCompany(comp);

		adminFacade.removeCustomer(cust);
		comp1 = new Company(3, "Canon", "takephoto", "canon1234@gmail.com", null);
		
		cust1 = new Customer(2, "Maks", "rrr", null);
		adminFacade.updateCompany(comp1);

		adminFacade.updateCustomer(cust1);

		System.out.println(adminFacade.getCompany(2));

		System.out.println(adminFacade.getCustomer(3));

		System.out.println(adminFacade.getAllCompanyes());

		System.out.println(adminFacade.getAllCustomers());

	}

	public static void runAsCompany() throws LoginEx, InterruptedException, DateProblem, SQLException, ExistEx, SizeEx {
		CompanyFacade companyFacade = (CompanyFacade) CouponSystem.getInstanse().login("Canon", "takephoto",
				ClientType.Company);

		Date date = new Date(System.currentTimeMillis());
		Date date1 = new Date(System.currentTimeMillis() + (1000 * 24 * 5 * 60 * 60));
		CouponType couponType = CouponType.ELECTRICITY;

		Coupon coupon = new Coupon(1, "woow", date, date1, 5, couponType, " for club card", 15.5, "http:googleimage");
		Coupon coupon2 = new Coupon(2, "1+1", date, date1, 5, couponType, "new", 120, "http:googleimage");

		Company comp = new Company(3, "Canon", "takephoto", "canon1234@gmail.com", null);

		companyFacade.createCoupon(coupon, comp);
		companyFacade.createCoupon(coupon2, comp);

		coupon = new Coupon(1, "2+2", date, date1, 5, couponType, " for club card", 15.5, "http:googleimage");

		companyFacade.removeCoupon(coupon2);

		companyFacade.updateCoupon(coupon);

		System.out.println(companyFacade.getAllCoupons(comp));

		System.out.println(companyFacade.getCoupon(1));

		System.out.println(companyFacade.getCouponByType(couponType));

	}
	
	public static void runAsCustomer() throws LoginEx, InterruptedException, SQLException, DateProblem, ExistEx, CouponException, SizeEx{
		
		CustomerFacade customerFacade = (CustomerFacade)CouponSystem.getInstanse().login("Maks", "rrr", ClientType.Customer);
		Date date = new Date(System.currentTimeMillis());
		Date date1 = new Date(System.currentTimeMillis() + (1000 * 24 * 5 * 60 * 60));
		Customer cust = new Customer(2, "Vasya", "rrr", null);
		CouponType couponType = CouponType.ELECTRICITY;
		
		Coupon coupon = new Coupon(1, "woow", date, date1, 5, couponType, " for club card", 15.5, "http:googleimage");
		
		customerFacade.buyCoupon(1,cust);
		
		 
		 
		  System.out.println(customerFacade.getAllPurchisedCouponsByPrice(3.6, cust));
		  System.out.println(customerFacade.getAllPurchisedCouponsByType(couponType, cust));
		  System.out.println(customerFacade.getAllPurchasedCoupons(cust));
		  CouponSystem.getInstanse().shutdown();
		 
		 CouponDBDAO couponDBDAO = new CouponDBDAO();
		 couponDBDAO.getCouponByDate(date1); }
		
	}



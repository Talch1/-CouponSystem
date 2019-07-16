package DataBase;

import java.sql.SQLException;
import java.sql.Date;
import Company.Company;
import Coupon.Coupon;
import Coupon.CouponDBDAO;
import Coupon.CouponType;
import Customer.Customer;
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

		System.out.println("Start");
		System.out.println("    ");
	}

	private static void createAlltables() throws SQLException, InterruptedException {
		CouponSystem.getInstanse().createAllTables();
		System.out.println("    ");
		System.out.println("All Taibles Created");
		System.out.println("    ");
	}

	public static void deleteAlltables() throws SQLException, InterruptedException {

		CouponSystem.getInstanse().database.dropAllTables();
		System.out.println("    ");
		System.out.println("All Taibles Deleted");
		System.out.println("    ");
	}

	private static void runAsAdmin() throws LoginEx, InterruptedException, SQLException, ExistEx {
		System.out.println("Admin Run");
		System.out.println("");
		
		String name = "Admin";
		String password = "1234";
		AdminFacade adminFacade = (AdminFacade) CouponSystem.getInstanse().login("Admin", "1234", ClientType.Admin);

		Company comp = new Company(1, "Coca-cola", "coka", "cola@gmail.com", null);
		Company comp1 = new Company(2, "Hunday", "motor", "hunday@gmail.com", null);
		Company comp2 = new Company(3, "Canon", "photo", "canon@gmail.com", null);

		adminFacade.createCompany(comp);
		adminFacade.createCompany(comp1);
		adminFacade.createCompany(comp2);

		System.out.println(" ");

		Customer cust = new Customer(1, "Moshe", "msh", null);
		Customer cust1 = new Customer(2, "Maks", "bbb", null);
		Customer cust2 = new Customer(3, "Rob", "god", null);

		adminFacade.createCustomer(cust);
		adminFacade.createCustomer(cust1);
		adminFacade.createCustomer(cust2);

		System.out.println("");

		adminFacade.removeCompany(comp);

		System.out.println(" ");

		adminFacade.removeCustomer(cust);

		System.out.println(" ");

		comp1 = new Company(3, "Canon", "takephoto", "canon1234@gmail.com", null);

		cust1 = new Customer(2, "Maks", "rrr", null);

		adminFacade.updateCompany(comp1);

		System.out.println(" ");

		adminFacade.updateCustomer(cust1);

		System.out.println(" ");

		System.out.println("Get company with id 2 ");
		System.out.println(adminFacade.getCompany(2));

		System.out.println(" ");

		System.out.println("Get company with id 2 ");
		System.out.println(adminFacade.getCustomer(3));

		System.out.println(" ");

		System.out.println("Get all companyes");
		System.out.println(adminFacade.getAllCompanyes());

		System.out.println(" ");

		System.out.println("Get all customers");
		System.out.println(adminFacade.getAllCustomers());
		System.out.println("");
	}

	public static void runAsCompany() throws LoginEx, InterruptedException, DateProblem, SQLException, ExistEx {
		System.out.println("Company Run");
		System.out.println("");
		
		CompanyFacade companyFacade = (CompanyFacade) CouponSystem.getInstanse().login("Canon", "takephoto",
				ClientType.Company);

		Date date = new Date(System.currentTimeMillis());
		Date date1 = new Date(System.currentTimeMillis() + (1000 * 24 * 5 * 60 * 60));
		CouponType couponType = CouponType.ELECTRICITY;
		CouponType couponType2 = CouponType.HEALTH;

		Coupon coupon = new Coupon(1, "woow", date, date1, 5, couponType, " for club card", 15.5, "http:googleimage");
		Coupon coupon2 = new Coupon(2, "1+1", date, date1, 5, couponType, "new", 112.3, "http:googleimage");
		Coupon coupon3 = new Coupon(3, "new", date, date1, 5, couponType2, "to weeks only", 222.3, "http:googleimage");

		Company comp = new Company(3, "Canon", "takephoto", "canon1234@gmail.com", null);

		companyFacade.createCoupon(coupon, comp);
		companyFacade.createCoupon(coupon2, comp);
		companyFacade.createCoupon(coupon3, comp);

		coupon = new Coupon(1, "2+2", date, date1, 5, couponType, " for club card", 15.5, "http:googleimage");

		System.out.println("");

		companyFacade.removeCoupon(coupon2);
		
		System.out.println("");
		
		companyFacade.updateCoupon(coupon);
		
		System.out.println("");
		System.out.println("Get all companyes");
		System.out.println(companyFacade.getAllCoupons(comp));
		
		System.out.println("");
		System.out.println("Get coupon with id 1");
		System.out.println(companyFacade.getCoupon(1));
		
		System.out.println("");
		System.out.println("Get coupon by type" + couponType);
		System.out.println(companyFacade.getCouponByType(couponType));

		System.out.println("");
	}

	public static void runAsCustomer()
			throws LoginEx, InterruptedException, SQLException, DateProblem, ExistEx, CouponException {

		System.out.println("Customer Run");
		System.out.println("");
		
		CustomerFacade customerFacade = (CustomerFacade) CouponSystem.getInstanse().login("Maks", "rrr",
				ClientType.Customer);
		Date date = new Date(System.currentTimeMillis());
		Date date1 = new Date(System.currentTimeMillis() + (1000 * 24 * 5 * 60 * 60));
		Date date2 = new Date(System.currentTimeMillis() - (60 * 24 * 60 * 1000 * 30));
		
		Customer cust = new Customer(2, "Vasya", "rrr", null);
		
		CouponType couponType = CouponType.ELECTRICITY;
		CouponType couponType2 = CouponType.FOOD;
		
		Coupon coupon = new Coupon(1, "woow", date, date1, 5, couponType, " for club card", 15.5, "http:googleimage");
		Coupon coupon3 = new Coupon(3, "new", date, date1, 5, couponType2, "to weeks only", 222.3, "http:googleimage");
		
		System.out.println("Customer by coupon with id 3");
		System.out.println("");
		customerFacade.buyCoupon(3, cust);
		
		System.out.println("");
		System.out.println("Customer by coupon with id 1");
		customerFacade.buyCoupon(1, cust);
		
		System.out.println("");
		System.out.println("Get all coupon where prise < 22.5");
		System.out.println(customerFacade.getAllPurchisedCouponsByPrice(22.5, cust));
		
		System.out.println("");
		System.out.println("Get all coupon where coupon type = " + couponType);
		System.out.println(customerFacade.getAllPurchisedCouponsByType(couponType, cust));
		
		System.out.println("");
		System.out.println("Get all purcaesed coupons");
		System.out.println(customerFacade.getAllPurchasedCoupons(cust));
		
		System.out.println("");
		System.out.println("Get all coupon where end-date before " +date2);
		System.out.println(customerFacade.getAllPurchisedCouponByDate(date2, cust));

	}

}

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
import Exeptions.ExistEx;
import Exeptions.LoginEx;
import Facade.AdminFacade;
import Facade.CompanyFacade;
import Facade.CustomerFacade;

public class Test {

	public static void main(String[] args)
			throws SQLException, InterruptedException, LoginEx, ExistEx, CouponException {
Date date1 = new Date(System.currentTimeMillis());
		AdminFacade adminFacade = (AdminFacade) CouponSystem.getInstanse().login("Admin", "1234", ClientType.Admin);
		CompanyFacade companyFacade = (CompanyFacade) CouponSystem.getInstanse().login("pepsi", "222",
				ClientType.Company);
	
		@SuppressWarnings("deprecation")
		Date date = new Date(1958,15,12);
		CouponType couponType = CouponType.CAMPING;
		// CouponSystem.getInstanse().database.createAllTables();
		Customer cust = new Customer(555, "bob", "66", null);
		Coupon coupon = new Coupon(632, "hgf", date1, date, 5, couponType, "jjj", 5.8, "http");
		CustomerFacade customerFacade = (CustomerFacade) CouponSystem.getInstanse().login("kolya", "999",
				ClientType.Customer);
		Company comp = new Company(3, "kola", "666", "8", null);
		CustomerCouponDBDAO customerCouponDBDAO = new CustomerCouponDBDAO();

		// adminFacade.createCompany(comp);

		// adminFacade.createCustomer(cust);

		// adminFacade.removeCompany(comp);

		// adminFacade.removeCustomer(cust);

		// adminFacade.updateCompany(comp);

		//adminFacade.updateCustomer(cust);

		// System.out.println(adminFacade.getCompany(3));

		// System.out.println(adminFacade.getCustomer(553));

		// System.out.println(adminFacade.getAllCompanyes());

		// System.out.println(adminFacade.getAllCustomers());

		//companyFacade.createCoupon(coupon, comp);

		// companyFacade.removeCoupon(coupon);

		// companyFacade.updateCoupon(coupon);

	//	System.out.println(companyFacade.getAllCoupons(comp));

		// System.out.println(companyFacade.getCoupon(632));

		// System.out.println(companyFacade.getCouponByType(couponType));

		 //customerFacade.buyCoupon(632,cust);

		// System.out.println(customerFacade.getAllPurchisedCouponsByPrice(3.6, cust));

		// System.out.println( customerFacade.getAllPurchisedCouponsByType(couponType, cust));

		// System.out.println(customerFacade.getAllPurchoisedCoupons(cust));

		// CouponSystem.getInstanse().shutdown();

	}

}

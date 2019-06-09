package Facade;

import java.awt.List;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import Coupon.Coupon;
import Coupon.CouponDBDAO;
import Coupon.CouponType;
import Customer.Customer;
import Customer.CustomerDBDAO;
import CustomerCoupon.CustomerCouponDBDAO;
import DataBase.ClientType;
import DataBase.CouponSystem;
import Exeptions.CouponException;
import Exeptions.DateProblem;
import Exeptions.ExistEx;
import Exeptions.LoginEx;

public class CustomerFacade implements CouponClientFasade {

	public CustomerFacade() {

	}

	// buy Coupon
	public void buyCoupon(long couponID, Customer customer)
			throws CouponException, SQLException, InterruptedException, DateProblem, ExistEx {
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		CustomerCouponDBDAO customerCouponDBDAO = new CustomerCouponDBDAO();

		Coupon coupon = couponDBDAO.getCoupon(couponID);

		if (coupon.getAmount() <= 0) {
			throw new CouponException("No more coupons for you!!");
		}
		chek(customer, couponDBDAO.getCoupon(couponID));
		customerCouponDBDAO.buyCoupon(coupon, customer);
		System.out.println("Coupon Bought");
	}

	// Get All purchased coupons by Customer
	public ArrayList<Coupon> getAllPurchasedCoupons(Customer customer)
			throws SQLException, InterruptedException, DateProblem, ExistEx {
		CustomerCouponDBDAO customerCouponDBDAO = new CustomerCouponDBDAO();
		return customerCouponDBDAO.getAllpurchoiseCoupons(customer);

	}

	// Get All purchased coupons by Customer
	public void chek(Customer customer, Coupon coupon1)
			throws SQLException, InterruptedException, DateProblem, ExistEx {
		ArrayList<Coupon> list = getAllPurchasedCoupons(customer);
		for (Coupon coupon : list) {
			if (coupon.equals(coupon1)) {
				throw new ExistEx("Customer all ready has this Coupon");
			}
		}

	}

	// Get All purchased coupons by Customer by type
	public ArrayList<Coupon> getAllPurchisedCouponsByType(CouponType type, Customer customer)
			throws SQLException, InterruptedException, DateProblem, ExistEx {
		CustomerCouponDBDAO customerCouponDBDAO = new CustomerCouponDBDAO();

		
		return customerCouponDBDAO.getAllPurchaiseCouponByType(type, customer);
	}

	// Get All purchased coupons by Customer before price
	public ArrayList<Coupon> getAllPurchisedCouponsByPrice(double price, Customer customer)
			throws SQLException, InterruptedException, DateProblem, ExistEx {
		CustomerCouponDBDAO customerCouponDBDAO = new CustomerCouponDBDAO();
		return customerCouponDBDAO.getAllPurchaiseCouponByPrice(price, customer);

	}

	// Get All purchased coupons by Customer before Date Expiration
		public ArrayList<Coupon> getAllPurchisedCouponByDate(Date date, Customer customer)
				throws SQLException, InterruptedException, DateProblem, ExistEx {
			CustomerCouponDBDAO customerCouponDBDAO = new CustomerCouponDBDAO();
			return customerCouponDBDAO.getAllPurchaiseCouponByDate(date, customer);

		}

	// Login
	public CouponClientFasade login(String name, String password, ClientType c) throws InterruptedException, LoginEx {
		CustomerDBDAO customerDBDAO = new CustomerDBDAO();
		if (customerDBDAO.login(name, password)) {
			CustomerFacade customerFacade = new CustomerFacade();
			return customerFacade;
		} else {
			throw new LoginEx("Invalid email or password");
		}

	}
}
package Facade;

import java.awt.List;
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
import Exeptions.LoginEx;

public class CustomerFacade implements CouponClientFasade {

	public CustomerFacade() {

	}

	public void buyCoupon(long couponID, Customer customer) throws CouponException, SQLException, InterruptedException {
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

	public ArrayList<Coupon> getAllPurchoisedCoupons(Customer customer) throws SQLException, InterruptedException {
		CustomerCouponDBDAO customerCouponDBDAO = new CustomerCouponDBDAO();
		return customerCouponDBDAO.getAllpurchoiseCoupons(customer);

	}

	public void chek(Customer customer, Coupon coupon1) throws SQLException, InterruptedException, CouponException {
		ArrayList<Coupon> list = getAllPurchoisedCoupons(customer);
		for (Coupon coupon : list) {
			if (coupon.equals(coupon1)) {
				throw new CouponException("Customer Have This Coupon");
			}
		}

	}

	public ArrayList<Coupon> getAllPurchisedCouponsByType(CouponType type, Customer customer)
			throws SQLException, InterruptedException {
		CustomerCouponDBDAO customerCouponDBDAO = new CustomerCouponDBDAO();
		return customerCouponDBDAO.getAllPurchaiseCouponByType(type, customer);
	}

	public ArrayList<Coupon> getAllPurchisedCouponsByPrice(double price, Customer customer)
			throws SQLException, InterruptedException {
		CustomerCouponDBDAO customerCouponDBDAO = new CustomerCouponDBDAO();
		return customerCouponDBDAO.getAllPurchaiseCouponByPrice(price, customer);

	}

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
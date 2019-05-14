package Utils;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import Coupon.Coupon;
import Coupon.CouponDBDAO;
import Customer.Customer;
import CustomerCoupon.CustomerCouponDBDAO;

public class CustumerCouponChek {
	
	CustomerCouponDBDAO custumerCouponDBDAO = new CustomerCouponDBDAO();
	

	public boolean checkAmount(Coupon coupon) throws SQLException, InterruptedException {
		Collection<Coupon> allCoupons = new ArrayList<>();
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		int a = 0;
		allCoupons = couponDBDAO.getAllCoupons();

		for (Coupon coupon1 : allCoupons) {
			if (coupon1.getAmount() >= 1) {
				a++;
			}
		}
		if (a > 0) {
			return true;
		} else {
			return false;
		}

	}

	public boolean checkCustomerCouponByCouponId(Customer custumer, Coupon coupon)
			throws SQLException, InterruptedException {
		ArrayList<CustomerCouponDBDAO> list = new ArrayList<>();
		custumerCouponDBDAO = null;
		int a = 0;
		list = custumerCouponDBDAO.getCustomerCoupon(custumer.getId());
		for (CustomerCouponDBDAO custumerCouponDBDAO : list) {
			if (custumerCouponDBDAO.getCoupon_id() == coupon.getId()) {
				a++;
			}
		}
		if (a > 0) {
			return true;
		} else {
			return false;
		}

	}

}

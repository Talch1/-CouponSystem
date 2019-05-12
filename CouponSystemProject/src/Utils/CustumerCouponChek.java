package Utils;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import Coupon.Coupon;
import CustumerCoupon.CustumerCouponDBDAO;
import Coupon.CouponDBDAO;
import Customer.Customer;

public class CustumerCouponChek {
	static Connection con = null;
	static CustumerCouponDBDAO custumerCouponDBDAO = new CustumerCouponDBDAO();
	static CouponDBDAO couponDBDAO = new CouponDBDAO();

	public static boolean checkAmount(Coupon coupon) throws SQLException {
		Collection<Coupon> allCoupons = new ArrayList<>();
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

	public static boolean checkCustumerCouponByCouponId(Customer custumer, Coupon coupon) throws SQLException {
		ArrayList<CustumerCouponDBDAO> list = new ArrayList<>();
		custumerCouponDBDAO = null;
		int a = 0;
		list = custumerCouponDBDAO.getCustumerCoupon(custumer.getId());
		for (CustumerCouponDBDAO custumerCouponDBDAO : list) {
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

package Facade;

import java.sql.SQLException;
import java.util.Collection;

import Company.CompanyDAO;
import Company.CompanyDBDAO;
import Coupon.Coupon;
import Coupon.CouponDBDAO;
import Coupon.CouponType;

public class CompanyFacade {

	  CouponDBDAO couponDBDAO = new CouponDBDAO();
	

	public static void createCoupon(Coupon coupon) {
		try {
			CouponDBDAO.createCoupon(coupon);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void rempveCoupon(Coupon coupon) {
		try {
			CouponDBDAO.removeCoupon(coupon);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updateCoupon(Coupon coupon) {
		try {
			CouponDBDAO.updateCoupon(coupon);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Coupon getCoupon(int id) {
		return null;
////!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	}

	public static Collection<Coupon> getAllCoupons() {
		return null;
		// !!!!!!!!!!!!!!!!
	}

	public static Collection<Coupon> getCouponByType(CouponType type) {
		return null;
		// !!!!!!!!!!!!!!!!!!!!!!!!!
	}

	public static boolean login(String name, String password, String clientType) {
		return false;
     //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	}
}

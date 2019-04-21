package Facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import Company.CompanyDAO;
import Company.CompanyDBDAO;
import Coupon.Coupon;
import Coupon.CouponDBDAO;
import Coupon.CouponType;

public class CompanyFacade implements CouponClientFasade {
	
     static CompanyDBDAO companyDBDAO = new CompanyDBDAO();
	 static CouponDBDAO couponDBDAO = new CouponDBDAO();
	

	public static void createCoupon(Coupon coupon) {
		try {
			couponDBDAO.createCoupon(coupon);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void rempveCoupon(Coupon coupon) {
		try {
			couponDBDAO.removeCoupon(coupon);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updateCoupon(Coupon coupon) {
		try {
			couponDBDAO.updateCoupon(coupon);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Coupon getCoupon(int id) {
		Coupon c = new Coupon();
 try {
	couponDBDAO.getCoupon(id);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 return c;
	}

	public static Collection<Coupon> getAllCoupons() {
		ArrayList<Coupon> coupons = new ArrayList<>();
		try {
		coupons = (ArrayList<Coupon>) couponDBDAO.getAllCoupons();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return coupons;
		
	}

	public static Collection<Coupon> getCouponByType(CouponType type) {
		
		ArrayList<Coupon> list = new ArrayList<>();
		try {
			list = (ArrayList<Coupon>) couponDBDAO.getCouponByType(type);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public static boolean login(String name, String password, String clientType) {
		return companyDBDAO.login(name, password);
     
	}
}

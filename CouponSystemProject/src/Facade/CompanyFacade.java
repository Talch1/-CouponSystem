package Facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import Company.Company;
import Company.CompanyDAO;
import Company.CompanyDBDAO;
import Coupon.Coupon;
import Coupon.CouponDBDAO;
import Coupon.CouponType;

public class CompanyFacade implements CouponClientFasade {
	
     static CompanyDBDAO companyDBDAO = new CompanyDBDAO();
	 static CouponDBDAO couponDBDAO = new CouponDBDAO();
	

	public static void createCoupon(Coupon coupon) throws SQLException {
		for (Coupon coup : couponDBDAO.getAllCoupons()) {
			if (coup.getTitle()== coupon.getTitle()) {
				return;
			}else {
			couponDBDAO.createCoupon(coupon);
		
	}
		}
	}

	public static void removeCoupon(Coupon coupon) throws SQLException {
		
			couponDBDAO.removeCoupon(coupon);
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!	
	}

	public static void updateCoupon(Coupon coupon) throws SQLException {
		
			couponDBDAO.updateCoupon(coupon);
		
	}

	public static Coupon getCoupon(int id) {
		return getCoupon(id);
	}

	public static Collection<Coupon> getAllCoupons() throws SQLException {
		
	
		return couponDBDAO.getAllCoupons();
		
		
		
	}

	public static Collection<Coupon> getCouponByType(CouponType type) throws SQLException {
		
		return couponDBDAO.getAllCoupons();
	}

	
	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	
	
	public static boolean login(String name, String password, String clientType) {
		return companyDBDAO.login(name, password);
     
	}
}

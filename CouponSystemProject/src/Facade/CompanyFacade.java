package Facade;

import java.sql.SQLException;

import java.util.Collection;

import Exeptions.*;

import Company.CompanyDBDAO;
import Coupon.Coupon;
import Coupon.CouponDBDAO;
import Coupon.CouponType;
import DataBase.ClientType;

public class CompanyFacade implements CouponClientFasade {

	
	static CompanyDBDAO companyDBDAO = new CompanyDBDAO();
	 static CouponDBDAO couponDBDAO = new CouponDBDAO();

	public static void createCoupon(Coupon coupon) throws SQLException {
		for (Coupon coup : couponDBDAO.getAllCoupons()) {
			if (coup.getTitle() == coupon.getTitle()) {
				return;
			} else {
				couponDBDAO.createCoupon(coupon);

			}
		}
	}

	public static void removeCoupon(Coupon coupon) throws SQLException {

		couponDBDAO.removeCoupon(coupon);
		Utils.CouponPurchaise.deletefromCustcoup(coupon.getId());
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

		return couponDBDAO.getCouponByType(type);
	}

	public CouponClientFasade login(String name, String password, ClientType c)
	
	{
		if (companyDBDAO.login(name, password)) {
			CompanyFacade companyFacade = new CompanyFacade();
			return companyFacade;
		}
		return null;
      
	}
}

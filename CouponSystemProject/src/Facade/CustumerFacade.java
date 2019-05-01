package Facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import Coupon.Coupon;
import Coupon.CouponType;
import Custumer.Custumer;
import Custumer.CustumerDBDAO;
import Utils.CouponPurchaise;
import Utils.CustumerCouponChek;
import CustumerCoupon.CustumerCouponDBDAO;

public class CustumerFacade implements CouponClientFasade {
     private static final CouponClientFasade Exception = null;
	static CustumerDBDAO custumerDBDAO = new CustumerDBDAO();
	static CustumerFacade custumerFacade = new CustumerFacade();
	static CustumerCouponDBDAO custumerCouponDBDAO = new CustumerCouponDBDAO();

	public static void purchaseCoupon(Coupon coupon, Custumer custumer) throws SQLException {

		CustumerCouponChek chek = new CustumerCouponChek();
		CouponPurchaise couponPurchaise = new CouponPurchaise();

		if ((chek.checkAmount(coupon) == true && chek.checkCustumerCouponByCouponId(custumer, coupon) == false)) {

		}

	}

	public static ArrayList<Coupon> getAllPurchoisedCoupons() throws SQLException {
		return CouponPurchaise.getAllpurchoiseCoupons();

	}

	public static ArrayList<Coupon> getAllPurchisedCouponsByType(CouponType type) throws SQLException {
		return CouponPurchaise.getAllPurchaiseCouponByType(type);
	}

	public static ArrayList<Coupon> getAllPurchisedCouponsByPrice(double price) throws SQLException {
		return CouponPurchaise.getAllPurchaiseCouponByPrice(price);

	}

	public static CouponClientFasade login(String name, String password, CouponClientFasade clientFasade) {

		if (custumerDBDAO.login(name, password )== true) {
			return custumerFacade;
		}else {return Exception;//1111111111111111111111111111111111111111111111111111111111111111111111111111111111
		}
		

	}
}
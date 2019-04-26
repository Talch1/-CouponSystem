package Facade;

import Coupon.Coupon;
import Coupon.CouponDBDAO;
import Coupon.CouponType;

public class CustumerFacade implements CouponClientFasade{

	static CouponDBDAO couponDBDAO = new CouponDBDAO();
	
	public static void purchaseCoupon(Coupon coupon) {
        
	}
	public static void getAllPurchoisedCoupons() {
}
	public static void getAllPurchisedCouponsByType(CouponType type) {
	
}
	public static void getAllPurchisedCouponsByPrice(double price) {
		
	}
	public static boolean login(String name,String password,String clientType) {
		
		return false;
	}
}
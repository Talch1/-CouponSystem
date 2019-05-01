package DataBase;

import java.io.IOException;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import Coupon.Coupon;
import Coupon.CouponDBDAO;

public class DailyCouponExpirationTask implements Runnable{
	CouponDBDAO couponDBDAO = new CouponDBDAO();
	Date date = new Date(System.currentTimeMillis());
Thread t = new Thread();
	@Override
	public void run() {
		try {
			t.sleep(1000*60*60*24);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		t.start();
		ArrayList<Coupon> coupons = new ArrayList<>();
		try {
			coupons = couponDBDAO.getAllCoupons();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Coupon coupon : coupons) {
			if (coupon.getEndDate().before(date)) {
				coupons.remove(coupon);
				
			}
			for (Coupon coupon1 : coupons) {
				try {
					couponDBDAO.removeCoupon(coupon1);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	

}

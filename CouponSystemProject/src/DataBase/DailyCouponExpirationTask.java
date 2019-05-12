package DataBase;

import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import Coupon.Coupon;
import Coupon.CouponDBDAO;

public class DailyCouponExpirationTask implements Runnable {
	CouponDBDAO couponDBDAO = new CouponDBDAO();
	
	 volatile static boolean stop = true; 

	@Override
	public void run() {
		
		while (stop) {
			try {
				couponDBDAO.deleteExpirdCoup(new Date(System.currentTimeMillis()));
				Thread.sleep( 1000*60*60*24);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static void stopp(){
		stop = false;
	}
	

}



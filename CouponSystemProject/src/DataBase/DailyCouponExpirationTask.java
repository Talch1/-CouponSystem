package DataBase;

import java.sql.Date;
import java.sql.SQLException;
import Coupon.CouponDBDAO;
import Exeptions.DateProblem;
import Exeptions.ExistEx;


public class DailyCouponExpirationTask implements Runnable {


	volatile static boolean stop = true;

	// Run on database and delete all coupons that end date before date
	@Override
	public void run() {
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		while (stop) {
			try {
				couponDBDAO.deleteExpirdCoup(new Date(System.currentTimeMillis()));
				Thread.sleep(1000);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExistEx e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DateProblem e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	// stop the thread
	public static void stopp() {
		stop = false;
	}

}

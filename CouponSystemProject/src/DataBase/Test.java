package DataBase;


import java.sql.SQLException;

import Coupon.CouponDBDAO;


public class Test {

	static int id = 2;


	public static void main(String[] args) throws SQLException {
		CouponDBDAO.updateCouponAmount(5, id);
	
		
	}


}

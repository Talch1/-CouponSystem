package DataBase;


import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import Company.Company;
import Company.CompanyDBDAO;
import Coupon.Coupon;
import Coupon.CouponDBDAO;
import Coupon.CouponType;
import Custumer.Custumer;
import Custumer.CustumerDBDAO;



public class Test {

	



	public static void main(String[] args) throws SQLException {
		//Database.createCoupon();
		
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		
		System.out.println(couponDBDAO.getCoupon(51));
	}
	
	
		
	}




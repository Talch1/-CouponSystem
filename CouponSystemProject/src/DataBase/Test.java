package DataBase;

import java.sql.Date;
import java.sql.SQLException;

import Company.Company;
import Company.CompanyDBDAO;
import Coupon.Coupon;
import Coupon.CouponDBDAO;
import Coupon.CouponType;
import Custumer.Custumer;
import Custumer.CustumerDBDAO;
import Utils.CustumerCouponChek;



public class Test {

	public static void main(String[] args) throws SQLException {
		 CompanyDBDAO co = new CompanyDBDAO();
		System.out.println(co.login("kola", "ppp"));
		
		
	}

}

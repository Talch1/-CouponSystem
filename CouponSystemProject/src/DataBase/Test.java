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
import Exeptions.LoginEx;
import Facade.AdminFacade;
import Utils.CustumerCouponChek;



public class Test {

	public static void main(String[] args) throws SQLException, LoginEx {
		 AdminFacade .login("admin", "123", null);
		
		
	}

}

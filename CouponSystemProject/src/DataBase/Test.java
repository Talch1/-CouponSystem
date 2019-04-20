package DataBase;

import java.sql.Date;
import java.sql.SQLException;

import Company.CompanyDBDAO;
import Coupon.Coupon;
import Coupon.CouponDBDAO;
import Coupon.CouponType;
import Custumer.Custumer;
import Custumer.CustumerDBDAO;



public class Test {

	public static void main(String[] args) throws SQLException {
		CouponType couponType = CouponType.FOOD;
		
CompanyDBDAO companyDBDAO = new CompanyDBDAO();

System.out.println(companyDBDAO.getCompany(11));
       
	}

}

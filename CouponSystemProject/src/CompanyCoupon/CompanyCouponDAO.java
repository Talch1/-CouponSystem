package CompanyCoupon;

import java.sql.SQLException;
import java.util.ArrayList;

import Coupon.Coupon;

public interface CompanyCouponDAO {

	// remove Company Coupon(company delete coupon)
	public void removeCompanyCoupon(Coupon coupon) throws InterruptedException;

	// Get coupon in Companys by id
	public CompanyCouponDBDAO getCompanyCoupon(int id) throws InterruptedException, SQLException;

	// get all coupons in Companys
	public ArrayList<CompanyCouponDBDAO> getAllCompanyCoupon() throws SQLException, InterruptedException;
	
	//delete all Companys coupon
	public void deletefromCompcoupByCompID(long id) throws SQLException, InterruptedException;
}

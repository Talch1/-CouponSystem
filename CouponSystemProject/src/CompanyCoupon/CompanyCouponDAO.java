package CompanyCoupon;

import java.sql.SQLException;
import java.util.ArrayList;

import Coupon.Coupon;

public interface CompanyCouponDAO {

	// remove Company Coupon(company delete coupon)
	public void removeCompanyCoupon(Coupon coupon) throws InterruptedException;

	// get all coupons in Companys
	public ArrayList<CompanyCouponDBDAO> getCompanyCoupon(long compid) throws InterruptedException, SQLException;

	// delete all Companys coupon
	public void deletefromCompcoupByCompID(long id) throws SQLException, InterruptedException;

	ArrayList<CompanyCouponDBDAO> getAllCompanyCoupon() throws SQLException, InterruptedException;
}

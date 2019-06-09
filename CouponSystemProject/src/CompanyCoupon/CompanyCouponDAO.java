package CompanyCoupon;

import java.sql.SQLException;
import java.util.ArrayList;

import Coupon.Coupon;
import Exeptions.SizeEx;

public interface CompanyCouponDAO {

	// remove Company Coupon(company delete coupon)
	public void removeCompanyCoupon(Coupon coupon) throws InterruptedException, SizeEx;

	// get all coupons in Companys
	public ArrayList<CompanyCouponDBDAO> getCompanyCoupon(long compid) throws InterruptedException, SQLException, SizeEx;

	// delete all Companys coupon
	public void deletefromCompcoupByCompID(long id) throws SQLException, InterruptedException, SizeEx;

	ArrayList<CompanyCouponDBDAO> getAllCompanyCoupon() throws SQLException, InterruptedException, SizeEx;
}

package CustomerCoupon;

import java.sql.SQLException;
import java.util.ArrayList;

import Coupon.Coupon;
import Customer.Customer;
import Exeptions.CouponException;
import Exeptions.SizeEx;

public interface CustomerCouponDAO {
	
	// Get table all Purchase Coupons By Customers ID
	public ArrayList<CustomerCouponDBDAO> getCustomerCouponByCustId(long l) throws SQLException, InterruptedException, SizeEx;

	// Customer buy Coupon
	public void buyCoupon(Coupon coupon, Customer custmer) throws CouponException, SQLException, InterruptedException, SizeEx;

	// Customer Delete coupon
	public void removeCustomerCoupon(Coupon coupon) throws SQLException, InterruptedException, SizeEx;

}

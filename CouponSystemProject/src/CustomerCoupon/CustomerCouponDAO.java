package CustomerCoupon;

import java.sql.SQLException;
import java.util.ArrayList;

import Coupon.Coupon;

public interface CustomerCouponDAO {
	// Get All Porches Coupons by Customers
	public ArrayList<CustomerCouponDBDAO> getAllCustomerCoupons() throws InterruptedException, SQLException;

	// Get table all Purchase Coupons By Customers ID
	public ArrayList<CustomerCouponDBDAO> getCustomerCoupon(long l) throws SQLException, InterruptedException;

	// Company create Coupon
	public void insert(long custId, long coupId) throws SQLException, InterruptedException;

	// Company Delete Coupon
	public void removeCustomerCoupon(Coupon coupon) throws SQLException, InterruptedException;

	// Get all customers and they coupons
	ArrayList<CustomerCouponDBDAO> getAllCustumerCoupons() throws SQLException, InterruptedException;

}

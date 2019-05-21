package CustomerCoupon;

import java.sql.SQLException;
import java.util.ArrayList;

import Coupon.Coupon;

public interface CustomerCouponDAO {

	public ArrayList<CustomerCouponDBDAO> getAllCustomerCoupons() throws InterruptedException, SQLException;

	public ArrayList<CustomerCouponDBDAO> getCustomerCoupon(long l) throws SQLException, InterruptedException;

	public void insert(long custId, long coupId) throws SQLException, InterruptedException;

	public void removeCustomerCoupon(Coupon coupon) throws SQLException, InterruptedException;

}

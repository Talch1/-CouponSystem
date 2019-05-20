package Coupon;

import java.sql.SQLException;
import java.util.Collection;

public interface CouponDAO {

	// create Coupon(insert to Coupon)
	public void createCoupon(Coupon coupon) throws SQLException, InterruptedException;

	// remove Coupon(delete from Coupon)
	public void removeCoupon(Coupon coupon) throws SQLException, InterruptedException;

	// update Coupon
	public void updateCoupon(Coupon coupon) throws SQLException, InterruptedException;

	// get All Coupons
	public Collection<Coupon> getAllCoupons() throws SQLException, InterruptedException;

	// get Coupon By Id
	public Coupon getCoupon(long id) throws SQLException, InterruptedException;

	// get Coupon by Type
	public Collection<Coupon> getCouponByType(CouponType type) throws SQLException, InterruptedException;

}

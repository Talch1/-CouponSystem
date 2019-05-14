package Coupon;

import java.sql.SQLException;
import java.util.Collection;

public interface CouponDAO {
	public void createCoupon(Coupon coupon) throws SQLException, InterruptedException;

	public void removeCoupon(Coupon coupon) throws SQLException, InterruptedException;

	public void updateCoupon(Coupon coupon) throws SQLException, InterruptedException;

	public Collection<Coupon> getAllCoupons() throws SQLException, InterruptedException;

	public Coupon getCoupon(long id) throws SQLException, InterruptedException;

	public Collection<Coupon> getCouponByType(CouponType type) throws SQLException, InterruptedException;

}

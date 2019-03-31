package Coupon;

import java.sql.SQLException;
import java.util.Collection;

public interface CouponDAO {
	public void createCoupon() throws SQLException;

	public void removeCoupon();

	public void updateCoupon();

	public Coupon getCustumer();

	public Collection<Coupon> getAllCustomer();

	public Collection<Coupon> getCoupon();

	public Collection<Coupon> getCouponByType();

}

package Coupon;

import java.util.Collection;

import Custumer.Custumer;

public interface CouponDAO {
	public void createCoupon();
	public void removeCoupon();
	public void updateCoupon();
	public Coupon getCustumer();
	public Collection<Coupon> getAllCustomer();
	public Collection<Coupon> getCoupon();
	public Collection<Coupon> getCouponByType();

}

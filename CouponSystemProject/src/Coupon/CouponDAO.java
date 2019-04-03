package Coupon;

import java.sql.SQLException;
import java.util.Collection;

public interface CouponDAO {
	public static void createCoupon() throws SQLException {
	}

	public static void removeCoupon() throws SQLException {
	}

	public static void updateCoupon() throws SQLException {
	};

	public Coupon getCustumer();

	public Collection<Coupon> getAllCustomer();

	public Collection<Coupon> getCoupon();

	public Collection<Coupon> getCouponByType();

}

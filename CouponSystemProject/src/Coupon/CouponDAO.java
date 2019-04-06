package Coupon;

import java.sql.SQLException;
import java.util.Collection;

public interface CouponDAO {
	public static void createCoupon(Coupon coupon) throws SQLException {
	}

	public static void removeCoupon(Coupon coupon) throws SQLException {
	}

	public static void updateCoupon(Coupon coupon) throws SQLException {
	};

	public Coupon getCustumer(long id);

	public Collection<Coupon> getAllCustomer();

	public Collection<Coupon> getCoupon();

	public Collection<Coupon> getCouponByType();

}

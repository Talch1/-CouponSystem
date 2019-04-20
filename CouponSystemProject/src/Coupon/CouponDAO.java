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


	public Collection<Coupon> getAllCoupons() throws SQLException;

	public Coupon getCoupon(int id) throws SQLException;

	public Collection<Coupon> getCouponByType() throws SQLException;

}

package Custumer;

import java.sql.SQLException;
import java.util.Collection;

import Coupon.Coupon;

public interface CustumerDAO {
	public static void createCustumer(Custumer custumer) throws SQLException {
	}

	public static void removeCustumer(Custumer custumer) throws SQLException {
	}

	public static void updateCustumer(Custumer custumer) throws SQLException {
	}

	public Custumer getCustumer(long id) throws SQLException;

	public Collection<Coupon> getAllCustomer();

	public Collection<Coupon> getCoupon();

	public boolean login();

}

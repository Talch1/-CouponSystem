package Custumer;

import java.sql.SQLException;
import java.util.Collection;

import Coupon.Coupon;

public interface CustumerDAO {
	public void createCustumer() throws SQLException;

	public void removeCustumer();

	public void updateCustumer();

	public Custumer getCustumer();

	public Collection<Coupon> getAllCustomer();

	public Collection<Coupon> getCoupon();

	public boolean login();

}

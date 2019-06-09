package Coupon;

import java.sql.SQLException;
import java.util.Collection;

import Exeptions.DateProblem;
import Exeptions.ExistEx;
import Exeptions.SizeEx;

public interface CouponDAO {

	// create Coupon(insert to Coupon)
	public void createCoupon(Coupon coupon) throws SQLException, InterruptedException, SizeEx;

	// remove Coupon(delete from Coupon)
	public void removeCoupon(Coupon coupon) throws SQLException, InterruptedException, ExistEx, DateProblem, SizeEx;

	// update Coupon
	public void updateCoupon(Coupon coupon) throws SQLException, InterruptedException, ExistEx, DateProblem, SizeEx;

	// get All Coupons
	public Collection<Coupon> getAllCoupons() throws SQLException, InterruptedException, DateProblem, SizeEx;

	// get Coupon By Id
	public Coupon getCoupon(long id) throws SQLException, InterruptedException, DateProblem, ExistEx, SizeEx;

	// get Coupon by Type
	public Collection<Coupon> getCouponByType(CouponType type) throws SQLException, InterruptedException, DateProblem, ExistEx, SizeEx;

}

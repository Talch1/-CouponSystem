package Facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import Coupon.Coupon;
import Coupon.CouponType;
import Customer.Customer;
import Customer.CustomerDBDAO;
import Utils.CouponPurchaise;
import Utils.CustumerCouponChek;
import CustumerCoupon.CustumerCouponDBDAO;
import DataBase.ClientType;
import Exeptions.*;

public class CustomerFacade implements CouponClientFasade {

	static CustomerDBDAO custumerDBDAO = new CustomerDBDAO();

	static CustumerCouponDBDAO custumerCouponDBDAO = new CustumerCouponDBDAO();

	public  void purchaseCoupon(Coupon coupon, Customer custumer) throws SQLException {

		CustumerCouponChek chek = new CustumerCouponChek();
		CouponPurchaise couponPurchaise = new CouponPurchaise();

		if ((chek.checkAmount(coupon) == true && chek.checkCustumerCouponByCouponId(custumer, coupon) == false)) {
         
	      couponPurchaise.insert(custumer.getId(), coupon.getId());
	      
		}

	}

	public static ArrayList<Coupon> getAllPurchoisedCoupons() throws SQLException {
		return CouponPurchaise.getAllpurchoiseCoupons();

	}

	public static ArrayList<Coupon> getAllPurchisedCouponsByType(CouponType type) throws SQLException {
		return CouponPurchaise.getAllPurchaiseCouponByType(type);
	}

	public static ArrayList<Coupon> getAllPurchisedCouponsByPrice(double price) throws SQLException {
		return CouponPurchaise.getAllPurchaiseCouponByPrice(price);

	}

	public  CouponClientFasade login(String name, String password, ClientType c) {
			

		if (custumerDBDAO.login(name, password)) {
			CustomerFacade customerFacade = new CustomerFacade();
			return customerFacade;
		}
	return null;

	}
}
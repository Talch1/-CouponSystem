package Facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import CompanyCoupon.CompanyCouponDBDAO;
import Coupon.Coupon;
import Coupon.CouponType;
import Customer.Customer;
import Customer.CustomerDBDAO;
import CustomerCoupon.CustomerCouponDBDAO;
import Utils.CouponPurchaise;
import Utils.CustumerCouponChek;
import DataBase.ClientType;
import Exeptions.*;

public class CustomerFacade implements CouponClientFasade {

	static CustomerDBDAO custumerDBDAO = new CustomerDBDAO();

	static CustomerCouponDBDAO custumerCouponDBDAO = new CustomerCouponDBDAO();

	public  void purchaseCoupon(Coupon coupon, Customer custumer) throws SQLException, InterruptedException {

		CustumerCouponChek chek = new CustumerCouponChek();
		CouponPurchaise couponPurchaise = new CouponPurchaise();

		if ((chek.checkAmount(coupon) == true && chek.checkCustomerCouponByCouponId(custumer, coupon) == false)) {
         
	      CompanyCouponDBDAO companyCouponDBDAO = new CompanyCouponDBDAO();
	      companyCouponDBDAO.insert(custumer.getId(), coupon.getId());
	      
		}

	}

	public static ArrayList<Coupon> getAllPurchoisedCoupons() throws SQLException, InterruptedException {
		return CouponPurchaise.getAllpurchoiseCoupons();

	}

	public static ArrayList<Coupon> getAllPurchisedCouponsByType(CouponType type) throws SQLException, InterruptedException {
		return CouponPurchaise.getAllPurchaiseCouponByType(type);
	}

	public static ArrayList<Coupon> getAllPurchisedCouponsByPrice(double price) throws SQLException, InterruptedException {
		return CouponPurchaise.getAllPurchaiseCouponByPrice(price);

	}

	public  CouponClientFasade login(String name, String password, ClientType c) throws InterruptedException {
			

		if (custumerDBDAO.login(name, password)) {
			CustomerFacade customerFacade = new CustomerFacade();
			return customerFacade;
		}
	return null;

	}
}
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

	 CustomerDBDAO custumerDBDAO = new CustomerDBDAO();

	 CustomerCouponDBDAO custumerCouponDBDAO = new CustomerCouponDBDAO();

	public  void purchaseCoupon(Coupon coupon, Customer custumer) throws SQLException, InterruptedException {

		CustumerCouponChek chek = new CustumerCouponChek();
	

		if ((chek.checkAmount(coupon) == true && chek.checkCustomerCouponByCouponId(custumer, coupon) == false)) {
         
	      CompanyCouponDBDAO companyCouponDBDAO = new CompanyCouponDBDAO();
	      companyCouponDBDAO.insert(custumer.getId(), coupon.getId());
	      
		}

	}

	public  ArrayList<Coupon> getAllPurchoisedCoupons() throws SQLException, InterruptedException {
		CouponPurchaise couponPurchaise = new CouponPurchaise();
		return couponPurchaise.getAllpurchoiseCoupons();

	}

	public  ArrayList<Coupon> getAllPurchisedCouponsByType(CouponType type) throws SQLException, InterruptedException {
		CouponPurchaise couponPurchaise = new CouponPurchaise();
		return couponPurchaise.getAllPurchaiseCouponByType(type);
	}

	public  ArrayList<Coupon> getAllPurchisedCouponsByPrice(double price) throws SQLException, InterruptedException {
		CouponPurchaise couponPurchaise = new CouponPurchaise();
		return couponPurchaise.getAllPurchaiseCouponByPrice(price);

	}

	public  CouponClientFasade login(String name, String password, ClientType c) throws InterruptedException {
			

		if (custumerDBDAO.login(name, password)) {
			CustomerFacade customerFacade = new CustomerFacade();
			return customerFacade;
		}
	return null;

	}
}
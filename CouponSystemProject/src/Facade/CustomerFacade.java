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
import DataBase.ClientType;
import Exeptions.*;

public class CustomerFacade implements CouponClientFasade {

	ClientType clientType = ClientType.Customer;

	public CustomerFacade(ClientType clientType) {

		this.clientType = clientType;
	}

	public CustomerFacade() {

	}

	public void purchaseCoupon(Coupon coupon, Customer custumer) throws SQLException, InterruptedException {

	//	boolean a = false;
	//	CustomerCouponDBDAO customerCouponDBDAO = new CustomerCouponDBDAO();
//
	//	ArrayList<CustomerCouponDBDAO> list = new ArrayList<>();
	//	list = customerCouponDBDAO.getCustomerCoupon(custumer.getId());
	//	for (int i = 0; i < list.size(); i++) {
	//		if (list.get(i).getCoupon_id() == coupon.getId()) {
	//			a = true;
	//		}
	//	}

	//	if ((coupon.getAmount() > 0) && a == true) {

	CustomerCouponDBDAO customerCouponDBDAO = new CustomerCouponDBDAO();
	customerCouponDBDAO.insert(custumer.getId(), coupon.getId());
		//}

	}

	public ArrayList<Coupon> getAllPurchoisedCoupons() throws SQLException, InterruptedException {
		CouponPurchaise couponPurchaise = new CouponPurchaise();
		return couponPurchaise.getAllpurchoiseCoupons();

	}

	public ArrayList<Coupon> getAllPurchisedCouponsByType(CouponType type) throws SQLException, InterruptedException {
		CouponPurchaise couponPurchaise = new CouponPurchaise();
		return couponPurchaise.getAllPurchaiseCouponByType(type);
	}

	public ArrayList<Coupon> getAllPurchisedCouponsByPrice(double price) throws SQLException, InterruptedException {
		CouponPurchaise couponPurchaise = new CouponPurchaise();
		return couponPurchaise.getAllPurchaiseCouponByPrice(price);

	}

	public CouponClientFasade login(String name, String password, ClientType c) throws InterruptedException {
		CustomerDBDAO customerDBDAO = new CustomerDBDAO();
		if (customerDBDAO.login(name, password)) {
			CustomerFacade customerFacade = new CustomerFacade();
			return customerFacade;
		}
		return null;

	}
}
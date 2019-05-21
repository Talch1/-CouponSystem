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

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	CustomerCouponDBDAO customerCouponDBDAO = new CustomerCouponDBDAO();
	customerCouponDBDAO.insert(custumer.getId(), coupon.getId());
	
	}

	public ArrayList<Coupon> getAllPurchoisedCoupons() throws SQLException, InterruptedException {
		CustomerCouponDBDAO customerCouponDBDAO = new CustomerCouponDBDAO();
		return customerCouponDBDAO.getAllpurchoiseCoupons();

	}

	public ArrayList<Coupon> getAllPurchisedCouponsByType(CouponType type) throws SQLException, InterruptedException {
		CustomerCouponDBDAO customerCouponDBDAO = new CustomerCouponDBDAO();
		return customerCouponDBDAO.getAllPurchaiseCouponByType(type);
	}

	public ArrayList<Coupon> getAllPurchisedCouponsByPrice(double price) throws SQLException, InterruptedException {
		CustomerCouponDBDAO customerCouponDBDAO = new CustomerCouponDBDAO();
		return customerCouponDBDAO.getAllPurchaiseCouponByPrice(price);

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
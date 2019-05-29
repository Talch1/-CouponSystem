package Facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

import Coupon.Coupon;
import Coupon.CouponDBDAO;
import Coupon.CouponType;
import Customer.Customer;
import Customer.CustomerDBDAO;
import CustomerCoupon.CustomerCouponDBDAO;
import DataBase.ClientType;
import Exeptions.CouponException;
import Exeptions.LoginEx;

public class CustomerFacade implements CouponClientFasade {

	public CustomerFacade() {

	}

	public void buyCoupon(long couponID)throws CouponException, SQLException, InterruptedException {
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		CustomerCouponDBDAO customerCouponDBDAO = new CustomerCouponDBDAO();
        Customer customer = new Customer();
        Coupon coupon=couponDBDAO.getCoupon(couponID);
        if (coupon.getAmount()<=0) throw new CouponException("No more coupons for you!!");
        ArrayList<Coupon> arrayList=this.getAllPurchoisedCoupons();
        for (Coupon curr:arrayList){
            if (curr.equals(coupon)){
                throw new CouponException("Costumer "+customer.getCustName()+" already have coupon "+coupon.getTitle());
            }
        }
       customerCouponDBDAO.buyCoupon(coupon,customer);
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

	public CouponClientFasade login(String name, String password, ClientType c) throws InterruptedException, LoginEx {
		CustomerDBDAO customerDBDAO = new CustomerDBDAO();
		if (customerDBDAO.login(name, password)) {
			CustomerFacade customerFacade = new CustomerFacade();
			return customerFacade;
		} else {
			throw new LoginEx("Invalid email or password");
		}

	}
}
package Facade;

import java.util.Collection;

import Company.Company;
import Coupon.Coupon;
import Coupon.CouponType;
import Custumer.Custumer;

public class AdminFacade implements CouponClientFasade {

	public static void createCompany(Company company) {

	}

	public static void rempveCompany(Company company) {

	}

	public static void updateCompany(Company company) {

	}

	public static Company getCompany(int id) {
		return null;

	}

	public static Collection<Company> getAllCompanyes() {
		return null;

	}
	public static void createCustumer(Custumer cust) {

	}

	public static void rempveCustumer(Custumer cust) {

	}

	public static void updateCustumer(Custumer cust) {

	}

	public static Custumer getCustumer(int id) {
		return null;

	}

	public static Collection<Company> getAllCustumers() {
		return null;

	}
	public static boolean login(String name,String password,String clientType) {
		return false;
	}


}
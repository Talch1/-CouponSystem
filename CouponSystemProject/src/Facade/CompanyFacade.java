package Facade;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import Company.Company;
import Company.CompanyDBDAO;
import CompanyCoupon.CompanyCouponDBDAO;
import Coupon.Coupon;
import Coupon.CouponDBDAO;
import Coupon.CouponType;
import CustomerCoupon.CustomerCouponDBDAO;
import DataBase.ClientType;
import Exeptions.ExistEx;
import Exeptions.LoginEx;

public class CompanyFacade implements CouponClientFasade {

	// Insert Coupon to Table
	public void createCoupon(Coupon coupon, Company company) throws SQLException, InterruptedException, ExistEx {

		CompanyCouponDBDAO companyCouponDBDAO = new CompanyCouponDBDAO();
		ArrayList<Coupon> allCoup = new ArrayList<>();
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		boolean chek = false;
		allCoup = couponDBDAO.getAllCoupons();
		for (Coupon coupon2 : allCoup) {
			if (coupon2.getTitle().equals(coupon.getTitle())) {
				chek = true;
			}
		}
		if (chek == true) {
			throw new ExistEx("Title whis this name exist");
		}
		couponDBDAO.createCoupon(coupon);
		companyCouponDBDAO.companyCreateCoupon(company.getId(), coupon.getId());

	}

	// Delete Coupon from Table
	public void removeCoupon(Coupon coupon) throws SQLException, InterruptedException {
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		CustomerCouponDBDAO customerCouponDBDAO = new CustomerCouponDBDAO();
		couponDBDAO.removeCoupon(coupon);
		customerCouponDBDAO.deletefromCustcoup(coupon.getId());
	}

	// Update Coupon
	public void updateCoupon(Coupon coupon) throws SQLException, InterruptedException {
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		couponDBDAO.updateCoupon(coupon);

	}

	// Get Coupon by id
	public Coupon getCoupon(int id) throws SQLException, InterruptedException {
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		return couponDBDAO.getCoupon(id);
	}

	// Get All Coupons
	public ArrayList<Coupon> getAllCoupons() throws SQLException, InterruptedException {
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		return couponDBDAO.getAllCoupons();

	}

	// Get All Coupons By Type
	public ArrayList<Coupon> getCouponByType(CouponType type) throws SQLException, InterruptedException {
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		return couponDBDAO.getCouponByType(type);

	}

	// Get All Coupons By Price
	public ArrayList<Coupon> getCouponByPrice(double price) throws SQLException, InterruptedException {
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		return couponDBDAO.getCouponByPrice(price);

	}

	// Get All Coupon Before Date
	public ArrayList<Coupon> getCouponByDate(Date date) throws SQLException, InterruptedException {
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		return couponDBDAO.getCouponByDate(date);

	}

	// Login to CompanyFacade
	public CouponClientFasade login(String name, String password, ClientType c) throws InterruptedException, LoginEx {
		CompanyDBDAO companyDBDAO = new CompanyDBDAO();
		{
			if (companyDBDAO.login(name, password)) {
				CompanyFacade companyFacade = new CompanyFacade();
				return companyFacade;
			} else {
				throw new LoginEx("Invalid email or password");
			}

		}
	}
}

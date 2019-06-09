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
import Exeptions.DateProblem;
import Exeptions.ExistEx;
import Exeptions.LoginEx;
import Exeptions.SizeEx;

public class CompanyFacade implements CouponClientFasade {

	// Insert Coupon to Table
	public void createCoupon(Coupon coupon, Company company) throws SQLException, InterruptedException, ExistEx, DateProblem, SizeEx {

		CompanyCouponDBDAO companyCouponDBDAO = new CompanyCouponDBDAO();
		ArrayList<Coupon> allCoup = new ArrayList<>();
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		
		allCoup = couponDBDAO.getAllCoupons();
		for (Coupon coupon2 : allCoup) {
			if (coupon.getTitle().equals(coupon2.getTitle())) {
				throw new ExistEx("Title whis this name exist");
			}
		}
		couponDBDAO.createCoupon(coupon);
		companyCouponDBDAO.companyCreateCoupon(company.getId(), coupon.getId());

	}

	// Delete Coupon from Table
	public void removeCoupon(Coupon coupon) throws SQLException, InterruptedException, ExistEx, DateProblem, SizeEx {
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		CompanyCouponDBDAO companyCouponDBDAO = new CompanyCouponDBDAO();
		companyCouponDBDAO.removeCompanyCoupon(coupon);
		couponDBDAO.removeCoupon(coupon);
	}

	// Update Coupon
	public void updateCoupon(Coupon coupon) throws SQLException, InterruptedException, ExistEx, DateProblem, SizeEx {
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		couponDBDAO.updateCoupon(coupon);

	}

	// Get Coupon by id
	public Coupon getCoupon(int id) throws SQLException, InterruptedException, DateProblem, ExistEx, SizeEx {
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		return couponDBDAO.getCoupon(id);
	}

	// Get All Coupons
	public ArrayList<Coupon> getAllCoupons(Company company) throws SQLException, InterruptedException, DateProblem, ExistEx, SizeEx {
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		CompanyCouponDBDAO companyCouponDBDAO = new CompanyCouponDBDAO();
		ArrayList<Coupon> coupons = new ArrayList<>();
		ArrayList<CompanyCouponDBDAO> companyCouponDBDAOs = companyCouponDBDAO.getCompanyCoupon(company.getId());
		for (CompanyCouponDBDAO companyCouponDBDAO2 : companyCouponDBDAOs) {
			coupons.add(couponDBDAO.getCoupon(companyCouponDBDAO2.getCouponId()));
		}
		return coupons;

	}

	// Get All Coupons By Type
	public ArrayList<Coupon> getCouponByType(CouponType type) throws SQLException, InterruptedException, DateProblem, ExistEx, SizeEx {
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		return couponDBDAO.getCouponByType(type);

	}

	// Get All Coupons By Price
	public ArrayList<Coupon> getCouponByPrice(double price) throws SQLException, InterruptedException, DateProblem, ExistEx {
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		
		try {
			return couponDBDAO.getCouponByPrice(price);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	// Get All Coupon Before Date
	public ArrayList<Coupon> getCouponByDate(Date date) throws SQLException, InterruptedException, DateProblem, ExistEx {
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		try {
			return couponDBDAO.getCouponByDate(date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	// Login to CompanyFacade
	public CouponClientFasade login(String name, String password, ClientType c) throws InterruptedException, LoginEx, SizeEx {
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

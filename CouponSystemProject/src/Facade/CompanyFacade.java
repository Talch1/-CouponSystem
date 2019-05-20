package Facade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import Exeptions.*;
import Utils.CouponPurchaise;
import Company.CompanyDBDAO;
import Coupon.Coupon;
import Coupon.CouponDBDAO;
import Coupon.CouponType;
import DataBase.ClientType;

public class CompanyFacade implements CouponClientFasade {

	ClientType clientType =ClientType.Company;
	public CompanyFacade(ClientType clientType) {

		this.clientType = clientType;
	}

	public CompanyFacade() {
	
	}

	public void createCoupon(Coupon coupon) throws SQLException, InterruptedException {

		int count = 0;
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		ArrayList<Coupon> coupons = couponDBDAO.getAllCoupons();
		for (int i = 0; i < coupons.size(); i++) {
			if (coupons.get(i).getTitle().equals(coupon.getTitle())) {
				count++;
			}
		}
		if (count == 0) {
			couponDBDAO.createCoupon(coupon);
		} else {
			System.out.println("TITELE DUPLICATE");
			/// eXEPTION
		}
	}

	public void removeCoupon(Coupon coupon) throws SQLException, InterruptedException {
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		CouponPurchaise couponPurchaise = new CouponPurchaise();
		couponDBDAO.removeCoupon(coupon);
		couponPurchaise.deletefromCustcoup(coupon.getId());
	}

	public void updateCoupon(Coupon coupon) throws SQLException, InterruptedException {
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		couponDBDAO.updateCoupon(coupon);

	}

	public Coupon getCoupon(int id) throws SQLException, InterruptedException {
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		return couponDBDAO.getCoupon(id);
	}

	public Collection<Coupon> getAllCoupons() throws SQLException, InterruptedException {
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		return couponDBDAO.getAllCoupons();

	}

	public Collection<Coupon> getCouponByType(CouponType type) throws SQLException, InterruptedException {
		CouponDBDAO couponDBDAO = new CouponDBDAO();
		return couponDBDAO.getCouponByType(type);

	}

	public CouponClientFasade login(String name, String password, ClientType c) throws InterruptedException {
		CompanyDBDAO companyDBDAO = new CompanyDBDAO();
		{
			if (companyDBDAO.login(name, password)) {
				CompanyFacade companyFacade = new CompanyFacade();
				return companyFacade;
			}
			return null;

		}
	}
}

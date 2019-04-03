package Company;

import java.sql.SQLException;
import java.util.Collection;

import Coupon.Coupon;

public interface CompanyDAO {
	public static void createCompany() throws SQLException {
	}

	public static void removeCompany() throws SQLException {
	}

	public static void updateCompany() {
	}

	public  Company getCompany();

	public Collection<Company> getAllCompany();

	public Collection<Coupon> getCoupon();

	public boolean login();

}

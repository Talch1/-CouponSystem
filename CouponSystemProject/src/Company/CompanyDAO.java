package Company;

import java.sql.SQLException;
import java.util.Collection;

import Coupon.Coupon;

public interface CompanyDAO {
	public static void createCompany(Company company) throws SQLException {
	}

	public static void removeCompany(Company company) throws SQLException {
	}

	public static void updateCompany(Company company) throws SQLException {
	}

	public Company getCompany(long id) throws SQLException;

	public Collection<Company> getAllCompany() throws SQLException;

	public Collection<Coupon> getCoupon();

	public boolean login();

}

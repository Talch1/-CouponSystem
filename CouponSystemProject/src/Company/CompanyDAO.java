package Company;

import java.sql.SQLException;
import java.util.Collection;

import Coupon.Coupon;

public interface CompanyDAO {
	public void createCompany() throws SQLException;

	public void removeCompany();

	public void updateCompany();

	public Company getCompany();

	public Collection<Company> getAllCompany();

	public Collection<Coupon> getCoupon();

	public boolean login();

}

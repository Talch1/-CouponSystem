package Company;

import java.sql.SQLException;
import java.util.Collection;

import Coupon.Coupon;

public interface CompanyDAO {
	public void createCompany(Company company) throws SQLException, InterruptedException;

	public void removeCompany(Company company) throws SQLException, InterruptedException;

	public void updateCompany(Company company) throws SQLException, InterruptedException;

	public Company getCompany(long id) throws SQLException, InterruptedException;

	public Collection<Company> getAllCompany() throws SQLException, InterruptedException;

	public Collection<Coupon> getCoupons() throws SQLException, InterruptedException;

	public boolean login(String compname, String pass) throws SQLException, InterruptedException;

}

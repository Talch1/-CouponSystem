package Company;

import java.sql.SQLException;
import java.util.Collection;

import Coupon.Coupon;
import Exeptions.ConectionExeption;

public interface CompanyDAO {
	public void createCompany(Company company) throws SQLException ;

	public void removeCompany(Company company) throws SQLException ;

	public void updateCompany(Company company) throws SQLException ;

	public Company getCompany(long id) throws SQLException;

	public Collection<Company> getAllCompany() throws SQLException;

	public Collection<Coupon> getCoupon();


	public boolean login(String compname, String pass);

}

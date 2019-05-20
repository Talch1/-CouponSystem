/*
 * 
 */
package Company;

import java.sql.SQLException;
import java.util.Collection;

import Coupon.Coupon;


public interface CompanyDAO {
	
	//createCompany(insert to Company)
	public void createCompany(Company company) throws SQLException, InterruptedException;

	//removeCompany(delete from Company)
	public void removeCompany(Company company) throws SQLException, InterruptedException;

	//updateCompany(update Company)
	public void updateCompany(Company company) throws SQLException, InterruptedException;

	//getCompany when id is
	public Company getCompany(long id) throws SQLException, InterruptedException;

	// get all Companys to Arraylist
	public Collection<Company> getAllCompany() throws SQLException, InterruptedException;

	// get all Coupons of this Company
	public Collection<Coupon> getCoupons(Company company) throws SQLException, InterruptedException;

	//login to Company
	public boolean login(String compname, String pass) throws SQLException, InterruptedException;

}

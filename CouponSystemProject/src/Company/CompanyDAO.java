
package Company;

import java.sql.SQLException;
import java.util.Collection;

import Coupon.Coupon;
import Exeptions.DateProblem;
import Exeptions.ExistEx;
import Exeptions.SizeEx;


public interface CompanyDAO {
	
	//createCompany(insert to Company)
	public void createCompany(Company company) throws SQLException, InterruptedException, SizeEx;

	//removeCompany(delete from Company)
	public void removeCompany(Company company) throws SQLException, InterruptedException, ExistEx, SizeEx;

	//updateCompany(update Company)
	public void updateCompany(Company company) throws SQLException, InterruptedException, ExistEx, SizeEx;

	//getCompany when id is
	public Company getCompany(long id) throws SQLException, InterruptedException, ExistEx, SizeEx;

	// get all Company's 
	public Collection<Company> getAllCompany() throws SQLException, InterruptedException, SizeEx;

	// get all Coupons of this Company
	public Collection<Coupon> getCoupons(Company company) throws SQLException, InterruptedException, DateProblem, ExistEx, SizeEx;

	//login to Company
	public boolean login(String compname, String pass) throws SQLException, InterruptedException, SizeEx;

}

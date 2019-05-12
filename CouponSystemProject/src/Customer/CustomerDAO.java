package Customer;

import java.sql.SQLException;
import java.util.Collection;

import Company.Company;
import Coupon.Coupon;

public interface CustomerDAO {
	public static void createCustumer(Customer custumer) throws SQLException {
	}

	public static void removeCustumer(Customer custumer) throws SQLException {
	}

	public static void updateCustumer(Customer custumer) throws SQLException {
	}

	public Customer getCustomer(long id) throws SQLException, InterruptedException;

	public Collection<Customer> getAllCustomer() throws SQLException, InterruptedException;

	public Collection<Coupon> getCoupons();

	public boolean login(String custName, String password) throws InterruptedException;
	


}

package Customer;

import java.sql.SQLException;
import java.util.Collection;

import Coupon.Coupon;

public interface CustomerDAO {
	
	// create Customer(insert to Customer)
	public void createCustomer(Customer customer) throws SQLException, InterruptedException;

	//delete Customer (delete from Customer)
	public void removeCustomer(Customer customer) throws SQLException, InterruptedException;

	//update Customer(update Customer)
	public void updateCustomer(Customer customer) throws SQLException, InterruptedException;

	//get Customer By Id
	public Customer getCustomer(long id) throws SQLException, InterruptedException;

	//get All Customers
	public Collection<Customer> getAllCustomer() throws SQLException, InterruptedException;

	//get All Coupons by Customer
	public Collection<Coupon> getCoupons(Customer customer) throws SQLException, InterruptedException;

	//Login to Customer
	public boolean login(String custName, String password) throws InterruptedException;

}

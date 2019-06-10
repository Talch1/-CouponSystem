package Customer;

import java.sql.Connection;
import java.util.ArrayList;

import Coupon.Coupon;

public class Customer {
	// Data members
	private long id;
	private String custName;
	private String password;
	private ArrayList<Coupon> coupons;

	// Constructor
	public Customer(int id, String custName, String password, ArrayList<Coupon> coupons) {

		setId(id);
		setCustName(custName);
		setPassword(password);
		setCoupons(coupons);
	}
	public Customer() {
	
	}
	
//getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(ArrayList<Coupon> coupons) {
		this.coupons = coupons;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", custName=" + custName + ", password=" + password + ", coupons=" + coupons
				+ "]";
	}
	

}

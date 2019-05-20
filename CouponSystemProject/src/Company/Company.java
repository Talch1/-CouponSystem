package Company;

import java.util.ArrayList;

import Coupon.Coupon;

public class Company {

	//Data members
	private long id;

	private String compName;

	private String password;

	private String email;

	private ArrayList<Coupon> cupons;

	//Constructor
	public Company(long id, String compName, String password, String eamil, ArrayList<Coupon> cupons) {

		setId(id);
		setCompName(compName);
		setPassword(password);
		setEmail(eamil);
		setCupons(cupons);
	}
        //Getters,Setters
	public Company() {
	
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String eamil) {
		this.email = eamil;
	}

	public ArrayList<Coupon> getCupons() {
		return cupons;
	}

	public void setCupons(ArrayList<Coupon> cupons) {
		this.cupons = cupons;
	}

	//ToString
	@Override
	public String toString() {
		return "Company [id=" + id + ", compName=" + compName + ", password=" + password + ", email=" + email
				+ ", cupons=" + cupons + "]";
	}

}

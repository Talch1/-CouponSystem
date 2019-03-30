package Company;

import java.util.ArrayList;

import Coupon.Coupon;

public class Company {
	long id;
	String compName;
	String password;
	String eamil;
	ArrayList<Coupon> cupons;

	public Company(long id, String compName, String password, String eamil, ArrayList<Coupon> cupons) {

		setId(id);
		setCompName(compName);
		setPassword(password);
		setEamil(eamil);
		setCupons(cupons);
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

	public String getEamil() {
		return eamil;
	}

	public void setEamil(String eamil) {
		this.eamil = eamil;
	}

	public ArrayList<Coupon> getCupons() {
		return cupons;
	}

	public void setCupons(ArrayList<Coupon> cupons) {
		this.cupons = cupons;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", compName=" + compName + ", password=" + password + ", eamil=" + eamil
				+ ", cupons=" + cupons + "]";
	}

}

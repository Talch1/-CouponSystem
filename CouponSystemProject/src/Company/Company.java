package Company;

import java.util.ArrayList;

import Coupon.Coupon;

public class Company {
	private static  long id;
	private static String compName;
	private static String password;
	private static String eamil;
	private ArrayList<Coupon> cupons;

	public Company(long id, String compName, String password, String eamil, ArrayList<Coupon> cupons) {

		setId(id);
		setCompName(compName);
		setPassword(password);
		setEamil(eamil);
		setCupons(cupons);
	}

	public static long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public static String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public static String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static String getEamil() {
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

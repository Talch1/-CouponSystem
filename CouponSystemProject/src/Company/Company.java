package Company;

import java.util.ArrayList;

import Coupon.Coupon;


/**
 * The Class Company.
 */
public class Company {
	
	/** The id. */
	private long id;
	
	/** The comp name. */
	private String compName;
	
	/** The password. */
	private String password;
	
	/** The email. */
	private String email;
	
	/** The cupons. */
	private ArrayList<Coupon> cupons;

	/**
	 * Instantiates a new company.
	 *
	 * @param id the id
	 * @param compName the comp name
	 * @param password the password
	 * @param eamil the email
	 * @param cupons the cupons
	 */
	public Company(long id, String compName, String password, String eamil, ArrayList<Coupon> cupons) {

		setId(id);
		setCompName(compName);
		setPassword(password);
		setEmail(eamil);
		setCupons(cupons);
	}

	/**
	 * Instantiates a new company.
	 */
	public Company() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Gets the comp name.
	 *
	 * @return the comp name
	 */
	public String getCompName() {
		return compName;
	}

	/**
	 * Sets the comp name.
	 *
	 * @param compName the new comp name
	 */
	public void setCompName(String compName) {
		this.compName = compName;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param eamil the new eamil
	 */
	public void setEmail(String eamil) {
		this.email = eamil;
	}

	/**
	 * Gets the cupons.
	 *
	 * @return the cupons
	 */
	public ArrayList<Coupon> getCupons() {
		return cupons;
	}

	/**
	 * Sets the cupons.
	 *
	 * @param cupons the new cupons
	 */
	public void setCupons(ArrayList<Coupon> cupons) {
		this.cupons = cupons;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Company [id=" + id + ", compName=" + compName + ", password=" + password + ", email=" + email
				+ ", cupons=" + cupons + "]";
	}

}

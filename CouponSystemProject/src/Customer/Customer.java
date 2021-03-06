package Customer;

import java.sql.Connection;
import java.util.ArrayList;

public class Customer {
	// Data members
	private long id;
	private String custName;
	private String password;
	private ArrayList<Connection> connections;

	// Constructor
	public Customer(int id, String custName, String password, ArrayList<Connection> connections) {

		setId(id);
		setCustName(custName);
		setPassword(password);
		setConnections(connections);
	}

	public Customer() {

	}

	// Getters and Setters
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

	public ArrayList<Connection> getConnections() {
		return connections;
	}

	public void setConnections(ArrayList<Connection> connections) {
		this.connections = connections;
	}

	// ToString
	@Override
	public String toString() {
		return "Custumer [id=" + id + ", custName=" + custName + ", password=" + password + ", connections="
				+ connections + "]";
	}

}

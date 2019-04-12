package DataBase;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import Company.Company;
import Company.CompanyDBDAO;
import Custumer.Custumer;
import Custumer.CustumerDBDAO;



public class Test {

	

	public static void main(String[] args) throws SQLException {
		Database.createCoupon();
		Company company = new Company(6, "KJHGF", "jkhg", "jgf",null);
		CompanyDBDAO.createCompany(company);
	
	}
	
	
		
	}




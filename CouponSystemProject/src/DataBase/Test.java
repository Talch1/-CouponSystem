package DataBase;

import java.sql.SQLException;

import Company.Company;
import Company.CompanyDBDAO;

public class Test {

	public static void main(String[] args) throws SQLException {
		Database.createAllTables();
		CompanyDBDAO.createCompany();
	}


}

package DataBase;


import java.sql.SQLException;


import Company.CompanyDBDAO;



public class Test {

	static int id = 2;


	public static void main(String[] args) throws SQLException {
		CompanyDBDAO.updateCompanyEmail("talch", 55);
	
		
	}


}

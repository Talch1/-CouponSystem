package DataBase;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import Custumer.Custumer;
import Custumer.CustumerDBDAO;



public class Test {

	

	public static void main(String[] args) throws SQLException {
		
		
	CustumerDBDAO.updateCompanyName(new Custumer(2554, "dima", "52135", (ArrayList<Connection>) ConnectionPool.connection));
	
	}
	
	
		
	}




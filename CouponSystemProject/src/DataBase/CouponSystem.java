package DataBase;

import java.sql.SQLException;

import Exeptions.LoginEx;
import Facade.AdminFacade;
import Facade.CompanyFacade;
import Facade.CouponClientFasade;
import Facade.CustomerFacade;

public class CouponSystem {

	// Singleton
	private static CouponSystem instanse = new CouponSystem();
	Thread thread = new Thread(new DailyCouponExpirationTask());
	Database database = new Database();

	// Constructor
	private CouponSystem() {

		try {
			database.createAllTables();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		thread.start();

	}

	// Get instance
	public static CouponSystem getInstanse() {
		return instanse;
	}

	// Stop Thread and return all connections to blockingQueue
	public void shutdown() {
		DailyCouponExpirationTask.stopp();
		ConnectionPool.getInstance().removeAllConnections();
	}

	// Login to Facades
	public CouponClientFasade login(String name, String password, ClientType clientType)
			throws LoginEx, InterruptedException {
		AdminFacade adminFacade = new AdminFacade();
		CompanyFacade companyFacade = new CompanyFacade();
		CustomerFacade customerFacade = new CustomerFacade();
		if (clientType.name().equals("Admin")) {

			return adminFacade.login(name, password, clientType);

		} else if (clientType.name().equals("Company")) {
			return companyFacade.login(name, password, clientType);
		} else if (clientType.name().equals("Customer")) {
			return customerFacade.login(name, password, clientType);
		}
		return null;
	}
}

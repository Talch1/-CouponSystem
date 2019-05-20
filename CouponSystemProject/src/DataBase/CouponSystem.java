package DataBase;

import java.sql.SQLException;

import Facade.AdminFacade;
import Facade.CompanyFacade;
import Facade.CouponClientFasade;
import Facade.CustomerFacade;

public class CouponSystem {

	private static CouponSystem instanse = new CouponSystem();
	Thread thread = new Thread(new DailyCouponExpirationTask());
	Database database = new Database();

	private CouponSystem() {

		try {

			database.createAllTables();

		} catch (InterruptedException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		thread.start();

	}

	public static CouponSystem getInstanse() {
		return instanse;
	}

	public void shutdown() {
		DailyCouponExpirationTask.stopp();
	}

	public CouponClientFasade login(String name, String password, ClientType clientType) throws InterruptedException {
		AdminFacade adminFacade = new AdminFacade();
		CompanyFacade companyFacade = new CompanyFacade();
		CustomerFacade customerFacade = new CustomerFacade();
		if (clientType.name().equals("Admin")) {

			return adminFacade.login(name, password, clientType);

		} else if (clientType.name().equals("Company")) {
			return  companyFacade.login(name, password, clientType);
		} else if (clientType.name().equals("Customer")) {
			return  customerFacade.login(name, password, clientType);
		}
		return null;
	}
}

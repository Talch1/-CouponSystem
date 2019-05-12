package DataBase;

import java.sql.SQLException;

import Facade.AdminFacade;
import Facade.CompanyFacade;
import Facade.CouponClientFasade;
import Facade.CustomerFacade;

public class CouponSystem {

	private static CouponSystem instanse = new CouponSystem();
	Thread thread = new Thread(new DailyCouponExpirationTask());

	private CouponSystem() {

		try {

			Database.createAllTables();

		} catch (InterruptedException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		thread.start();

	}

	public CouponSystem getInstanse() {
		return instanse;
	}

	public void shutdown() {
		DailyCouponExpirationTask.stopp();
	}

	public CouponClientFasade login(String name, String password, ClientType clientType) throws InterruptedException {
		if (clientType.name().equals("Admin")) {

			return new AdminFacade().login(name, password, clientType);

		} else if (clientType.name().equals("Company")) {
			return new CompanyFacade().login(name, password, clientType);
		} else if (clientType.name().equals("Customer")) {
			return new CustomerFacade().login(name, password, clientType);
		}
		return null;
	}
}

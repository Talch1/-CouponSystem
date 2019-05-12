package Facade;

import DataBase.ClientType;

public interface CouponClientFasade {

	public CouponClientFasade login(String name, String password, ClientType c);
}

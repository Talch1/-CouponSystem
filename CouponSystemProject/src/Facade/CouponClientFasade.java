package Facade;


public interface CouponClientFasade {

	public static CouponClientFasade login(String name,String password,CouponClientFasade clientFasade) {
		return clientFasade;
		
	}
}

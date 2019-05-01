package DataBase;

import java.io.IOException;
import java.nio.CharBuffer;

import Coupon.CouponDBDAO;

public class DailyCouponExpirationTask implements Readable{

	CouponDBDAO couponDBDAO = new CouponDBDAO();
	@Override
	public int read(CharBuffer cb) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

}

package CustumerCoupon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import CompanyCoupon.CompanyCouponDBDAO;
import Coupon.Coupon;
import DataBase.Database;



public class CustumerCouponDBDAO implements CustumerCouponDAO {
	
	private long cust_id;
	private long coupon_id;

	public long getCust_id() {
		return cust_id;
	}

	public void setCust_id(long cust_id) {
		this.cust_id = cust_id;
	}

	public long getCoupon_id() {
		return coupon_id;
	}

	public void setCoupon_id(long coupon_id) {
		this.coupon_id = coupon_id;
	}

	public static void CreateJoinCustumer_Coupon() throws SQLException {
		Connection connection=null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/new?autoReconnect=true&useSSL=false", "Talch", "root");
			String sql = "create table JOIN_custumer_COUPON  " + "(Cust_ID Bigint not null, "
					+ "COUPON_ID Bigint NOT NULL, FOREIGN KEY(Cust_ID) REFERENCES Custumer(ID), FOREIGN KEY(CUST_ID) REFERENCES Coupon(ID) ," + " PRIMARY KEY (CUST_ID, COUPON_ID) ) ";
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		System.out.println("Created table Costumer_Coupon");
	}
	
	
	
	
	public static void removeJoinCustumer_Coupon(Coupon coupon) {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "delete from  JoinCustumer_Coupon where COUPON_ID = ?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			preparedStatement.setLong(1, coupon.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("deleted from table JoinCustumer_Coupon");

	
	}

	public static CustumerCouponDBDAO getJoinCustumer_Coupon(int id) {
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CustumerCouponDBDAO custumerCouponDBDAO = new CustumerCouponDBDAO();
		Statement stm;
		try {
			stm = connection.createStatement();

			String sql = "SELECT * FROM join_company_coupon WHERE COUPON_ID = " + id;
			ResultSet rs = stm.executeQuery(sql);
			rs.next();

			custumerCouponDBDAO.setCust_id(rs.getLong(1));
			custumerCouponDBDAO.setCoupon_id(rs.getLong(2));
	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return custumerCouponDBDAO;

	}

	}
	

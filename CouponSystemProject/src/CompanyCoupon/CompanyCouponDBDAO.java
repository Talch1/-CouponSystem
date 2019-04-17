package CompanyCoupon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Coupon.Coupon;
import DataBase.Database;

public class CompanyCouponDBDAO implements CompanyCouponDAO {

	private long comp_id;
	private long coupon_id;

	public long getComp_id() {
		return comp_id;
	}

	public void setComp_id(long comp_id) {
		this.comp_id = comp_id;
	}

	public long getCoupon_id() {
		return coupon_id;
	}

	public void setCoupon_id(long coupon_id) {
		this.coupon_id = coupon_id;
	}

	// Create table company coupon
	public static void CreateJoinCompany_Coupon() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "create table JOIN_COMPANY_COUPON  " + "(COMP_ID Bigint not null, "
				+ "COUPON_ID Bigint NOT NULL, FOREIGN KEY(COMP_ID) REFERENCES Company(ID), FOREIGN KEY(COUPON_ID) REFERENCES Coupon(ID) ,"
				+ " PRIMARY KEY (COMP_ID, COUPON_ID) ) ";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Created table Company_Coupon");
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void removeJoinCompany_Coupon(Coupon coupon) {

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "delete from  JoinCompany_Coupon where COUPON_ID = ?";
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
		System.out.println("deleted from table JoinCompany_Coupon");

	}

	public static CompanyCouponDBDAO getJoinCompany_Coupon(int id) {

		Connection connection = null;

		try {
			connection = DriverManager.getConnection(Database.getSql(), Database.getUser(), Database.getPasword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CompanyCouponDBDAO companyCouponDBDAO = new CompanyCouponDBDAO();
		Statement stm;
		try {
			stm = connection.createStatement();

			String sql = "SELECT * FROM join_company_coupon WHERE COUPON_ID = " + id;
			ResultSet rs = stm.executeQuery(sql);
			rs.next();

			companyCouponDBDAO.setComp_id(rs.getLong(1));
			companyCouponDBDAO.setCoupon_id(rs.getLong(2));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return companyCouponDBDAO;

	}

	@Override
	public String toString() {
		return "CompanyCouponDBDAO [comp_id=" + comp_id + ", coupon_id=" + coupon_id + "]";
	}

}

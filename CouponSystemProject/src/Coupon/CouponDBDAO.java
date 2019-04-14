package Coupon;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import DataBase.Database;

public class CouponDBDAO implements CouponDAO {

	// insert coupon to table
	public static void createCoupon(Coupon coupon) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());

		String query = " insert into coupon (id ,title ,START_DATE , END_DATE, amount ,type , message , price, image)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ? ,?)";

		// create the mysql insert preparedstatement
		PreparedStatement preparedStmt = connection.prepareStatement(query);
		preparedStmt.setLong(1, coupon.getId());
		preparedStmt.setString(2, coupon.getTitle());
		preparedStmt.setDate(3, coupon.getStartDate());
		preparedStmt.setDate(4, coupon.getEndDate());
		preparedStmt.setDouble(5, coupon.getAmount());
		String type = coupon.getType().toString();

		preparedStmt.setString(6, type);
		preparedStmt.setString(7, coupon.getMessage());
		preparedStmt.setDouble(8, coupon.getPrice());
		preparedStmt.setString(9, coupon.getImage());

		// execute the preparedstatement
		preparedStmt.execute();
		System.out.println(" Coupon created");

		connection.close();
	}

	public static void removeCoupon(Coupon coupon) throws SQLException {
		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql = "delete from  Coupon where id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setLong(1, coupon.getId());
		preparedStatement.executeUpdate();
		System.out.println("deleted from Coupon");

	}

	public static void updateCoupon(Coupon coupon) throws SQLException {

		Connection connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
				Database.getPasword());
		String sql = "update coupon set TITLE = ?, START_DATE =  ?,END_DATE = ? ,amount = ?,type = ?,price = ?, image = ?  where id =  ?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.executeUpdate();
		System.out.println("Coupon Updated");

	}

	@Override
	public Collection<Coupon> getAllCoupons() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coupon getCoupon(int id) {

 		Connection connection = null;

 	
			try {
				connection = DriverManager.getConnection(Database.getSql(), Database.getUser(),
						Database.getPasword());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
				Coupon coupon = new Coupon();
				Statement stm;
				try {
					stm = connection.createStatement();
				
					String sql = "SELECT * FROM coupon WHERE ID=" + id;
					ResultSet rs = stm.executeQuery(sql);
					rs.next();
					coupon.setId(rs.getLong(1));
					coupon.setTitle(rs.getString(2));
				    coupon.setStartDate(rs.getDate(3));
                    coupon.setEndDate(rs.getDate(4));
                    coupon.setAmount(rs.getInt(5));
			
				
			String returnType = rs.getString(6);
			switch (rs.getString(6)) {
			
			case "Food":
				coupon.setType(CouponType.FOOD);
				break;

			
			case "RESTURANS":
				coupon.setType(CouponType.RESTURANS);
				break;

			
			case "ELECTRICITY":
				coupon.setType(CouponType.ELECTRICITY);
				break;

			
			case "HEALTH":
				coupon.setType(CouponType.HEALTH);
				break;
				
			case "SPORTS":
				coupon.setType(CouponType.SPORTS);
				break;

			case "CAMPING":
				coupon.setType(CouponType.CAMPING);
				break;
				
			case "TRAVELLING":
				coupon.setType(CouponType.TRAVELLING);
				break;
			default:
				break;
 	}
			coupon.setMessage(rs.getString(7));
			coupon.setPrice(rs.getDouble(8));
			coupon.setImage(rs.getString(9));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return coupon;
 		}
	

	@Override
	public Collection<Coupon> getCouponByType() {
		// TODO Auto-generated method stub
		return null;
	}

}

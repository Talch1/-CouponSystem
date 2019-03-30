package Coupon;

import java.awt.Window.Type;
import java.sql.Date;

public class Coupon {
	
	int id;
	String title;
	Date startDate;
	Date endDate;
	int amount;
	String CouponTipe ;
	String message;
	double price;
	String immage;
	public Coupon(int id, String title, Date startDate, Date endDate, int amount, String couponTipe, String message,
			double price, String immage) {
		super();
		setId(id);
		setTitle(title);
		setStartDate(startDate);
		setEndDate(endDate);
		setAmount(amount);
		setCouponTipe(couponTipe);
		setMessage(message);
		setPrice(price);
		setImmage(immage);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCouponTipe() {
		return CouponTipe;
	}
	public void setCouponTipe(String couponTipe) {
		CouponTipe = couponTipe;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getImmage() {
		return immage;
	}
	public void setImmage(String immage) {
		this.immage = immage;
	}
	@Override
	public String toString() {
		return "Coupon [id=" + id + ", title=" + title + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", amount=" + amount + ", CouponTipe=" + CouponTipe + ", message=" + message + ", price=" + price
				+ ", immage=" + immage + "]";
	}
	
	
	
	
}

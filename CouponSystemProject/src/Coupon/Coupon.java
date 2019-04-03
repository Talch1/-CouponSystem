package Coupon;

import java.sql.Date;

public class Coupon {

	private static int id;
	private static String title;
	private static Date startDate;
	private static Date endDate;
	private static int amount;
	private static String type;
	private static String message;
	private static double price;
	private static String image;

	public Coupon(int id, String title, Date startDate, Date endDate, int amount, String couponTipe, String message,
			double price, String immage) {
		super();
		setId(id);
		setTitle(title);
		setStartDate(startDate);
		setEndDate(endDate);
		setAmount(amount);
		setType(type);
		setMessage(message);
		setPrice(price);
		setImage(immage);
	}

	public static int getId() {
		return id;
	}

	public static String getImage() {
		return image;
	}

	public static void setImage(String image) {
		Coupon.image = image;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public static Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public static  Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public static int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public static String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}



	@Override
	public String toString() {
		return "Coupon [id=" + id + ", title=" + title + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", amount=" + amount + ", type=" + type + ", message=" + message + ", price=" + price + ", immage="
				+ image + "]";
	}

}

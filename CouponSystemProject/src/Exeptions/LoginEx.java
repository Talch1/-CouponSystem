package Exeptions;

public class LoginEx extends Exception{

	private String message;
	public LoginEx(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public LoginEx(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public LoginEx(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	

	public LoginEx(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}

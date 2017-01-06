package mx.com.gpsamigo.exceptions;

public class GeneralException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GeneralException(int code, String message) {
		super(message);
		this.code = code;
	}

	private int code;
	
	public GeneralException() {
		// TODO Auto-generated constructor stub
	}

	public GeneralException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}

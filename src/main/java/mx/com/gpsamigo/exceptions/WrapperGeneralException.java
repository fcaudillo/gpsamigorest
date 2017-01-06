package mx.com.gpsamigo.exceptions;

public class WrapperGeneralException {

	int code;
    String message;
	
	public WrapperGeneralException(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

    
	public WrapperGeneralException() {
		// TODO Auto-generated constructor stub
	}


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}

}

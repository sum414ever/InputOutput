package info.sjd;


@SuppressWarnings("serial")
public class MyIOException extends Exception {

	public MyIOException() {
		super();

	}

	public MyIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public MyIOException(String message, Throwable cause) {
		super(message, cause);

	}

	public MyIOException(String message) {
		super(message);

	}

	public MyIOException(Throwable cause) {
		super(cause);

	}

}

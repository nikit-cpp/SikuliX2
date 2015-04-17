package my.superpackage;

public class LoadLibException extends Exception {

	private static final long serialVersionUID = 1L;

	public LoadLibException() {
	}

	public LoadLibException(String message) {
		super(message);
	}

	public LoadLibException(Throwable cause) {
		super(cause);
	}

	public LoadLibException(String message, Throwable cause) {
		super(message, cause);
	}

	public LoadLibException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

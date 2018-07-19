package teaop.exception;

/**
 * @since 2018年7月19日 上午11:07:26
 * @version 1.0.0
 * @author 
 *
 */
public class BeanException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public BeanException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public BeanException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public BeanException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public BeanException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public BeanException(Throwable cause) {
		super(cause);
	}

}

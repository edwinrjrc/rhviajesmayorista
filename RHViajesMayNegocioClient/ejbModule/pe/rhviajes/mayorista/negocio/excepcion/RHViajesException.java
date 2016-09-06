/**
 * 
 */
package pe.rhviajes.mayorista.negocio.excepcion;

/**
 * @author Edwin
 *
 */
public class RHViajesException extends Exception {

	private static final long serialVersionUID = -2548925410840756768L;

	public RHViajesException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public RHViajesException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public RHViajesException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public RHViajesException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public RHViajesException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}

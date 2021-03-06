package fr.loria.orpailleur.revisor.engine.core.console.exception;

/**
 * @author William Philbert
 */
public class InstructionException extends Exception {
	
	// Constants :
	
	private static final long serialVersionUID = 1L;
	
	// Constructors :
	
	public InstructionException() {
		super();
	}
	
	public InstructionException(String message) {
		super(message);
	}
	
	public InstructionException(Throwable throwable) {
		super(throwable);
	}
	
	public InstructionException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public InstructionException(String message, Throwable cause, boolean enableSuppression,
	boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
}

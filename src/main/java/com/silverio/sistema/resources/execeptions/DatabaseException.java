package com.silverio.sistema.resources.execeptions;

/**
 * Custom exception class to represent database-related exceptions.
 * Extends the RuntimeException class, making it an unchecked exception.
 */
public class DatabaseException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor to create a DatabaseException with a specific error message.
	 * 
	 * @param msg The error message describing the reason for the exception.
	 */
	public DatabaseException(String msg) {
		super(msg);
	}

}

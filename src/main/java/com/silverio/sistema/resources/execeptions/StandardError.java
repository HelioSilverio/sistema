package com.silverio.sistema.resources.execeptions;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Represents a standardized error response for exceptions in the application.
 */
public class StandardError implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant timestamp ;// Timestamp of when the error occurred
	private Integer status;// HTTP status code
	private String error;// Short error description
	private String message;// Detailed error message
	private String path;// URI path where the error was encountered
	
	public StandardError() {
		
	}
	/**
     * Creates a new instance of StandardError.
     *
     * @param timestamp Timestamp of when the error occurred
     * @param status    HTTP status code
     * @param error     Short error description
     * @param message   Detailed error message
     * @param path      URI path where the error was encountered
     */
	public StandardError(Instant timestamp, Integer status, String error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}
	// Getters and setters
	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	

}
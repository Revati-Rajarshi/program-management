package com.programmanagement.exception;

public class NoContentException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String details;

	public NoContentException() {
	}
	
	public NoContentException(String details) {
		super();
		this.details = details;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}

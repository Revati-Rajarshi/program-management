package com.programmanagement.exception;

public class ProgramNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private Long field;
	
	public ProgramNotFoundException() {}
	
	public ProgramNotFoundException(String message, Long field) {
		super();
		this.message = message;
		this.field = field;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getField() {
		return field;
	}
	public void setField(Long field) {
		this.field = field;
	}
	
}

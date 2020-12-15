package com.programmanagement.dto;

public class ErrorDto {
	private String code;
	private String message;
	private Long field;
	private String details;
	
	public ErrorDto() {}
	
	public ErrorDto(String code, String message, Long field) {
		super();
		this.code = code;
		this.message = message;
		this.field = field;
	}
	public ErrorDto(String code, String message, String details) {
		super();
		this.code = code;
		this.message = message;
		this.details = details;
	}
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
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

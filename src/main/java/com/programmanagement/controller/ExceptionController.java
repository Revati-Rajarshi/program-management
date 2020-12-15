package com.programmanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.programmanagement.dto.ErrorDto;
import com.programmanagement.exception.NoContentException;
import com.programmanagement.exception.ProgramNotFoundException;

@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(ProgramNotFoundException.class)
	public ResponseEntity<List<ErrorDto>> handleNotFoundException(ProgramNotFoundException e){
		final String message = "The provided id is not in DB" + e.getMessage() + "not found";
		final List<ErrorDto> errorDto = new ArrayList<>();
		errorDto.add(new ErrorDto("404",message,e.getField()));
		return new ResponseEntity<>(errorDto,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoContentException.class)
	public ResponseEntity<List<ErrorDto>> handleNotFoundException(NoContentException e){
		final String message = "Database is empty";
		final List<ErrorDto> errorDto = new ArrayList<>();
		errorDto.add(new ErrorDto("500",message,e.getDetails()));
		return new ResponseEntity<>(errorDto,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}

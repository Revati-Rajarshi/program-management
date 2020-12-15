package com.programmanagement.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programmanagement.model.Programs;
import com.programmanagement.service.ProgramServiceImpl;



@RestController
@RequestMapping(value = "/api/v1/programs")
public class ProgramController {
	
	Logger logger = LoggerFactory.getLogger(ProgramController.class);
	@Autowired
	private ProgramServiceImpl programService;
	
	@PostMapping
	public Programs addProgram(@Validated @RequestBody Programs program){
		logger.info("Processing the request for adding program");
		return programService.addProgram(program);
	}
	
	@GetMapping
	public List<Programs> getAllPrograms(){
		logger.info("Processing the request for fetching all programs from database");
		return programService.getAllPrograms();
	}
	
	@GetMapping(value = "/{pid}")
	public Programs getProgramById(@PathVariable("pid") Long pid) {
		logger.info("Processing the request for fetching program with id {}",pid);
		Programs program =  programService.getProgramById(pid);
		return program;
	}
	
	@PutMapping(value = "/{pid}")
	public Programs updateProgram(@Validated @PathVariable("pid")Long pid, @RequestBody Programs program) {
		logger.info("Processing the request for updating program with id {}",pid);
		return programService.updateProgram(pid, program);	
	}
	
	@DeleteMapping(value = "/{pid}")
	public ResponseEntity<Object> deleteProgramById(@PathVariable("pid") Long pid) {
		logger.info("Processing the request for deleting program with id {}",pid);
		programService.deleteProgramById(pid);
		return ResponseEntity.ok().build();
	}
}

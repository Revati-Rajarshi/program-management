package com.programmanagement.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.programmanagement.repository.ProgramRepository;
import com.programmanagement.exception.NoContentException;
import com.programmanagement.exception.ProgramNotFoundException;
import com.programmanagement.model.Programs;

@Service
public class ProgramServiceImpl implements ProgramDetailsService{
	
	@Autowired
	private ProgramRepository programRepository;
	
	Logger logger = LoggerFactory.getLogger(ProgramServiceImpl.class);
	
	
	public Programs findProgramById(Long pid) {
		Programs program = this.programRepository.findById(pid).orElse(null);
		if(null == program) {
			logger.error("An error occured - trying to fetch program with id {} which is not available",pid);
			throw new ProgramNotFoundException(" programId ",pid);
		}
		else {
			return program;
		}
	}
	
	public Programs addProgram(Programs program) {
		logger.info("Adding program to database");
		return this.programRepository.save(program);
	}

	public List<Programs> getAllPrograms(){
		List<Programs> programList = this.programRepository.findAll();
		if(programRepository.findAll().isEmpty()) {
			logger.error("An error occured - trying to fetch empty database");
			throw new NoContentException(" try creating a program ");
		}
		else {
			logger.info("Returning list of programs from database");
			return programList;
		}
	}
	
	public Programs getProgramById(Long pid) {
		logger.info("Returning program with id {}",pid);
		return findProgramById(pid);		
	}
	
	public Programs updateProgram(Long pid, Programs program) {
		Programs existing = getProgramById(pid);
		
		existing.setPname(program.getPname());
		existing.setDetails(program.getDetails());
		existing.setActive(program.getActive());
		logger.info("Updating program with id {}",pid);
		return this.programRepository.save(existing);
		
		
	}
	
	public void deleteProgramById(Long pid) {
		Programs existing = getProgramById(pid);
		logger.info("Deleting program with id {}",pid);
		programRepository.delete(existing);
		
	}
}

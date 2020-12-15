package com.programmanagement.service;

import java.util.List;

import com.programmanagement.model.Programs;

public interface ProgramDetailsService {
	
	/**
	 * This method adds a new program to database
	 * @param program
	 * @return Programs
	 */
	public Programs addProgram(Programs program);
	
	/**
	 * This method returns a list of Programs in database
	 * @return List 
	 */
	public List<Programs> getAllPrograms();
	
	/**
	 * This method returns program details of a program with specified id
	 * @param pid
	 * @return Programs
	 * @throws ProgramNotFoundException
	 */
	public Programs getProgramById(Long pid);
	
	/**
	 * This method updates the details of a program with specified id
	 * @param pid
	 * @param program
	 * @return Programs
	 * @throws ProgramNotFoundException
	 */
	public Programs updateProgram(Long pid, Programs program);
	
	/**
	 * This method deletes the details of a program with specified id
	 * @param pid
	 */
	public void deleteProgramById(Long pid);
	
	/**
	 * 
	 * This method finds program with specified id
	 * @param pid
	 * @return Programs
	 */
	public Programs findProgramById(Long pid);
}

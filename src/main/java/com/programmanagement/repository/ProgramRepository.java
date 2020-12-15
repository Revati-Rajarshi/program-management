package com.programmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programmanagement.model.Programs;

/**
 * 
 * Repository to access Program's data from database, extends JpaRepository
 *
 */
@Repository
public interface ProgramRepository extends JpaRepository<Programs,Long> {

}

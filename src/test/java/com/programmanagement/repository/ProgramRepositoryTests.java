package com.programmanagement.repository;



import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.programmanagement.model.Programs;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProgramRepositoryTests {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private ProgramRepository programDAO;
	
	@Test
	public void testSaveProgram() {
		Programs program = getProgram();
		Programs savedInDB = entityManager.persist(program);
		Programs getFromDB = programDAO.findById(savedInDB.getPid()).get();
			
		assertThat(getFromDB).isEqualTo(savedInDB);
	}
	
	@Test
	public void testGetProgramById() {
		Programs program = new Programs();
		program.setPname("program1");
		program.setDetails("details");
		program.setActive(true);
		
		Programs programSavedInDB = entityManager.persist(program);
		Programs programFromDB = programDAO.findById(programSavedInDB.getPid()).get();
		
		assertThat(programSavedInDB).isEqualTo(programFromDB);	
	}
	
	@Test
	public void testGetAllPrograms() {
		Programs program1 = new Programs();
		program1.setPname("program1");
		program1.setDetails("details1");
		program1.setActive(true);
		
		Programs program2 = new Programs();
		program2.setPname("program2");
		program2.setDetails("details2");
		program2.setActive(true);
		
		Programs program1SavedInDB = entityManager.persist(program1);
		Programs program1FromDB = programDAO.findById(program1SavedInDB.getPid()).get();
		
		entityManager.persist(program2);
		
		entityManager.remove(program1FromDB);
		
		Iterable<Programs> allProgramsFromDB = programDAO.findAll();
		List<Programs> programList = new ArrayList<>();
		
		for(Programs program : allProgramsFromDB) {
			programList.add(program);
		}
		
		assertThat(programList.size()).isEqualTo(1);	
	}
	
	@Test
	public void testDeleteProgram() {
		Programs program1 = new Programs();
		program1.setPname("program1");
		program1.setDetails("details1");
		program1.setActive(true);
		
		Programs program2 = new Programs();
		program2.setPname("program2");
		program2.setDetails("details2");
		program2.setActive(true);
		
		entityManager.persist(program1);
		entityManager.persist(program2);
		
	}
	
	private Programs getProgram() {
		Programs program = new Programs();
		program.setPname("program1");
		program.setDetails("details");
		program.setActive(true);
		return program;
	}
	
	

}


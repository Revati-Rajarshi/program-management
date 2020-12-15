package com.programmanagement.service;

import static org.junit.jupiter.api.Assertions.*;




import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.programmanagement.model.Programs;
import com.programmanagement.repository.ProgramRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProgramServiceImplTests {
	
	@Autowired
	private ProgramServiceImpl programService;
	
	@MockBean
	private ProgramRepository programDAO;
	
	@Test
	public void testAddProgram() {
		Programs program = new Programs();
		program.setPid((long) 1);
		program.setPname("program1");
		program.setDetails("details");
		program.setActive(true);
		
		Mockito.when(programDAO.save(program)).thenReturn(program);
		
		assertThat(programService.addProgram(program)).isEqualTo(program);
	}
	
	@Test
	public void testGetProgram() {
		Programs program = new Programs();
		program.setPid((long)1);
		program.setPname("program1");
		program.setDetails("details");
		program.setActive(true);
		
		Mockito.when(programDAO.findById((long) 1)).thenReturn(Optional.of(program));
		
		assertThat(programService.getProgramById((long)1)).isEqualTo(program);
	}

	@Test
	public void testGetAllPrograms() {
		Programs program1 = new Programs();
		program1.setPname("program1");
		program1.setDetails("details");
		program1.setActive(true);
		
		Programs program2 = new Programs();
		program2.setPname("program1");
		program2.setDetails("details");
		program2.setActive(true);	
		
		List<Programs> programList = new ArrayList<>();
		programList.add(program1);
		programList.add(program2);
		
		Mockito.when(programDAO.findAll()).thenReturn(programList);
		
		assertThat(programService.getAllPrograms()).isEqualTo(programList);
		
	}
	
	@Test
	public void testUpdateProgram() throws Exception{
		Programs program = new Programs();
		program.setPid((long) 1);
		program.setPname("program1");
		program.setDetails("details");
		program.setActive(true);
		
		Mockito.when(programDAO.findById((long) 1)).thenReturn(Optional.of(program));
		
		program.setDetails("detailsupdated");
		Mockito.when(programDAO.save(program)).thenReturn(program);
		
		assertThat(programService.updateProgram((long) 1, program)).isEqualTo(program);
	}
	
	@Test
	public void testDeleteProgram() {
		Programs program = new Programs();
		program.setPid((long) 1);
		program.setPname("program1");
		program.setDetails("details");
		program.setActive(true);
		
		Mockito.when(programDAO.findById((long) 1)).thenReturn(Optional.of(program));
		Mockito.when(programDAO.existsById(program.getPid())).thenReturn(false);
		
		assertFalse(programDAO.existsById(program.getPid()));
		
	}

}

package org.acumen.training.codes.test;

import java.time.LocalDate;
import java.util.List;

import org.acumen.training.codes.dao.ProjectDao;
import org.acumen.training.codes.model.Project;
import org.junit.jupiter.api.Test;

public class TestProjectDao {
	
	@Test
	public void testInsert() {
		ProjectDao dao = new ProjectDao("hrms_pu");
		Project project= new Project();
		project.setId((short)20);
		project.setProjname("Housing Loan App");
		project.setProjdate(LocalDate.of(2025, 2, 23));
		dao.insert(project);
		System.out.println("Inserted 1 record");
	}
	@Test
	public void testUpdate() {
		ProjectDao dao = new ProjectDao("hrms_pu");
		dao.updateProjnameById(LocalDate.of(2026, 12, 12), 20);
		
	}
	@Test
	public void testDeleteById() {
		ProjectDao dao = new ProjectDao("hrms_pu");
		dao.deleteById(20);
		
	}
	@Test
	public void testSelectAllProject() {
		ProjectDao dao = new ProjectDao("hrms_pu");
		List<Project>recs=dao.selectAllProject();
		System.out.println(recs);
		
	}

}

package org.forwork.mapper;

import java.util.List;

import org.forwork.domain.Sprint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={org.forwork.config.RootConfig.class})
@Log4j
public class SprintMapperTests {
	
	@Setter(onMethod_=@Autowired)
	private SprintMapper mapper;
	
//	@Test
//	public void testMapper(){
//		log.info(mapper);
//	}
//	
//	@Test
//	public void testInsertSprint(){
//		
//		Sprint sprint = new Sprint();
//		
//		sprint.setSprint_title("1�� ������Ʈ");
//		sprint.setSprint_color("red");
//		sprint.setSprint_start_date("2021/05/12");
//		sprint.setSprint_end_date("2021/05/28");
//		
//		mapper.insertSprint(sprint);
//	}
//	
//	@Test
//	public void testGetSprint(){
//		
//		int sprint_id = 28;
//		
//		Sprint sprint = mapper.getSprint(sprint_id);
//		
//		log.info(sprint);		
//		
//	}
//	
//	@Test
//	public void testListSprint(){
//		
//		List<Sprint> list = mapper.listSprint();
//		
//		list.forEach(sprint-> log.info(sprint));
//
//	}
//	
//	@Test
//	public void testDeleteSprint(){
//		
//		int sprint_id = 41;
//		
//		mapper.deleteSprint(sprint_id);
//	}
//	
//	
//	@Test
//	public void testUpdateSprint(){
//		
//		int sprint_id = 27;
//		
//		Sprint sprint = mapper.getSprint(sprint_id);
//		
//		sprint.setSprint_title("������ ����");
//		sprint.setSprint_color("blue");
//		sprint.setSprint_start_date("2021/05/01");
//		sprint.setSprint_end_date("2021/06/01");
//		
//		int count = mapper.updateSprint(sprint);
//		
//		log.info("UPDATE COUNT: " + count);
//	}
//	
//	
//	
	
	@Test
	public void today(){
		log.info(mapper);
	}
	
	
	
	
	
}

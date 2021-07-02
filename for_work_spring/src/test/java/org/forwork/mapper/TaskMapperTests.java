package org.forwork.mapper;

import org.forwork.domain.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={org.forwork.config.RootConfig.class})
@Log4j
public class TaskMapperTests {
	

	@Setter(onMethod_=@Autowired)
	public TaskMapper mapper;
	

//	@Test
//	public void testInsertTask(){
//		
//		Task task = new Task();
//		
//		task.setTask_content("�α��� ����");
//		task.setTask_index("1");
//		task.setWriter("�̰���");
//		
//		mapper.insertTask(task);
//	}
//
//	@Test
//	public void testListTask(){
//		
//		mapper.listTask().forEach(task->log.info(task));
//	}
//	
//	@Test
//	public void testDeleteTask(){
//		
//		int task_id = 85;
//		int count = mapper.deleteTask(task_id);
//		log.info("DELETE RESULT: " + count);
//
//	}
//	
//	@Test
//	public void testUpdateTask(){
//		
//		Task task = new Task();
//		task.setTask_content("��������!!!");
//		task.setTask_id("84");
//		
//		int count = mapper.updateTask(task);
//		log.info("UPDATE RESULT: " + count);
//	}
//	
//	@Test
//	public void testDetailTask(){
//		
//		log.info(mapper.detailTask(65));
//	}
//	
//	@Test
//	public void testMapper(){
//		
//		log.info(mapper);
//	}
//	@Test
//	public void testDecrease(){
//		mapper.decreaseUpdate("2", "1");
//	}
//	@Test
//	public void testIncrease(){
//		mapper.increaseUpdate("1", "2");
//	}
//	@Test
//	public void getUpdateTest(){
//		Task task = mapper.detailTask(23);
//		log.info(task);
//		task.setTask_index("1");
//		task.setTask_type_id("2");
//		mapper.moveTask(task);
//	}
	@Test
	public void getSprintTest(){
		log.info(mapper.getSprint(8));
	}
	
}

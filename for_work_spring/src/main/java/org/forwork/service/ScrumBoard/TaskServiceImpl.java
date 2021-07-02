package org.forwork.service.ScrumBoard;

import java.util.List;
import java.util.Map;

import org.forwork.domain.Project;
import org.forwork.domain.Task;
import org.forwork.domain.TaskLog;
import org.forwork.domain.Todolist;
import org.forwork.mapper.SprintMapper;
import org.forwork.mapper.TaskLogMapper;
import org.forwork.mapper.TaskMapper;
import org.forwork.mapper.TodolistMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
	
	private TaskMapper mapper;
	private TaskLogMapper logMapper;
	private TodolistMapper todoMapper;
	private SprintMapper sprintMapper;

	@Override
	@Transactional
	public int insertTask(Task task) {
		int project_id = Integer.parseInt(task.getProject_id());
		String content = "create task by." + task.getWriter_name(); // log 내용 생성
		log.info("INSERT TASK.....!!!!" + task);
		if(mapper.maxIndex() == null){			
			task.setTask_index("1"); // stories column index 계산
		}else{
			task.setTask_index((mapper.maxIndex()+1)+""); // stories column index 계산
		}
		String sprint_id = sprintMapper.todaySprint(task.getProject_id());
		sprint_id = sprint_id == null ? "" : sprint_id;
		
		mapper.insertTask(task);
		if(sprint_id != ""){
			sprintMapper.addTaskSprintRelation(task.getTask_id(), sprint_id); // 관계 추가
			logMapper.insertLog(task.getTask_id(), content, project_id);
			return logMapper.insertLog(task.getTask_id(), "task_sprint_relation auto create", project_id);
		}
		return logMapper.insertLog(task.getTask_id(), content, project_id);
	}

	@Override
	public List<Task> listTask(String project_id) {
		log.info("GET TASK LIST.....!!!!" );
		
		return mapper.listTask(project_id);
	}

	@Override
	@Transactional
	public int deleteTask(int task_id) {
		int project_id = 1;
		String member_name = "tester";
		String content = "delete task by." + member_name;
		logMapper.insertLog(task_id+"", content, project_id);
		log.info("DELETE TASK.....!!!!" + task_id);
		
		return mapper.deleteTask(task_id);
	}

	@Override
	@Transactional
	public int updateTask(Task task,String member_name) {
		int project_id = 1;
		Task beforeTask = mapper.detailTask(Integer.parseInt(task.getTask_id()));
		String content = "change content Before : " + beforeTask.getTask_content()
			+" Now : " + task.getTask_content()+" by."+member_name;
		
		log.info("UPDATE TASK.....!!!!" + task);
		logMapper.insertLog(task.getTask_id(), content, project_id);
		return mapper.updateTask(task);
	}

	@Override
	public Task detailTask(int task_id) {

		log.info("DETAIL TASK.....!!!!" + task_id);
		
		return mapper.detailTask(task_id);
	}

	@Override
	@Transactional
	public int moveTask(Map<String, String> changeData,String member_name) {
		int project_id = 1;

		String content = null;
		log.info("move task : " + changeData.toString());
		Task task = mapper.detailTask(Integer.parseInt(changeData.get("task_id")));

		switch (Integer.parseInt(task.getTask_type_id())) {
		case 1:content = "move task Before column : Stories";
			break;
		case 2:content = "move task Before column : To-Do"; break;
		case 3:content = "move task Before column : Doing"; break;
		case 4 :content = "move task Before column : Done"; break;
		default:
			break;
		}
		
		mapper.decreaseUpdate(changeData.get("previdx"), task.getTask_type_id());
		
		String type_id = null;
		switch (changeData.get("col_name")) {
			case "Stories":
				type_id = "1";break;
			case"To-Do":
				type_id = "2";break;
			case"Doing":
				type_id = "3";break;
			case"Done":
				type_id = "4";break;
			default:break;
		}
		content += " Now column : "+changeData.get("col_name")+" by. "+member_name;

		mapper.increaseUpdate(changeData.get("nowidx"), type_id);
		
		task.setTask_index(changeData.get("nowidx"));
		task.setTask_type_id(type_id);
		log.info("update task : " + task);
		logMapper.insertLog(task.getTask_id(), content, project_id);
		return mapper.moveTask(task);
	}

	@Override
	@Transactional
	public int addRes(int task_id, String member_id,String member_name) {
		log.info("add Res");
		Task task = mapper.detailTask(task_id);
		String beforeName = task.getName() == null ? "null" : task.getName();
		String content = "Add Responsibility Before : " + beforeName + " Now : "+member_name;
		task.setResponsibility(member_id);
		task.setName(member_name);
		int project_id = 1;
		logMapper.insertLog(task_id+"", content, project_id);
		return mapper.addResponsibility(task);
	}

	@Override
	public TaskLog getLog(int task_id) {
		TaskLog log = logMapper.getLog(task_id+"");
		if(log == null){
			return new TaskLog();
		}
		return log;
	}

	@Override
	public List<TaskLog> getLogs(int task_id) {
		return logMapper.getLogList(task_id);
	}

	@Override
	public int getSprintId(int task_id) {
		if(mapper.getSprint(task_id) == null){
			return 0;
		}
		return mapper.getSprint(task_id);
	}
	
	@Override
	public Project getPr(int project_id) {

		log.info("GET One Project...!!!");
		
		return mapper.getPr(project_id);
	}

	@Override
	public int sendTodo(int task_id) {
		Task task = mapper.detailTask(task_id);
		System.out.println(task);
		Todolist todo = new Todolist();
		todo.setTodolist_content(task.getTask_content());
		todo.setMember_id(Integer.parseInt(task.getResponsibility()));
		System.out.println(todo);
		return todoMapper.insertTodolist(todo);
	}
	
	
	@Transactional
	public int modifyTaskSprintRelation(String sprint_id, String task_id) {
		if(mapper.getSprint(Integer.parseInt(task_id)) != null){
			return sprintMapper.updateTaskSprintRelation(task_id, sprint_id);
		}else{
			return sprintMapper.addTaskSprintRelation(task_id, sprint_id);
		}
	}

}

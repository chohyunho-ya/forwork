package org.forwork.service.todolist;

import java.util.List;

import org.springframework.stereotype.Service;
import org.forwork.domain.Todolist;
import org.forwork.mapper.TodolistMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class TodolistServiceImpl implements TodolistService {
	
	private TodolistMapper mapper;

	@Override
	public int insert(Todolist todolist) {
		log.info("?�� ?�� 추�?");
		
		return mapper.insertTodolist(todolist);
	}

	@Override
	public List<Todolist> memberTodolist(int member_id) {
		log.info("?��?���? ?�� ?�� 목록");
		
		return mapper.selectTodolist(member_id);
	}

	@Override
	public int updateDone(int todolist_id) {
		log.info("?�� ?�� ?���?");
		
		return mapper.updateDonelist(todolist_id);
	}

	@Override
	public List<Todolist> doingList(int member_id) {
		log.info("?��?�� ?�� ?�� 목록");
		
		return mapper.selectDoinglist(member_id);
	}

	@Override
	public List<Todolist> doneList(int member_id) {
		log.info("?��료된 ?�� ?�� 목록");
		
		return mapper.selectDonelist(member_id);
	}

	@Override
	public int delete(int todolist_id) {
		log.info("?�� ?�� 1�? ?��?��");
		
		return mapper.deleteTodolist(todolist_id);
	}

	@Override
	public int deleteAll(int member_id) {
		log.info("?��료된 ?�� ?�� ?���? ?��?��");
		
		return mapper.deleteAllDonelist(member_id);
	}

	@Override
	public int update(Todolist todolist) {
		log.info("?�� ?�� ?��?��");
			
		return mapper.updateTodolist(todolist);
	}

}

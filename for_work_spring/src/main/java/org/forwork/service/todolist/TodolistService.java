package org.forwork.service.todolist;

import java.util.List;

import org.forwork.domain.Todolist;

public interface TodolistService {

	public int insert(Todolist todolist);
	
	public List<Todolist> memberTodolist(int member_id);
	
	public int updateDone(int todolist_id);
	
	public List<Todolist> doingList(int member_id); // ?•´?•¼ ?•  ?¼ ëª©ë¡
	
	public List<Todolist> doneList(int member_id); // ?™„ë£Œëœ ?•  ?¼ ëª©ë¡
	
	public int delete(int todolist_id);
	
	public int deleteAll(int member_id);
	
	public int update(Todolist todolist);
}

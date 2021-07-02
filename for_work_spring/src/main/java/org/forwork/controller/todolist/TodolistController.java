package org.forwork.controller.todolist;


import org.forwork.domain.Todolist;
import org.forwork.service.todolist.TodolistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/todolist/")
@RestController
@Log4j
@AllArgsConstructor
public class TodolistController {

	private TodolistService service;
	
	@PostMapping(value = "/new", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> create(@RequestBody Todolist todolist) {
		log.info("todolist: " + todolist);
		
		int insertCount = service.insert(todolist);
		log.info("할 일 추가: " + insertCount);
		
		return insertCount == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(method = { RequestMethod.PUT, RequestMethod.PATCH }, value = "/{todolist_id}", 
			consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> modify(@RequestBody Todolist todolist, @PathVariable("todolist_id") int todolist_id) {
		todolist.setTodolist_id(todolist_id);
		log.info("todolist_id: " + todolist_id);
		log.info("TO DO LIST 수정: " + todolist);
		
		return service.update(todolist) == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@RequestMapping(method = { RequestMethod.PUT, RequestMethod.PATCH }, value = "/done/{todolist_id}", 
			consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> modifyDone(@PathVariable("todolist_id") int todolist_id) {
		log.info("update done list: " + todolist_id);
		
		return service.updateDone(todolist_id) == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping(value = "/{todolist_id}", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> remove(@PathVariable("todolist_id") int todolist_id) {
		log.info("TO DO LIST 삭제: " + todolist_id);
		
		return service.delete(todolist_id) == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@DeleteMapping(value = "/done/{member_id}", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> removeAllDone(@PathVariable("member_id") int member_id) {
		log.info("delete all done list: " + member_id);
		
		return service.deleteAll(member_id) == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
	
}

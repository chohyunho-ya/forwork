package org.forwork.controller.ScrumBoard;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.List;

import org.forwork.domain.Sprint;
import org.forwork.service.ScrumBoard.SprintService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sprint/")
@Log4j
@AllArgsConstructor
public class SprintController {

	private SprintService service;
	
	@PostMapping(value="/add", consumes="application/json", produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> insertSprint(@RequestBody Sprint sprint){
		
		log.info("Sprint : " + sprint);
		
		int insertCount = service.insertSprint(sprint);
		
		log.info("Sprint INSERT COUNT: " + insertCount);
		
		return insertCount == 1 ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@GetMapping(value="/list/{projcet_id}", produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<Sprint>> listSprint(@PathVariable("projcet_id")String projcet_id){
		
		log.info("getList...........!!!!");
		
		return new ResponseEntity<>(service.listSprint(projcet_id), HttpStatus.OK);
	}
	
	@GetMapping(value="/{sprint_id}", produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<Sprint> getSprint(@PathVariable("sprint_id") int sprint_id){
		
		log.info("GET : " + sprint_id);
		
		return new ResponseEntity<>(service.getSprint(sprint_id), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{sprint_id}", produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> deleteSprint(@PathVariable("sprint_id") int sprint_id){
		
		log.info("Delete: " + sprint_id);
		
		return service.deleteSprint(sprint_id)==1 ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(method={RequestMethod.PUT, RequestMethod.PATCH}, value="/{sprint_id}", consumes="application/json", produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> updateSprint(@RequestBody Sprint sprint, @PathVariable("sprint_id") int sprint_id){
		
		String sprintId = ""+ sprint_id;
		sprint.setSprint_id(sprintId);
		
		log.info("sprint_id : " + sprint_id);
		
		log.info("modify: " + sprint);
		
		return service.updateSprint(sprint)==1 ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

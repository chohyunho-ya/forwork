package org.forwork.controller.PMOPage;


import java.util.List;

import org.forwork.domain.Board;
import org.forwork.domain.Member;
import org.forwork.domain.Portfolio;
import org.forwork.domain.Project;
import org.forwork.dto.PMODto;
import org.forwork.service.PMOPage.PMOPageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
@AllArgsConstructor
public class PMOPageController {
	private PMOPageService service;
	
	@GetMapping(value = "/PMOpage/{project_id}/status_id",
			produces={
					MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<PMODto> getStatusId(@PathVariable("project_id") String project_id){

		return new ResponseEntity<PMODto>(service.getProject(project_id),HttpStatus.OK);
	}
	
//	@RequestMapping(method={RequestMethod.GET, RequestMethod.PATCH},	
//			value="/{project_id}/update",
//			consumes="application/json",
//			produces={MediaType.TEXT_PLAIN_VALUE})


	
//	@RequestMapping(value="/4/update", method=RequestMethod.PUT)		
//	public String hello(){
//		System.out.println("!!!!!!!!!!!!");
//		return "야호";
//	}
	
	

	@PutMapping(value="/PMOpage/{project_id}/update",consumes="application/json")
	public ResponseEntity<String> update(@PathVariable("project_id") String project_id,
			@RequestBody PMODto dto){
		System.out.println("!!!!!!!!!!!!!");
		System.out.println(dto.toString());
//		dto.setProject_id(project_id);
		
		String approval_id= dto.getApproval_id();
		System.out.println("----------ok"+approval_id);
		log.info("========================= ");
		return service.update(dto)==1
				? new ResponseEntity<>("success",HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}

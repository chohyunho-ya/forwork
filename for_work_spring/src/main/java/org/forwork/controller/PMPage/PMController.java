package org.forwork.controller.PMPage;

import java.util.List;


import org.forwork.domain.Project;
import org.forwork.domain.ProjectLanguage;
import org.forwork.domain.TeamProgress;
import org.forwork.service.PMPage.PMPageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/pmPage/")
@RestController
@Log4j
@AllArgsConstructor
public class PMController {
	
	private PMPageService service;
	
	@GetMapping(value="/{project_id}/getColumnPr", produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<TeamProgress> getTeamProgress(@PathVariable("project_id") int project_id){
		
		log.info("GET COLUMN COUNT....!");
		
		return new ResponseEntity<>(service.getColumCount(project_id), HttpStatus.OK);
	}
	
	@GetMapping(value="/{project_id}", produces={MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<TeamProgress>> getPersonalCount(@PathVariable("project_id") int project_id){
		
		log.info("GET PERSONAL COUNT...!" +"project_id: "+ project_id);
		
		return new ResponseEntity<>(service.getPersonalCount(project_id),HttpStatus.OK);
				
	}
	
	@GetMapping(value="/getTasks/{project_id}/{responsibility}", produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<TeamProgress>> getPersonalTasks(@PathVariable("project_id") int project_id,@PathVariable("responsibility")int responsibility){
		
		log.info("GET PERSONAL TASKS...!"+"project_id: "+ project_id+" responsibility: " + responsibility );
		
		return new ResponseEntity<>(service.getPersonalTasks(project_id,responsibility),HttpStatus.OK);
	}
	
	@GetMapping(value="/PrSelect/{member_id}", produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<Project>> getProjects(@PathVariable("member_id")int member_id){
		
		log.info("GET PROJECTS...!!!");
		
		return new ResponseEntity<>(service.getProjects(member_id),HttpStatus.OK);
	}
	
	@PostMapping(value="/addLang", consumes="application/json", produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> insertLang(@RequestBody ProjectLanguage prLang){
		
		log.info("Language: "+prLang);
		
		int insertCount = service.insertLang(prLang);
		
		log.info("Language Insert Count: " + insertCount);
		
		return insertCount==1 ? new ResponseEntity<>("success", HttpStatus.OK): new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping(value="/getLang/{project_id}", produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<List<ProjectLanguage>> getLang(@PathVariable("project_id")int project_id){
		
		log.info("Get Languages......!!!");
			
		return new ResponseEntity<>(service.getLang(project_id), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/{pr_lang_seq}",produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> deleteLang(@PathVariable("pr_lang_seq")int pr_lang_seq){
		
		log.info("DELETE Language: " + pr_lang_seq);
		
		return service.deleteLang(pr_lang_seq) == 1 ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping(method = {RequestMethod.PUT, RequestMethod.PATCH}, value="/{pr_lang_seq}", consumes="application/json", produces={MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> updateLang(@RequestBody ProjectLanguage prLang, @PathVariable("pr_lang_seq") int pr_lang_seq){
		
		prLang.setProject_language_seq(pr_lang_seq);
		log.info("pr_lang_seq: " +pr_lang_seq);
		
		return service.updateLang(prLang) == 1 ? new ResponseEntity<>("success", HttpStatus.OK) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@GetMapping(value="/get/{pr_lang_seq}", produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ProjectLanguage> getSeq(@PathVariable("pr_lang_seq") int pr_lang_seq){
		
		log.info("GET : " + pr_lang_seq);
		
		return new ResponseEntity<>(service.getSeq(pr_lang_seq), HttpStatus.OK);
	}
	
	@GetMapping(value="/isPm/{project_id}/{member_id}", produces={MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<Project> isPm(@PathVariable("project_id")int project_id, @PathVariable("member_id")int member_id){
		
		log.info("is PM...? : " + project_id +"/"+ member_id);
		
		return new ResponseEntity<>(service.isPm(project_id, member_id),HttpStatus.OK);
	}

}

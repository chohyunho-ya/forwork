package org.forwork.controller;

import java.util.List;

import org.forwork.domain.Calendar;
import org.forwork.dto.CalendarDto;
import org.forwork.dto.CalendarWeekDto;
import org.forwork.service.CalendarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@AllArgsConstructor
@Log4j
public class CalendarController {
	
	private CalendarService service;
	
	@PostMapping(value="/calendar/add",consumes="application/json")
	public ResponseEntity<String> addCalendar(@RequestBody Calendar cal){
		if(service.registerCalendar(cal)==1){
			return new ResponseEntity<String>("success",HttpStatus.OK);
		}
		return new ResponseEntity<String>("fail",HttpStatus.OK);
	}
	
	@GetMapping(value="/calendar/get/{project_id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<CalendarDto>> getCalendarList(@PathVariable("project_id")String project_id){
		List<CalendarDto> list = null;
		list = service.listCalendar(project_id);
		System.out.println(list.toString());
		return new ResponseEntity<List<CalendarDto>>(list,HttpStatus.OK);
	}
	
	@GetMapping(value="/calendar/getWeek/{project_id}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<CalendarWeekDto>> getCalendarWeek(@PathVariable("project_id")String project_id){
		List<CalendarWeekDto> list = null;
		list = service.listWeek(project_id);
		System.out.println(list.toString());
		return new ResponseEntity<List<CalendarWeekDto>>(list,HttpStatus.OK);
	}
	

	@PostMapping(value="/calendar/update",consumes="application/json")
	public ResponseEntity<String> updateCalendar(@RequestBody Calendar cal){
		if(service.updateCalendar(cal) == 1){
			return new ResponseEntity<>("success",HttpStatus.OK);
		}
		return new ResponseEntity<>("fail",HttpStatus.OK);
	}
	
	@DeleteMapping(value="/calendar/delete/{calendar_id}")
	public ResponseEntity<String> deleteCalendar(@PathVariable("calendar_id")String calendar_id){
		
		if(service.deleteCalendar(calendar_id) == 1){			
			return new ResponseEntity<String>("success",HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("fail",HttpStatus.OK);
	}
}

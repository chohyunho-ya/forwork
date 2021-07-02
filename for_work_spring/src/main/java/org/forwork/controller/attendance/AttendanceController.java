package org.forwork.controller.attendance;

import org.forwork.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class AttendanceController {
	@Setter(onMethod_=@Autowired)
	private AttendanceService service;
	private Gson gson = new Gson();
	
	@GetMapping(value = "/attendance/getWeek/{ago}/{member_id}", produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<String> getAttendance(@PathVariable("ago")String ago, @PathVariable("member_id")String member_id){
		ago = (Integer.parseInt(ago)*7)+"";
		log.info("ago is  : " + ago);
		String week = gson.toJson(service.getWeekWork(ago, member_id));
		return new ResponseEntity<String>(week,HttpStatus.OK);
	}
	
	@GetMapping(value = "/attendance/getTime/{member_id}", produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<String> getRegisterTime(@PathVariable("member_id")String member_id){
		String data = gson.toJson(service.getTime(member_id));
		log.info("data is " + data);
		return new ResponseEntity<String>(data,HttpStatus.OK);
	}
	
	@PostMapping(value="/attendance/commute/{member_id}",produces= MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> commuteRegister(@PathVariable("member_id")String member_id){
		if(service.commuteRegister(member_id) == 1){
			return new ResponseEntity<String>("success",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>("fail",HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping(value="/attendance/off/{member_id}",produces=MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> offRegister(@PathVariable("member_id")String member_id){
		if(service.offRegister(member_id) == 1){
			return new ResponseEntity<String>("success",HttpStatus.OK);
		}else{
			return new ResponseEntity<String>("fail",HttpStatus.NO_CONTENT);
		}
	}
	
}
